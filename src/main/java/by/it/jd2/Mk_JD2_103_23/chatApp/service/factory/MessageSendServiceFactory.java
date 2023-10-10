package by.it.jd2.Mk_JD2_103_23.chatApp.service.factory;

import by.it.jd2.Mk_JD2_103_23.chatApp.dao.factory.MessageDaoFactory;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.MessageSendService;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.api.IMessageService;


public class MessageSendServiceFactory {
    private volatile static MessageSendService instance;

    public MessageSendServiceFactory() {
    }

    public static IMessageService getInstance() {
        if(instance == null){
            synchronized (MessageSendServiceFactory.class){
                if(instance == null){
                    instance = new MessageSendService(MessageDaoFactory.getInstance());
                }
            }
        }
        return instance;
    }
}
