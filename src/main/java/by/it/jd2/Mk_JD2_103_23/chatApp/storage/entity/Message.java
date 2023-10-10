package by.it.jd2.Mk_JD2_103_23.chatApp.storage.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Сущность Сообщение
 */

public class Message implements Serializable {
    private LocalDateTime sendingDateTime;
    private String fromUser;
    private String toUser;
    private String text;

    public Message() {
    }

    public Message(String fromUser, String toUser, String text) {
        this.sendingDateTime = LocalDateTime.now();
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.text = text;
    }

    public LocalDateTime getSendingDateTime() {
        return sendingDateTime;
    }

    public void setSendingDateTime(LocalDateTime sendingDateTime) {
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
