package by.it.jd2.Mk_JD2_103_23.chatApp.service.api;

import by.it.jd2.Mk_JD2_103_23.chatApp.core.dto.UserDTO;
import by.it.jd2.Mk_JD2_103_23.chatApp.dao.entity.User;

import java.util.Collection;

/**
 * Интерфейс сервис для регистрации пользователя
 */
public interface IUserRegService {
    /*User getUser(String login);*/

    User sighUp(UserDTO user);

    Collection<User> getAllUsers();

    long getCount();
}