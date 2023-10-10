package by.it.jd2.Mk_JD2_103_23.chatApp.dao.api;

import by.it.jd2.Mk_JD2_103_23.chatApp.storage.entity.User;

import java.util.Collection;

/**
 * Интерфейс(DAO) для хранения пользователей
 */
public interface IUserDao {
    void saveUser(User user);
    User get(String login);
    Collection<User> getAllUsers();

    long getCount();

}
