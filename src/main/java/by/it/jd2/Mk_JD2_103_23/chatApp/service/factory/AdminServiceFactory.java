package by.it.jd2.Mk_JD2_103_23.chatApp.service.factory;

import by.it.jd2.Mk_JD2_103_23.chatApp.dao.factory.ActiveUsersDaoFactory;
import by.it.jd2.Mk_JD2_103_23.chatApp.dao.factory.MessageDaoFactory;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.AdminService;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.api.IAdminService;

public class AdminServiceFactory {
    private volatile static AdminService instance;
    public AdminServiceFactory() {
    }

    public static IAdminService getInstance() {
        if(instance == null){
            synchronized (AdminServiceFactory.class){
                if(instance == null){
                    instance = new AdminService(MessageDaoFactory.getInstance(), ActiveUsersDaoFactory.getInstance());
                }
            }
        }
        return instance;
    }
}
