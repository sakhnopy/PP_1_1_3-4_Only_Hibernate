package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/preproj?serverTimezone=Europe/Moscow&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1121Regnomer1";

    private static final String GET_ALL = "SELECT * FROM users";
    private static final String DELETEALL = "DELETE FROM users";


    public Util() throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); Statement statement = connection.createStatement()) {
            if (!connection.isClosed()) System.out.println("Подключено");
            } catch (SQLException e) {
            System.out.println(e + " Не удалось подключиться");
        }


    }
}
