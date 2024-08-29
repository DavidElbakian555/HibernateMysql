package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    // public static final String URL = "jdbc:mysql://localhost:3306/mysql";
    public static final String URL = "jdbc:mysql://localhost:3306/mysql?autoReconnect=true&useSSL=false";
    public static final String USER = "root";
    public static final String PASSWORD = "12345";
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            if (connection != null) {
                System.out.println("We are connected");
            } else {
                System.out.println("Connection is failed");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("SQLException | ClassNotFoundException");
        }
        return connection;
    }
}
