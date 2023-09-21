package by.it.jd2.Mk_JD2_103_23.chatApp.service.api;

import by.it.jd2.Mk_JD2_103_23.chatApp.core.dto.User;

import java.util.List;

/**
 * Интерфейс(service), сервис для сохранения данных пользователя
 */
public interface IUserRegService {
    /**
     * сохранение пользователя при регистрации
     * @param user
     */
    void save(User user);

    List<User> getAllUsers();

}
