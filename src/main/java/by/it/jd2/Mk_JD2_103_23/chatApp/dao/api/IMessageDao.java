package by.it.jd2.Mk_JD2_103_23.chatApp.dao.api;

import by.it.jd2.Mk_JD2_103_23.chatApp.dao.entity.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Интерфейс(DAO) для хранения сообщений
 */
public interface IMessageDao extends Repository<Message, String> {
    void sendMessage(String login, Message message);
    Page<Message> findAll(String login);
    long getCount();
}
