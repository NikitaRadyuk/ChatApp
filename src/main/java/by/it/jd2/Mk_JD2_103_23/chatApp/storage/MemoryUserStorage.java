package by.it.jd2.Mk_JD2_103_23.chatApp.storage;

import by.it.jd2.Mk_JD2_103_23.chatApp.storage.api.IUserStorage;
import by.it.jd2.Mk_JD2_103_23.chatApp.storage.entity.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MemoryUserStorage implements IUserStorage {

    public static final MemoryUserStorage instance = new MemoryUserStorage();

    private final Map<String, User> users = new HashMap<>();

    private MemoryUserStorage(){

    }

    @Override
    public User getUser(String login) {
        return this.users.get(login);
    }

    @Override
    public void add(User user) {
        if(this.users.containsKey(user.getLogin())){
            throw new IllegalArgumentException("Пользователь с таким логином уже существует");
        }
        this.users.put(user.getLogin(), user);
    }

    @Override
    public Collection<User> getAllUsers() {
        return this.users.values();
    }

    @Override
    public long getCount() {
        return this.users.size();
    }

    public static MemoryUserStorage getInstance(){
        return instance;
    }
}
