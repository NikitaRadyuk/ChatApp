package by.it.jd2.Mk_JD2_103_23.chatApp.service.factory;

import by.it.jd2.Mk_JD2_103_23.chatApp.storage.dao.factory.UserDaoFactory;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.UserLoginService;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.api.IUserLoginService;

public class UserLoginServiceFactory {
    private volatile static UserLoginService instance;

    public UserLoginServiceFactory() {
    }

    public static IUserLoginService getInstance() {
        if(instance == null){
            synchronized (UserLoginServiceFactory.class){
                if(instance == null){
                    instance = new UserLoginService(UserDaoFactory.getInstance());
                }
            }
        }
        return instance;
    }
}
