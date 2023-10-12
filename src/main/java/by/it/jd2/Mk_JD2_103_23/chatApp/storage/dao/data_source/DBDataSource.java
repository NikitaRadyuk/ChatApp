package by.it.jd2.Mk_JD2_103_23.chatApp.storage.dao.data_source;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.util.Properties;
import javax.sql.DataSource;

public class DBDataSource {
    private static ComboPooledDataSource ds;
    public static final Properties dbProperties = new Properties();
    static{
        ds = new ComboPooledDataSource();
        try{
            ds.setDriverClass("org.postgresql.Driver");
        } catch (PropertyVetoException e) {
            throw new IllegalStateException("Ошибка инициализации драйвера БД", e);
        }
        ds.setJdbcUrl(dbProperties.getProperty("db.url"));
        ds.setUser(dbProperties.getProperty("db.user"));
        ds.setPassword(dbProperties.getProperty("db.password"));
    }

    public static DataSource getInstance(){
        return ds;
    }
}
