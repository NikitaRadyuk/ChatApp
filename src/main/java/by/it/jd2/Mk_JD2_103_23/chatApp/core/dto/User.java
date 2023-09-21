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
    private String fullName;
    private LocalDate birthday;
    private LocalDate registrDate;
    private Role role;

    /*casasockm*/
    public User() {
    }

    public User(String login, String password, String fullName, LocalDate birthday, LocalDate registrDate, Role role) {
        this.login = login;
        this.password = password;
        this.fullName = fullName;
        this.birthday = birthday;
        registrDate = LocalDate.now();
        this.role = role;
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
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate getRegistrDate() {
        return registrDate;
    }
    public void setRegistrDate(LocalDate registrDate) {
        this.registrDate = registrDate;
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
        return "User{login" + login + ", fullName=" + fullName + ", registrationDate=" + registrDate + "}";
    }
}
