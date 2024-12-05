package factory;

import java.io.IOException;
import java.sql.*;

public class DBConn {
    static Connection con;
    private DBConn(){} //Factory method that creates and return connection as singleton object

    public static Connection getConnection() throws SQLException, IOException, ClassNotFoundException{
        if (con == null){
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fullstackapp", "root", "root");
        }
        return con;
    }
}
