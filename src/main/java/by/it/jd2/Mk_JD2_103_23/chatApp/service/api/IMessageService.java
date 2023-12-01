package by.it.jd2.Mk_JD2_103_23.chatApp.service.api;

import by.it.jd2.Mk_JD2_103_23.chatApp.core.dto.MessageDTO;
import by.it.jd2.Mk_JD2_103_23.chatApp.core.dto.Pageable;
import by.it.jd2.Mk_JD2_103_23.chatApp.dao.entity.Message;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 *  Интерфейс Сервис для отправки сообщений
 */
public interface IMessageService {
    void send(MessageDTO message);

    Page<MessageDTO> getAllMessages(Pageable pageable);
    List<Message> getAllMessages(MessageDTO messageDTO,Pageable pageable);

    long getCount();
}