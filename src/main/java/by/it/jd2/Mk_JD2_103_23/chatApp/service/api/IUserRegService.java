package by.it.jd2.Mk_JD2_103_23.chatApp.service.api;

import by.it.jd2.Mk_JD2_103_23.chatApp.storage.entity.User;

import java.util.Collection;

/**
 * Интерфейс(service), сервис для сохранения данных пользователя
 */
public interface IUserRegService {
    /**
     * сохранение пользователя при регистрации
     * @param user
     */
    void save(User user);

    Collection<User> getAllUsers();

}
