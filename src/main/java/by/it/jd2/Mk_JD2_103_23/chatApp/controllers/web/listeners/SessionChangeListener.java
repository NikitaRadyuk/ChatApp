package by.it.jd2.Mk_JD2_103_23.chatApp.controllers.web.listeners;

import by.it.jd2.Mk_JD2_103_23.chatApp.service.StatisticsService;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.api.IStatisticsService;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

@WebListener()
public class SessionChangeListener implements HttpSessionAttributeListener {
    private IStatisticsService statisticsService;
    final String USER = "user";

    public SessionChangeListener() {
        this.statisticsService = StatisticsService.getInstance();
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        if (USER.equalsIgnoreCase(event.getName()) && event.getValue() != null) {
            this.statisticsService.incSessionCount();
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        if(USER.equalsIgnoreCase(event.getName())){
            this.statisticsService.decSessionCount();
        }
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        if (USER.equalsIgnoreCase(event.getName())){
            if(event.getValue() != null){
                this.statisticsService.decSessionCount();
                this.statisticsService.incSessionCount();
            }else{
                this.statisticsService.decSessionCount();
            }
        }
    }
}
