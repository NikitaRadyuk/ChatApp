package by.it.jd2.Mk_JD2_103_23.chatApp.service;

import by.it.jd2.Mk_JD2_103_23.chatApp.core.dto.User;
import by.it.jd2.Mk_JD2_103_23.chatApp.core.exceptions.ValidationException;
import by.it.jd2.Mk_JD2_103_23.chatApp.dao.UserDao;
import by.it.jd2.Mk_JD2_103_23.chatApp.dao.api.IUserDao;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.api.IUserRegService;

import java.util.List;

/**
 * Реализация регистрации пользователя
 */
public class UserRegService implements IUserRegService {

    private IUserDao userDao;

    @Override
    public void save(User user) {
        if(user == null){
            throw new IllegalArgumentException("Нет информации о пользователе");
        }

        if (user.getLogin()== null || user.getPassword() == null || user.getFullName() == null || user.getBirthday() == null){
            throw new IllegalArgumentException("Какое-то из полей при регистрации не введено");
        }

        userDao.saveUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return this.userDao.getAllUsers();
    }
}

//добавить реализацию в метод save
