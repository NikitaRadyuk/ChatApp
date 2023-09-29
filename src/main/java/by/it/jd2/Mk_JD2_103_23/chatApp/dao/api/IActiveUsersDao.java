package by.it.jd2.Mk_JD2_103_23.chatApp.dao.api;

import java.util.List;

public interface IActiveUsersDao {
    void putActiveUser(String user);
    List<String> getActiveUsers();
}
