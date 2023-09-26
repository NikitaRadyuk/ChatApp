package by.it.jd2.Mk_JD2_103_23.chatApp.service;

import by.it.jd2.Mk_JD2_103_23.chatApp.core.dto.User;
import by.it.jd2.Mk_JD2_103_23.chatApp.dao.UserDao;
import by.it.jd2.Mk_JD2_103_23.chatApp.dao.api.IUserDao;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.api.IUserRegService;

import java.util.List;

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
        userDao.saveUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return this.userDao.getAllUsers();
    }
}

//реализовать метод save
