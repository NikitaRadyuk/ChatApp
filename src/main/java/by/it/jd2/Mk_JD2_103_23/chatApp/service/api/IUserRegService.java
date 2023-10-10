package by.it.jd2.Mk_JD2_103_23.chatApp.service.api;

import by.it.jd2.Mk_JD2_103_23.chatApp.core.dto.UserCreateDTO;
import by.it.jd2.Mk_JD2_103_23.chatApp.storage.entity.User;

import java.util.Collection;

/**
 * Интерфейс(service), сервис для сохранения данных пользователя
 */
public interface IUserRegService {
    User getUser(String login);

    User sighUp(UserCreateDTO user);

    Collection<User> getAllUsers();

    long getCount();
}
