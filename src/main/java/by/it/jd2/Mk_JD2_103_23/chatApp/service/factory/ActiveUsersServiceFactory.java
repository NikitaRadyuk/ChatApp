package by.it.jd2.Mk_JD2_103_23.chatApp.service.factory;

import by.it.jd2.Mk_JD2_103_23.chatApp.dao.factory.ActiveUsersDaoFactory;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.ActiveUsersService;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.api.IActiveUsersService;


public class ActiveUsersServiceFactory {
    private volatile static ActiveUsersService instance;
    public ActiveUsersServiceFactory() {
    }

    public static IActiveUsersService getInstance() {
        if(instance == null){
            synchronized (ActiveUsersServiceFactory.class){
                if(instance == null){
                    instance = new ActiveUsersService(ActiveUsersDaoFactory.getInstance());
                }
            }
        }
        return instance;
    }
}
