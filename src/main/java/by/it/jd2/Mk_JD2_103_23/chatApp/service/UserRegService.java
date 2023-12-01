package by.it.jd2.Mk_JD2_103_23.chatApp.service;

import by.it.jd2.Mk_JD2_103_23.chatApp.core.dto.UserDTO;
import by.it.jd2.Mk_JD2_103_23.chatApp.dao.api.IUserDao;
import by.it.jd2.Mk_JD2_103_23.chatApp.dao.entity.Role;
import by.it.jd2.Mk_JD2_103_23.chatApp.dao.entity.User;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.api.IUserRegService;

import java.time.LocalDate;
import java.util.Collection;

/**
 * Реализация регистрации пользователя
 */
public class UserRegService implements IUserRegService {

    private final IUserDao userDao;

    public UserRegService(IUserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public User sighUp(UserDTO user) {
        if (user.getLogin() == null || user.getPassword() == null || user.getFullname() == null || user.getBirthday() == null){
            throw new IllegalArgumentException("Проверьте форму заполнения. Все поля должны быть заполнены");
        }
        User userEntity = new User();
        userEntity.setLogin(user.getLogin());
        userEntity.setPassword(user.getPassword());
        userEntity.setUserName(user.getFullname());
        userEntity.setBirthday(user.getBirthday());
        userEntity.setRegisterDate(LocalDate.now());
        userEntity.setRole(Role.USER);

        this.userDao.saveUser(userEntity);

        return userEntity;
    }

    @Override
    public Collection<User> getAllUsers() {
        return this.userDao.getAllUsers();
    }

    @Override
    public long getCount() {
        return this.userDao.getCount();
    }
}