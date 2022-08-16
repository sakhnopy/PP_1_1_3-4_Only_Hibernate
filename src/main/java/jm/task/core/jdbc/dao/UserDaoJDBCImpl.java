package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    private final Connection connect = Util.getInstance().getConnection();

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try (Statement statement = connect.createStatement()) {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS users " +
                    "(id BIGINT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255), lastname VARCHAR(255), age INT)");
            System.out.println("Таблица создана");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try (Statement statement = connect.createStatement()) {
            statement.executeUpdate("DROP TABLE IF EXISTS users");
            System.out.println("Таблица удалена");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (PreparedStatement pstm = connect.prepareStatement("INSERT INTO users (name, lastname, age) VALUES (?, ?, ?)")) {
            pstm.setString(1, name);
            pstm.setString(2, lastName);
            pstm.setByte(3, age);
            pstm.executeUpdate();
            System.out.println("Пользователь " + name + " сохранен в БД");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try (PreparedStatement pstm = connect.prepareStatement("DELETE FROM users WHERE id = ?")) {
            pstm.setLong(1, id);
            pstm.executeUpdate();
            System.out.println("Пользователь с id " + id + " удален");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        try (ResultSet resultSet = connect.createStatement().executeQuery("SELECT * FROM users")) {
            while (resultSet.next()) {
                User user = new User(
                            resultSet.getString("name"),
                            resultSet.getString("lastname"),
                            resultSet.getByte("age"));
                            user.setId(resultSet.getLong("id"));
                            users.add(user);

            }
            System.out.println(users.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

//    public void soutUsers() {
//        try (ResultSet resultSet = connect.createStatement().executeQuery("SELECT * FROM users")) {
//            System.out.println("id  |  Name  |  lastname | age");
//            while (resultSet.next()) {
//                long id =  resultSet.getLong("id");
//                String name =  resultSet.getString("name");
//                String lastname = resultSet.getString("lastname");
//                byte age =  resultSet.getByte("age");
//                System.out.printf("%s -|- %s -|- %s -|- %d \n", id, name, lastname, age);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public void cleanUsersTable() {
        try (Statement statement = connect.createStatement()) {
            statement.executeUpdate("TRUNCATE TABLE users");
            System.out.println("Таблица очищена");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}