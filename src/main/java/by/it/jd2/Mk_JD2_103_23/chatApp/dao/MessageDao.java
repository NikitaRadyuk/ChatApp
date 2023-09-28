package by.it.jd2.Mk_JD2_103_23.chatApp.dao;

import by.it.jd2.Mk_JD2_103_23.chatApp.core.dto.Message;
import by.it.jd2.Mk_JD2_103_23.chatApp.dao.api.IMessageDao;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MessageDao implements IMessageDao {
    private final Map<String, List<Message>> messages = new ConcurrentHashMap<>();
    @Override
    public void sendMessage(Message message) {
        this.messages.put(message.getToUser(), Collections.singletonList(message));
    }

    @Override
    public List<Message> viewChat(String userName) {
        return this.messages.get(userName);
    }


}
