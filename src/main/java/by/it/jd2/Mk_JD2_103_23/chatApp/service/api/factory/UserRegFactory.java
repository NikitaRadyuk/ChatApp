package by.it.jd2.Mk_JD2_103_23.chatApp.service.api.factory;

import by.it.jd2.Mk_JD2_103_23.chatApp.dao.UserDao;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.UserRegService;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.api.IUserRegService;

public class UserRegFactory {
    private volatile static UserRegService instance;

    private UserRegFactory(){
    }

    public static IUserRegService getInstance(){
        if (instance == null){
            synchronized (UserRegFactory.class){
                if (instance == null){
                    instance = new UserRegService(UserDaoFactory.getInstance());
                }
            }
        }
        return instance;
    }

}
