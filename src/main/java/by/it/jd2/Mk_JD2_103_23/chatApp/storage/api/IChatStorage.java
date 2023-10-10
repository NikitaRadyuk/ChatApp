package by.it.jd2.Mk_JD2_103_23.chatApp.storage.api;

import by.it.jd2.Mk_JD2_103_23.chatApp.storage.entity.Message;

import java.util.List;

public interface IChatStorage {
    List<Message> getMessages(String login);
    void addMessage(String login, Message message);
    long getCount();

}
