package by.it.jd2.Mk_JD2_103_23.chatApp.core.dto;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 * Класс-сущность Пользователь
 */
public class User{
    private String login;
    private String password;
    private String userName;
    private LocalDate birthday;
    private LocalDate registerDate;
    private Role role;

    public User() {
    }

    public User(String login, String password, String userName, LocalDate birthday) {
        this.login = login;
        this.password = password;
        this.userName = userName;
        this.birthday = birthday;
        registerDate = LocalDate.now();
        role = Role.USER;
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

    public String getFullName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }
    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }

    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "User{login" + login + ", fullName=" + userName + ", registrationDate=" + registerDate + "}";
    }
}
