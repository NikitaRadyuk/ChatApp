package by.it.jd2.Mk_JD2_103_23.chatApp.core.dto;

import java.time.LocalDate;

/**
 * DTO "Пользователь"
 */
public class UserDTO {
    private String login;
    private String password;
    private String fullname;
    private LocalDate birthday;

    public UserDTO() {
    }

    public UserDTO(String login, String password, String fullname, LocalDate birthday) {
        this.login = login;
        this.password = password;
        this.fullname = fullname;
        this.birthday = birthday;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
