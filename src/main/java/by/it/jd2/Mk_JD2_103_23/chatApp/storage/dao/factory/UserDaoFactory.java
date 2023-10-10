package by.it.jd2.Mk_JD2_103_23.chatApp.storage.dao.factory;

import by.it.jd2.Mk_JD2_103_23.chatApp.storage.dao.UserDao;
import by.it.jd2.Mk_JD2_103_23.chatApp.storage.dao.api.IUserDao;

public class UserDaoFactory {
    private volatile static UserDao instance;

    public UserDaoFactory() {
    }

    public static IUserDao getInstance() {
        if(instance == null){
            synchronized (UserDaoFactory.class){
                if(instance == null){
                    instance = new UserDao();
                }
            }
        }
        return instance;
    }


}