package by.it.jd2.Mk_JD2_103_23.chatApp.service.api;

import by.it.jd2.Mk_JD2_103_23.chatApp.storage.entity.Message;
import by.it.jd2.Mk_JD2_103_23.chatApp.storage.entity.User;

import java.util.List;

/**
 *  Сервис для отправки сообщений
 */
public interface IMessageService {
    /**
     * отправка сообщения
     * @param message
     */
    void send(Message message);

    List<Message> getAllMessages(User currUser);

    void addMessage(MessageCreateDTO message);



}
