package by.it.jd2.Mk_JD2_103_23.chatApp.storage.dao.data_source;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import javax.sql.DataSource;

public class DBDataSource {
    private static ComboPooledDataSource ds= new ComboPooledDataSource();;
    static{
        try{
            ds.setDriverClass("org.postgresql.Driver");
        } catch(PropertyVetoException e){
            throw new IllegalStateException("Ошибка инициализации драйвера базы данных", e);
        }
        ds.setJdbcUrl("jdbc:postgresql://localhost:5432/messanger");
        ds.setUser("postgres");
        ds.setPassword("12345678");
    }

    public static DataSource getInstance(){
        return ds;
    }
}
