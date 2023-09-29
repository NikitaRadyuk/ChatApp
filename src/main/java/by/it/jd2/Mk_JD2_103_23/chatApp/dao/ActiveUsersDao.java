package by.it.jd2.Mk_JD2_103_23.chatApp.dao;

import by.it.jd2.Mk_JD2_103_23.chatApp.dao.api.IActiveUsersDao;

import java.util.ArrayList;
import java.util.List;

public class ActiveUsersDao implements IActiveUsersDao {
    private final List<String> activeUsers = new ArrayList<>();
    @Override
    public void putActiveUser(String user) {
        this.activeUsers.add(user);
    }

    @Override
    public List<String> getActiveUsers() {
        return this.activeUsers;
    }
}
