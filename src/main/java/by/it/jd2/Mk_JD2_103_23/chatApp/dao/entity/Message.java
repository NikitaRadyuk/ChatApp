package by.it.jd2.Mk_JD2_103_23.chatApp.dao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Сущность Сообщение
 */
@Entity
@Table(schema = "messanger", name = "message")
public class Message {
    @Id
    @Column(name = "sending_time")
    private LocalDate sendingDateTime;
    @Column(name = "sender_name")
    private String fromUser;
    @Column(name = "recipient_name")
    private String toUser;
    @Column(name = "text")
    private String text;

    public Message() {
    }

    public Message(String fromUser, String toUser, String text) {
        this.sendingDateTime = LocalDate.now();
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.text = text;
    }

    public LocalDate getSendingDateTime() {
        return sendingDateTime;
    }

    public void setSendingDateTime(LocalDate sendingDateTime) {
        this.sendingDateTime = sendingDateTime;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(sendingDateTime, message.sendingDateTime) && Objects.equals(fromUser, message.fromUser) && Objects.equals(toUser, message.toUser) && Objects.equals(text, message.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sendingDateTime, fromUser, toUser, text);
    }

    @Override
    public String toString() {
        return "Message{" +
                "sendingDateTime=" + sendingDateTime +
                ", fromUser='" + fromUser + '\'' +
                ", toUser='" + toUser + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
