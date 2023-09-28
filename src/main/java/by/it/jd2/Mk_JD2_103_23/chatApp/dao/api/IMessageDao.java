package by.it.jd2.Mk_JD2_103_23.chatApp.dao.api;

import by.it.jd2.Mk_JD2_103_23.chatApp.core.dto.Message;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Интерфейс(DAO) для хранения сообщений
 */
public interface IMessageDao {
    void sendMessage(Message message);
    List<Message> viewChat(String userName);
    Map<String, List<Message>> getMessages();
}
