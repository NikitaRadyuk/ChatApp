package by.it.jd2.Mk_JD2_103_23.chatApp.controllers.web.listeners;

import by.it.jd2.Mk_JD2_103_23.chatApp.service.api.IActiveUsersService;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.factory.ActiveUsersServiceFactory;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

@WebListener()
public class SessionChangeListener implements HttpSessionAttributeListener {
    private IActiveUsersService activeUsersService = ActiveUsersServiceFactory.getInstance();
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        String name = event.getName();
        if (name == "user") {
            activeUsersService.putActiveUser(name);
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
    }
}
