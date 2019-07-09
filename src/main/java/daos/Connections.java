package daos;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connections {
//    public static final String URL = "127.0.0.1:3306";

    public static final String URL = "jdbc:mysql://127.0.0.1:3306/?user=root";
    public static final String USER = "root";
    public static final String PASS = "password";


    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }


    public static void main(String[] args) {
        Connection connection =  getConnection();
    }
}
