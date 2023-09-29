package by.it.jd2.Mk_JD2_103_23.chatApp.service;

import by.it.jd2.Mk_JD2_103_23.chatApp.dao.api.IActiveUsersDao;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.api.IActiveUsersService;

public class ActiveUsersService implements IActiveUsersService {
    private IActiveUsersDao activeUsersDao;

    public ActiveUsersService(IActiveUsersDao activeUsersDao) {
        this.activeUsersDao = activeUsersDao;
    }

    @Override
    public void putActiveUser(String user) {
        if(user == null){
            throw new IllegalArgumentException();
        }
       activeUsersDao.putActiveUser(user);
    }
}
