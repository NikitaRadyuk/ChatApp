package by.it.jd2.Mk_JD2_103_23.chatApp.service;

import by.it.jd2.Mk_JD2_103_23.chatApp.core.dto.MessageBuilder;
import by.it.jd2.Mk_JD2_103_23.chatApp.core.dto.MessageDTO;
import by.it.jd2.Mk_JD2_103_23.chatApp.core.dto.Pageable;
import by.it.jd2.Mk_JD2_103_23.chatApp.dao.api.IMessageDao;
import by.it.jd2.Mk_JD2_103_23.chatApp.dao.entity.Message;
import by.it.jd2.Mk_JD2_103_23.chatApp.service.api.IMessageService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * Реализация сервиса отправки сообщений
 */
@Service
public class MessageService implements IMessageService {
    private final IMessageDao iMessageDao;

    public MessageService(IMessageDao iMessageDao) {
        this.iMessageDao = iMessageDao;
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
        messageEntity.setSendingDateTime(LocalDate.now());

        this.iMessageDao.sendMessage(messageEntity.getToUser(), messageEntity);
    }

    @Override
    public List<Message> getAllMessages(MessageDTO messageDTO, Pageable pageable) {
        return null;
    }

    @Override
    public Page<MessageDTO> getAllMessages(Pageable pageable) {
        return this.iMessageDao.findAll(String.valueOf(PageRequest.of(pageable.getPage(), pageable.getSize())))
                .map(MessageService::map);
    }
    @Override
    public long getCount() {
        return this.iMessageDao.getCount();
    }

    private static MessageDTO map(Message entity){
        return new MessageBuilder()
                .setFrom(String.valueOf(entity.getFromUser()))

                .setText()
                .setDate
                .build();
    }
}
