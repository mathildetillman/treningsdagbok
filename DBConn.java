package dagbok;

import java.sql.*;
import java.util.Properties;

public class DBConn {

    protected Connection con;


    public DBConn () {
    }


    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Properties p = new Properties();
            p.put("user", "root");
            p.put("password", "");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/treningsdagbok?autoReconnect=true&useSSL=false", p);
        } catch (Exception e)
        {
            throw new RuntimeException("Unable to connect", e);
        }
    }
}
