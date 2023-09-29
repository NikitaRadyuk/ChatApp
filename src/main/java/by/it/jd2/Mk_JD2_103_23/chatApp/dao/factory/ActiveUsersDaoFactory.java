package by.it.jd2.Mk_JD2_103_23.chatApp.dao.factory;

import by.it.jd2.Mk_JD2_103_23.chatApp.dao.ActiveUsersDao;
import by.it.jd2.Mk_JD2_103_23.chatApp.dao.api.IActiveUsersDao;

public class ActiveUsersDaoFactory {
    private volatile static ActiveUsersDao instance;

    public ActiveUsersDaoFactory() {
    }

    public static IActiveUsersDao getInstance() {
        if(instance == null){
            synchronized (ActiveUsersDaoFactory.class){
                if(instance == null){
                    instance = new ActiveUsersDao();
                }
            }
        }
        return instance;
    }
}
