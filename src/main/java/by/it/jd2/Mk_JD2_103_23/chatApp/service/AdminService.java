package by.it.jd2.Mk_JD2_103_23.chatApp.service;

import by.it.jd2.Mk_JD2_103_23.chatApp.core.dto.Message;
import by.it.jd2.Mk_JD2_103_23.chatApp.dao.api.IMessageDao;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.api.IAdminService;

import java.util.List;
import java.util.Map;

public class AdminService implements IAdminService {
    private IMessageDao messageDao;

    public AdminService() {
    }

    @Override
    public Integer getActiveUsers() {
        return null;
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
