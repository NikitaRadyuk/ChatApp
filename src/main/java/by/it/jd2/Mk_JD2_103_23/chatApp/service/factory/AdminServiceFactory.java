package by.it.jd2.Mk_JD2_103_23.chatApp.service.factory;

import by.it.jd2.Mk_JD2_103_23.chatApp.dao.factory.ActiveUsersDaoFactory;
import by.it.jd2.Mk_JD2_103_23.chatApp.dao.factory.MessageDaoFactory;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.AdminService;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.api.IAdminService;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.api.IStatisticsService;

public class StatisticsServiceFactory {
    private volatile static AdminService instance;
    public StatisticsServiceFactory() {
    }

    public static IStatisticsService getInstance() {
        if(instance == null){
            synchronized (StatisticsServiceFactory.class){
                if(instance == null){
                    instance = new StatisticsService(MessageDaoFactory.getInstance(), ActiveUsersDaoFactory.getInstance());
                }
            }
        }
        return instance;
    }
}
