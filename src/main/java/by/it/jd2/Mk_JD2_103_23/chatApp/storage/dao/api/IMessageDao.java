package by.it.jd2.Mk_JD2_103_23.chatApp.storage.dao.api;

import by.it.jd2.Mk_JD2_103_23.chatApp.storage.entity.Message;

import java.util.List;

/**
 * Интерфейс(DAO) для хранения сообщений
 */
public interface IMessageDao {
    void sendMessage(String login, Message message);
    List<Message> viewChat(String login);
    long getCount();
}
