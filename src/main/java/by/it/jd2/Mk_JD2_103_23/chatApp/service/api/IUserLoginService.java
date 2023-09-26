package by.it.jd2.Mk_JD2_103_23.chatApp.service.api;

import by.it.jd2.Mk_JD2_103_23.chatApp.core.dto.User;

import java.util.List;

/**
 * Интерфейс, сервис для авторизации пользователя
 */
public interface IUserLoginService {
    void login();

    List<User> getAllUsers();
}
