package by.it.jd2.Mk_JD2_103_23.chatApp.dao.api;

import by.it.jd2.Mk_JD2_103_23.chatApp.dao.entity.Message;
import by.it.jd2.Mk_JD2_103_23.chatApp.dao.entity.User;
import org.springframework.data.repository.Repository;

import java.util.Collection;

/**
 * Интерфейс(DAO) для хранения пользователей
 */
public interface IUserDao extends Repository<Message, String> {
    void saveUser(User user);
    User findByLogin(String login);
    Collection<User> getAllUsers();

    long getCount();

}
