package by.it.jd2.Mk_JD2_103_23.chatApp.storage.dao;

import by.it.jd2.Mk_JD2_103_23.chatApp.storage.entity.User;
import by.it.jd2.Mk_JD2_103_23.chatApp.storage.dao.api.IUserDao;

import java.util.*;

public class UserDao implements IUserDao {

    private static final UserDao instance = new UserDao();
    private final Map<String, User> users = new HashMap<>();

    public UserDao() {
    }

    @Override
    public void saveUser(User user) {
        if(this.users.containsKey(user.getLogin())){
            throw new IllegalArgumentException("Пользователь с этим логином уже зарегистрирован");
        }
        this.users.put(user.getLogin(), user);
    }

    @Override
    public User getUser(String login) {
        return this.users.get(login);
    }

    @Override
    public Collection<User> getAllUsers() {
        return this.users.values();
    }

    @Override
    public long getCount() {
        return this.users.size();
    }

    public static UserDao getInstance(){return instance;}
}
