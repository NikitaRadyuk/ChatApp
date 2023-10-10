package by.it.jd2.Mk_JD2_103_23.chatApp.service;

import by.it.jd2.Mk_JD2_103_23.chatApp.core.dto.CredentialsDTO;
import by.it.jd2.Mk_JD2_103_23.chatApp.storage.entity.User;
import by.it.jd2.Mk_JD2_103_23.chatApp.core.exceptions.ValidationException;
import by.it.jd2.Mk_JD2_103_23.chatApp.dao.api.IUserDao;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.api.IUserLoginService;

import java.util.Collection;

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
    public User login(CredentialsDTO credentialsDTO) {
        User value = null;
        Collection<User> allUsers = getAllUsers();
        for (User user : allUsers) {
            String credentialsLogin = credentialsDTO.getLogin();
            String userLogin = user.getLogin();
            if (credentialsLogin.equals(userLogin)) {
                String credentialsPassword = credentialsDTO.getPassword();
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
    public Collection<User> getAllUsers() {
        return this.userDao.getAllUsers();
    }
}



