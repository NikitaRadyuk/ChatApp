package by.it.jd2.Mk_JD2_103_23.chatApp.storage.dao;

import by.it.jd2.Mk_JD2_103_23.chatApp.storage.entity.Message;
import by.it.jd2.Mk_JD2_103_23.chatApp.storage.dao.api.IMessageDao;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MessageDao implements IMessageDao {
    private static final MessageDao instance = new MessageDao();
    private final Map<String, List<Message>> messages = new ConcurrentHashMap<>();
    @Override
    public void sendMessage(String login, Message message) {
        List<Message> chat;
        if(this.messages.containsKey(login)){
            chat = this.messages.get(login);
        }else{
            chat = new ArrayList<>();
            this.messages.put(login, chat);
        }
        chat.add(message);
    }
    @Override
    public List<Message> viewChat(String login) {
        return this.messages.get(login);
    }

    @Override
    public long getCount() {
        return this.messages.values().stream().mapToInt(List::size).sum();
    }

    public static MessageDao getInstance(){return instance;}

}
