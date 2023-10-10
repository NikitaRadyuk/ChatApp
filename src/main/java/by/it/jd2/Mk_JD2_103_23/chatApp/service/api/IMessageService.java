package by.it.jd2.Mk_JD2_103_23.chatApp.service.api;

import by.it.jd2.Mk_JD2_103_23.chatApp.core.dto.MessageCreateDTO;
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
    void send(MessageCreateDTO message);

    List<Message> getAllMessages(User currUser);

    long getCount();
}
