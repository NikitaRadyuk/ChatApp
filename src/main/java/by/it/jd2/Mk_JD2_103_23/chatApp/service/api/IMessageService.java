package by.it.jd2.Mk_JD2_103_23.chatApp.service.api;

import by.it.jd2.Mk_JD2_103_23.chatApp.core.dto.MessageDTO;
import by.it.jd2.Mk_JD2_103_23.chatApp.storage.entity.Message;
import by.it.jd2.Mk_JD2_103_23.chatApp.storage.entity.User;

import java.util.List;

/**
 *  Интерфейс Сервис для отправки сообщений
 */
public interface IMessageService {
    void send(MessageDTO message);

    List<Message> getAllMessages(User currUser);

    long getCount();
}
