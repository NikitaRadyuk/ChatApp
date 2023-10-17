package by.it.jd2.Mk_JD2_103_23.chatApp.service;

import by.it.jd2.Mk_JD2_103_23.chatApp.core.dto.MessageDTO;
import by.it.jd2.Mk_JD2_103_23.chatApp.storage.dao.api.IMessageDao;
import by.it.jd2.Mk_JD2_103_23.chatApp.storage.dao.factory.MessageDaoFactory;
import by.it.jd2.Mk_JD2_103_23.chatApp.storage.entity.Message;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.api.IMessageService;
import by.it.jd2.Mk_JD2_103_23.chatApp.storage.entity.User;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Реализация сервиса отправки сообщений
 */
public class MessageService implements IMessageService {
    private static final MessageService instance = new MessageService();
    private final IMessageDao chatStorage;

    public MessageService() {
        this.chatStorage = MessageDaoFactory.getInstance();
    }
    @Override
    public void send(MessageDTO message) {
        if (message.getTo() == null || message.getTo().isBlank()){
            throw new IllegalArgumentException("Выберите получателя сообщения");
        }
        Message messageEntity = new Message();
        messageEntity.setFromUser(message.getFrom());
        messageEntity.setToUser(message.getTo());
        messageEntity.setText(message.getText());
        messageEntity.setSendingDateTime(LocalDateTime.now());

        this.chatStorage.sendMessage(messageEntity.getToUser(), messageEntity);
    }

    @Override
    public List<Message> getAllMessages(User currUser) {
        return this.chatStorage.viewChat(currUser.getLogin());
    }

    @Override
    public long getCount() {
        return this.chatStorage.getCount();
    }

    public static  MessageService getInstance(){
        return instance;
    }
}
