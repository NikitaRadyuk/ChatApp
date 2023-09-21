package by.it.jd2.Mk_JD2_103_23.chatApp.dao.api;

import by.it.jd2.Mk_JD2_103_23.chatApp.core.dto.User;

/**
 * Интерфейс(DAO) для хранения пользователей
 */
public interface IUserRegDao {
    void saveUser(User user);
}
