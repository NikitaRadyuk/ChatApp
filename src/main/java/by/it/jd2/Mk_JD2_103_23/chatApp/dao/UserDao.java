package by.it.jd2.Mk_JD2_103_23.chatApp.dao;

import by.it.jd2.Mk_JD2_103_23.chatApp.core.dto.User;
import by.it.jd2.Mk_JD2_103_23.chatApp.core.exceptions.ValidationException;
import by.it.jd2.Mk_JD2_103_23.chatApp.dao.api.IUserDao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements IUserDao {
    private static final List<User> users = new ArrayList<>();

    private static final User admin = new User("admin", "123", "Radyuk N.O.", LocalDate.of(2002, 12, 8));

    @Override
    public void saveUser(User user) {
        synchronized (users) {
            this.users.add(user);
        }
    }

    public static void addAdmin(){
        users.add(admin);
    }

    @Override
    public User getUserByLogin(String login, List<User> users) {
        for (User user: users) {
            if (user.getLogin().equals(login)){
                return user;
            }
        }
        throw new ValidationException("Пользователь не зарегистрирован");
    }

    @Override
    public List<User> getAllUsers() {
        return this.users;
    }
}

//пересмотреть объявление списка
//потокобезопасный лист