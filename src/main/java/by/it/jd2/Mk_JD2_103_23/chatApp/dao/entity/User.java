package by.it.jd2.Mk_JD2_103_23.chatApp.dao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Класс-сущность Пользователь
 */
@Entity
@Table(schema = "messanger", name = "user")
public class User{
    @Id
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "username")
    private String userName;
    @Column(name = "birthday")
    private LocalDate birthday;
    @Column(name = "reg_date")
    private LocalDate registerDate;
    @Column(name = "role")
    private String role;

    public User() {
    }

    public User(String login, String password, String userName, LocalDate birthday) {
        this.login = login;
        this.password = password;
        this.userName = userName;
        this.birthday = birthday;
        registerDate = LocalDate.now();
        role = "USER";
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

    public String getUserName() {
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

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!Objects.equals(login, user.login)) return false;
        if (!Objects.equals(password, user.password)) return false;
        if (!Objects.equals(userName, user.userName)) return false;
        if (!Objects.equals(birthday, user.birthday)) return false;
        if (!Objects.equals(registerDate, user.registerDate)) return false;
        return role == user.role;
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (registerDate != null ? registerDate.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", birthday=" + birthday +
                ", registerDate=" + registerDate +
                ", role=" + role +
                '}';
    }

}
