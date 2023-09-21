package by.it.jd2.Mk_JD2_103_23.chatApp.dao;

import by.it.jd2.Mk_JD2_103_23.chatApp.core.dto.User;
import by.it.jd2.Mk_JD2_103_23.chatApp.dao.api.IUserDao;

import java.util.ArrayList;
import java.util.List;

public class UserDao implements IUserDao {

    private final List<User> users = new ArrayList<>();

    @Override
    public void saveUser(User user) {

    }

    @Override
    public List<User> getAllUsers() {
        return this.users;
    }
}

//реализовать метод save()
//пересмотреть объявление списка
