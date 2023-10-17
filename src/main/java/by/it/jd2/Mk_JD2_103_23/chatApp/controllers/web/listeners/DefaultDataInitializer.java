package by.it.jd2.Mk_JD2_103_23.chatApp.controllers.web.listeners;

import by.it.jd2.Mk_JD2_103_23.chatApp.storage.entity.Role;
import by.it.jd2.Mk_JD2_103_23.chatApp.storage.entity.User;
import by.it.jd2.Mk_JD2_103_23.chatApp.storage.dao.UserDao;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Класс-лисенер для дефолтного добавления админа
 */
@WebListener()
public class DefaultDataInitializer implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        UserDao userdao = UserDao.getInstance();

        User user = new User();
        user.setLogin("admin");
        user.setPassword("123");
        user.setUserName("Radyuk Nikita Olegovich");
        user.setBirthday(LocalDate.of(2002,12,8));
        user.setRegisterDate(LocalDate.from(LocalDateTime.now()));
        user.setRole(Role.ADMIN);

        userdao.saveUser(user);
    }
}
