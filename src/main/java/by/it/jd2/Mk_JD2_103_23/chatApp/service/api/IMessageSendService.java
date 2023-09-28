package by.it.jd2.Mk_JD2_103_23.chatApp.service.api;

import by.it.jd2.Mk_JD2_103_23.chatApp.core.dto.Message;

/**
 * Интерфейс, сервис для отправки сообщений
 */
public interface IMessageSendService {
    /**
     * отправка сообщения
     * @param message
     */
    void send(Message message);
}
