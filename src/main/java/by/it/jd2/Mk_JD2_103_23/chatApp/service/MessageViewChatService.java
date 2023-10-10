package by.it.jd2.Mk_JD2_103_23.chatApp.service;

import by.it.jd2.Mk_JD2_103_23.chatApp.storage.entity.Message;
import by.it.jd2.Mk_JD2_103_23.chatApp.dao.api.IMessageDao;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.api.IMessageViewChatService;
import java.util.List;

/**
 * Реализация сервиса отображения чата
 */
public class MessageViewChatService implements IMessageViewChatService {
    private IMessageDao messageDao;

    public MessageViewChatService(IMessageDao messageDao) {
        this.messageDao = messageDao;
    }

    @Override
    public List<Message> viewChat(String userName) {
        return this.messageDao.viewChat(userName);
    }
}
