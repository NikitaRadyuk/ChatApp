package by.it.jd2.Mk_JD2_103_23.chatApp.storage.dao;

import by.it.jd2.Mk_JD2_103_23.chatApp.storage.dao.data_source.DBDataSource;
import by.it.jd2.Mk_JD2_103_23.chatApp.storage.entity.Role;
import by.it.jd2.Mk_JD2_103_23.chatApp.storage.entity.User;
import by.it.jd2.Mk_JD2_103_23.chatApp.storage.dao.api.IUserDao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class UserDao implements IUserDao {

    private final String ADD_USER_IN_DB = "INSERT INTO messanger.\"user\"(login, password, username, birthday, reg_date, role) VALUES (?, ?, ?, ?, ?, ?);";

    private static final String GET_ALL_USERS_IN_DB = "SELECT login, password, username, birthday, reg_date, role FROM messanger.\"user\";";

    private final Map<String, User> users = new HashMap<>();

    private final DataSource ds;
    private static final UserDao instance = new UserDao();
    public UserDao() {
        this.ds = DBDataSource.getInstance();
    }

    @Override
    public void saveUser(User user) {
        if(this.users.containsKey(user.getLogin())){
            throw new IllegalArgumentException("Пользователь с этим логином уже зарегистрирован");
        }
        this.users.put(user.getLogin(), user);

        try(Connection conn = ds.getConnection();
            PreparedStatement ps = conn.prepareStatement(ADD_USER_IN_DB);
        ){
          ps.setString(1,user.getLogin());
          ps.setString(2,user.getPassword());
          ps.setString(3,user.getUserName());
          ps.setDate(4, Date.valueOf(user.getBirthday()));
          ps.setObject(5,user.getRegisterDate());
          ps.setString(6,user.getRole().name());

          ps.execute();
        } catch (SQLException e) {
            throw new IllegalStateException("Ошибка сохранения пользователя в БД", e);
        }
    }

    @Override
    public User getUser(String login) {
        return this.users.get(login);
    }

    @Override
    public Collection<User> getAllUsers() {
        try(
                Connection conn = ds.getConnection();
                PreparedStatement ps = conn.prepareStatement(GET_ALL_USERS_IN_DB);
                ResultSet rs = ps.executeQuery();
                ){
            List<User> dataDB = new ArrayList<>();

            while(rs.next()){
                User item = new User();
                item.setLogin(rs.getString("login"));
                item.setPassword(rs.getString("password"));
                item.setUserName(rs.getString("username"));
                item.setBirthday(rs.getDate("birthday").toLocalDate());
                item.setRegisterDate(rs.getDate("reg_date").toLocalDate());
                item.setRole(Role.valueOf(rs.getString("role")));

                dataDB.add(item);
            }

            List<User> dataLocalList = new ArrayList<>(this.users.values());

            boolean areEqual = dataLocalList.equals(dataDB);

            if (areEqual){
                return dataDB;
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Ошибка при получении данных о всех пользователях", e);
        }
        return null;
    }

    @Override
    public long getCount() {
        return this.users.size();
    }

    public static UserDao getInstance(){return instance;}
}
