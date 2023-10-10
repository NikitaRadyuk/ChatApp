package by.it.jd2.Mk_JD2_103_23.chatApp.dao;

import by.it.jd2.Mk_JD2_103_23.chatApp.storage.entity.Message;
import by.it.jd2.Mk_JD2_103_23.chatApp.dao.api.IMessageDao;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MessageDao implements IMessageDao {
    private final Map<String, List<Message>> messages = new ConcurrentHashMap<>();
    @Override
    public void sendMessage(Message message) {
        this.messages.compute(message.getToUser(), (k, v) -> v != null ? v : new ArrayList<>()).add(message);
    }
    @Override
    public List<Message> viewChat(String login) {
        return this.messages.get(login);
    }

    @Override
    public Map<String, List<Message>> getMessages() {
        return this.messages;
    }
}
