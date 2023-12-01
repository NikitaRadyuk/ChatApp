package by.it.jd2.Mk_JD2_103_23.chatApp.service;

import by.it.jd2.Mk_JD2_103_23.chatApp.core.dto.CredentialsDTO;
import by.it.jd2.Mk_JD2_103_23.chatApp.dao.entity.User;
import by.it.jd2.Mk_JD2_103_23.chatApp.core.exceptions.ValidationException;
import by.it.jd2.Mk_JD2_103_23.chatApp.dao.api.IUserDao;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.api.IUserLoginService;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Реализация авторизации пользователя
 */
@Service
public class UserLoginService implements IUserLoginService {
    private IUserDao userDao;

    public UserLoginService(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User login(CredentialsDTO credentialsDTO) {
        User value = userDao.findByLogin(credentialsDTO.getLogin());
        if (value == null){
            throw new ValidationException("Пользователь не найден");
        }
        String credentialsPassword = credentialsDTO.getPassword();
        String userPassword = value.getPassword();
        if (!credentialsPassword.equals(userPassword.trim())) {
             throw new ValidationException("Неверный пароль");
        }
        return value;
    }

    @Override
    public Collection<User> getAllUsers() {
        return this.userDao.getAllUsers();
    }
}



