package by.it.jd2.Mk_JD2_103_23.chatApp.service;

import by.it.jd2.Mk_JD2_103_23.chatApp.core.dto.Credentials;
import by.it.jd2.Mk_JD2_103_23.chatApp.core.dto.User;
import by.it.jd2.Mk_JD2_103_23.chatApp.core.exceptions.ValidationException;
import by.it.jd2.Mk_JD2_103_23.chatApp.dao.api.IUserDao;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.api.IUserLoginService;

import java.util.List;

/**
 * Реализация авторизации пользователя
 */
public class UserLoginService implements IUserLoginService {
    /**
     * авторизация пользователя
     * @param credentials набор данных из авторизации пользователя
     */
    private IUserDao userDao;

    public UserLoginService(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User login(Credentials credentials) {
        User value = null;
        List<User> allUsers = getAllUsers();
        for (User user : allUsers) {
            String credentialsLogin = credentials.getLogin();
            String userLogin = user.getLogin();
            if (credentialsLogin.equals(userLogin)) {
                String credentialsPassword = credentials.getPassword();
                String userPassword = user.getPassword();
                if (!credentialsPassword.equals(userPassword)) {
                    throw new ValidationException("Неверный пароль");
                }
                value = user;
            }
        }
        if (value == null){
            throw new ValidationException("Пользователь не найден");
        }
        return value;
    }

    @Override
    public List<User> getAllUsers() {
        return this.userDao.getAllUsers();
    }
}



