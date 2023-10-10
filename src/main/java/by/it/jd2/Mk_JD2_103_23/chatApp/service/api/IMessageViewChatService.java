package by.it.jd2.Mk_JD2_103_23.chatApp.service.api;

import by.it.jd2.Mk_JD2_103_23.chatApp.storage.entity.Message;

import java.util.List;

/**
 * Интерфейс, сервис для отображения чата
 */
public interface IMessageViewChatService {
    List<Message> viewChat(String userName);

}
