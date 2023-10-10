package by.it.jd2.Mk_JD2_103_23.chatApp.service;

import by.it.jd2.Mk_JD2_103_23.chatApp.storage.entity.Message;
import by.it.jd2.Mk_JD2_103_23.chatApp.dao.api.IMessageDao;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.api.IMessageService;

/**
 * Реализация сервиса отправки сообщений
 */
public class MessageSendService implements IMessageService {
    private IMessageDao messageDao;

    public MessageSendService(IMessageDao messageDao) {
        this.messageDao = messageDao;
    }

    @Override
    public void send(Message message) {
        if(message == null){
            throw new IllegalArgumentException();
        }
        messageDao.sendMessage(message);
    }
}
