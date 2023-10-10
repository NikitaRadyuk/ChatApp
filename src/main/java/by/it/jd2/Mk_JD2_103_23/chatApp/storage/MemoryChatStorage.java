package by.it.jd2.Mk_JD2_103_23.chatApp.storage;

import by.it.jd2.Mk_JD2_103_23.chatApp.storage.api.IChatStorage;
import by.it.jd2.Mk_JD2_103_23.chatApp.storage.entity.Message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryChatStorage implements IChatStorage {

    private final static MemoryChatStorage instance = new MemoryChatStorage();

    private final Map<String, List<Message>> chats = new HashMap<>();

    @Override
    public List<Message> getMessages(String login) {
        return this.chats.get(login);
    }

    @Override
    public void addMessage(String login, Message message) {
        List<Message> chat;
        if(this.chats.containsKey(login)){
            chat = this.chats.get(login);
        }else{
            chat = new ArrayList<>();
            this.chats.put(login, chat);
        }
        chat.add(message);
    }

    @Override
    public long getCount() {
        return this.chats.values().stream().mapToInt(List::size).sum();
    }

    public static MemoryChatStorage getInstance(){
        return instance;
    }
}
