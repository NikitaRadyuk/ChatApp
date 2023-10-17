package by.it.jd2.Mk_JD2_103_23.chatApp.storage.dao;

import by.it.jd2.Mk_JD2_103_23.chatApp.storage.dao.data_source.DBDataSource;
import by.it.jd2.Mk_JD2_103_23.chatApp.storage.entity.Message;
import by.it.jd2.Mk_JD2_103_23.chatApp.storage.dao.api.IMessageDao;

import javax.sql.DataSource;
import java.sql.*;
import java.sql.Date;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Реализация ДАО сообщений
 */
public class MessageDao implements IMessageDao {
    private static final String SEND_MESSAGE_DB = "INSERT INTO messanger.message(\n" +
            "\tsender_name, recipient_name, sending_time, text)\n" +
            "\tVALUES (?, ?, ?, ?);";
    private static final String GET_ALL_MESSAGES_BY_LOGIN = "SELECT sender_name, recipient_name, sending_time, text\n" +
            "\tFROM messanger.message WHERE sender_name = ?;";

    private static final String GET_COUNT_OF_MESSAGES = "SELECT COUNT(*) AS count_messages FROM messanger.message;";
    private final DataSource ds;
    private static final MessageDao instance = new MessageDao();
    private final Map<String, List<Message>> messages = new ConcurrentHashMap<>();

    public MessageDao() {
        this.ds = DBDataSource.getInstance();
    }

    @Override
    public void sendMessage(String login, Message message) {
        List<Message> chat;
        if(this.messages.containsKey(login)){
            chat = this.messages.get(login);
        }else{
            chat = new ArrayList<>();
            this.messages.put(login, chat);
        }
        chat.add(message);

        try(
                Connection conn = ds.getConnection();
                PreparedStatement stm = conn.prepareStatement(SEND_MESSAGE_DB);
                ){
            stm.setString(1, message.getFromUser());
            stm.setString(2, message.getToUser());
            stm.setDate(3, Date.valueOf(message.getSendingDateTime()));
            stm.setString(4, message.getText());

            stm.execute();
        } catch (SQLException e) {
            throw new IllegalStateException("Ошибка сохранения сообщений в БД", e);
        }
    }
    @Override
    public List<Message> viewChat(String login) {
        List<Message> chat = new ArrayList<>();
        try (
                Connection conn = ds.getConnection();
                PreparedStatement stm = conn.prepareStatement(GET_ALL_MESSAGES_BY_LOGIN);
                ResultSet rs = stm.executeQuery()
                ){
                while(rs.next()){
                    Message message = new Message();
                    message.setFromUser(rs.getString("sender_name"));
                    message.setToUser(rs.getString("recipient_name"));
                    message.setSendingDateTime(rs.getDate("sending_time").toLocalDate());
                    message.setText(rs.getString("text"));

                    chat.add(message);
                }
        } catch (SQLException e) {
            throw new IllegalStateException("Ошибка при получении данных о всех сообщениях пользователя",e);
        }
        return chat;
    }

    @Override
    public long getCount() {
        long count = 0;
        try(Connection conn = ds.getConnection();
        PreparedStatement ps = conn.prepareStatement(GET_COUNT_OF_MESSAGES);
        ResultSet rs = ps.executeQuery()){
            count = rs.getInt("count_messages");
            return count;
        } catch (SQLException e) {
            throw new IllegalStateException("Ошибка при получении количества сообщений", e);
        }
    }

    public static MessageDao getInstance(){return instance;}

}
