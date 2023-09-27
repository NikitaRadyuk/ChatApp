package by.it.jd2.Mk_JD2_103_23.chatApp.service;

import by.it.jd2.Mk_JD2_103_23.chatApp.core.dto.Credentials;
import by.it.jd2.Mk_JD2_103_23.chatApp.core.dto.User;
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
    @Override
    public void login(Credentials credentials) {
        List<User> allUsers = getAllUsers();
        for (User user : allUsers) {
            if(credentials.getLogin().equals(user.getLogin())) {

            }
        }
    }

    @Override
    public List<User> getAllUsers() {
        return this.userDao.getAllUsers();
    }
}


