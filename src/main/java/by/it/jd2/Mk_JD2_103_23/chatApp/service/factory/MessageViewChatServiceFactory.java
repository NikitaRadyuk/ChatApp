package by.it.jd2.Mk_JD2_103_23.chatApp.service.factory;

import by.it.jd2.Mk_JD2_103_23.chatApp.dao.factory.MessageDaoFactory;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.MessageViewChatService;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.api.IMessageViewChatService;

public class MessageViewChatServiceFactory {
    private volatile static MessageViewChatService instance;
    public MessageViewChatServiceFactory() {
    }

    public static IMessageViewChatService getInstance() {
        if(instance == null){
            synchronized (MessageViewChatServiceFactory.class){
                if(instance == null){
                    instance = new MessageViewChatService(MessageDaoFactory.getInstance());
                }
            }
        }
        return instance;
    }
}
