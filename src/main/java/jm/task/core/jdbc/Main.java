package jm.task.core.jdbc;

import java.sql.*;


public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/preproj?serverTimezone=Europe/Moscow&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1121Regnomer1";
    private static final String GET_ALL = "SELECT * FROM users";
    private static final String DELETEALL = "DELETE FROM users";

    public static void main(String[] args) throws SQLException {

        PreparedStatement preparedStatement = null;

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); Statement statement = connection.createStatement()) {
            preparedStatement = connection.prepareStatement(GET_ALL);
            preparedStatement.execute();



        } catch (SQLException e) {
            throw new SQLException("Ошибка подключения");
        }

    }
}
