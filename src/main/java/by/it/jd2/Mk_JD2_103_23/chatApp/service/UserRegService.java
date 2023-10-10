package by.it.jd2.Mk_JD2_103_23.chatApp.service;

import by.it.jd2.Mk_JD2_103_23.chatApp.storage.entity.User;
import by.it.jd2.Mk_JD2_103_23.chatApp.dao.api.IUserDao;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.api.IUserRegService;

import java.util.Collection;

/**
 * Реализация регистрации пользователя
 */
public class UserRegService implements IUserRegService {

    private IUserDao userDao;

    public UserRegService(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save(User user) {
        if(user == null){
            throw new IllegalArgumentException("Пользователь не создан");
        }
        userDao.saveUser(user);
    }

    @Override
    public Collection<User> getAllUsers() {
        return this.userDao.getAllUsers();
    }
}