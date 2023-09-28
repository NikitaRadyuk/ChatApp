package by.it.jd2.Mk_JD2_103_23.chatApp.controllers.web.listeners;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;

@WebListener()
public class SessionChangeListener implements HttpSessionBindingListener {
    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        String session = event.getName();
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {

    }
}
