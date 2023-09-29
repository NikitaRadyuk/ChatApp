package by.it.jd2.Mk_JD2_103_23.chatApp.service;

import by.it.jd2.Mk_JD2_103_23.chatApp.core.dto.Message;
import by.it.jd2.Mk_JD2_103_23.chatApp.dao.api.IActiveUsersDao;
import by.it.jd2.Mk_JD2_103_23.chatApp.dao.api.IMessageDao;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.api.IAdminService;

import java.util.List;
import java.util.Map;

public class AdminService implements IAdminService {
    private IMessageDao messageDao;
    private IActiveUsersDao activeUsersDao;

    public AdminService(IMessageDao messageDao, IActiveUsersDao activeUsersDao) {
        this.messageDao = messageDao;
        this.activeUsersDao = activeUsersDao;
    }

    @Override
    public Integer getActiveUsers() {
        List<String> activeUsers = activeUsersDao.getActiveUsers();
        return activeUsers.size();
    }

    @Override
    public Integer getMessageCount() {
        Map<String, List<Message>> messages = messageDao.getMessages();
        return messages.values()
                       .stream()
                       .mapToInt(List::size)
                       .sum();
    }
}
