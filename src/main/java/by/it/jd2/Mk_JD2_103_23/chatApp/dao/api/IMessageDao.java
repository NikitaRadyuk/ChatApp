package by.it.jd2.Mk_JD2_103_23.chatApp.dao.api;

import by.it.jd2.Mk_JD2_103_23.chatApp.storage.entity.Message;

import java.util.List;
import java.util.Map;


/**
 * Интерфейс(DAO) для хранения сообщений
 */
public interface IMessageDao {
    void sendMessage(Message message);
    List<Message> viewChat(String userName);
    Map<String, List<Message>> getMessages();
}
