package by.it.jd2.Mk_JD2_103_23.chatApp.storage.dao.factory;

import by.it.jd2.Mk_JD2_103_23.chatApp.storage.dao.MessageDao;
import by.it.jd2.Mk_JD2_103_23.chatApp.storage.dao.api.IMessageDao;


public class MessageDaoFactory {
    private volatile static MessageDao instance;

    public MessageDaoFactory() {
    }

    public static IMessageDao getInstance() {
        if(instance == null){
            synchronized (MessageDaoFactory.class){
                if(instance == null){
                    instance = new MessageDao();
                }
            }
        }
        return instance;
    }
}
