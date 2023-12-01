package by.it.jd2.Mk_JD2_103_23.chatApp.core.dto;

/**
 * DTO "Сообщение"
 */
public class MessageDTO {
    private String from;
    private String to;
    private String text;

    public MessageDTO() {
    }

    public MessageDTO(String from, String to, String text) {
        this.from = from;
        this.to = to;
        this.text = text;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
