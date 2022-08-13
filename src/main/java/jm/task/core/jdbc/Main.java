package jm.task.core.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Driver;
import java.sql.SQLException;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/Local instance MySQL80";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1121Regnomer1";

    public static void main(String[] args) {
        Connection connection;
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (!connection.isClosed()) {
                System.out.println("connect OK");
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("connect no OK");
        }
    }
}
