package by.it.jd2.Mk_JD2_103_23.chatApp.service.factory;

import by.it.jd2.Mk_JD2_103_23.chatApp.dao.factory.UserDaoFactory;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.UserRegService;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.api.IUserRegService;

public class UserRegServiceFactory {
    private volatile static UserRegService instance;

    public UserRegServiceFactory() {
    }

    public static IUserRegService getInstance() {
        if(instance == null){
            synchronized (UserRegServiceFactory.class){
                if(instance == null){
                    instance = new UserRegService(UserDaoFactory.getInstance());
                }
            }
        }
        return instance;
    }
}
