package by.it.jd2.Mk_JD2_103_23.chatApp.core.dto;

public class MessageBuilder {
    private String from;
    private String to;
    private String text;


    public void setFrom(String from) {
        this.from = from;
    }
    public void setTo(String to) {
        this.to = to;
    }
    public void setText(String text) {
        this.text = text;
    }

    public MessageDTO build(){
        return new MessageDTO(from, to, text);
    }
}
