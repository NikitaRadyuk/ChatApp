package by.it.jd2.Mk_JD2_103_23.chatApp.dao.api;

import by.it.jd2.Mk_JD2_103_23.chatApp.core.dto.User;

import java.util.List;

/**
 * Интерфейс(DAO) для хранения пользователей
 */
public interface IUserDao {
    void saveUser(User user);

    List<User> getAllUsers();

}
