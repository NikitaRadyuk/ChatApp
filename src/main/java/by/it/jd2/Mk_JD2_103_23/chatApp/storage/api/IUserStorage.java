package by.it.jd2.Mk_JD2_103_23.chatApp.storage.api;

import by.it.jd2.Mk_JD2_103_23.chatApp.storage.entity.User;

import java.util.Collection;

public interface IUserStorage {
    User getUser(String login);
    void add(User user);
    Collection<User> getAllUsers();
    long getCount();
}
