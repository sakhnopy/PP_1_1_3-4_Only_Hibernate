package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;


public class Main {
    public static void main(String[] args) {

        UserDao hibernate = new UserDaoHibernateImpl();

        hibernate.createUsersTable();
        hibernate.saveUser("gася", "Петров", (byte) 23);
        hibernate.saveUser("dfася", "Петров", (byte) 23);
        hibernate.saveUser("Вfся", "Петров", (byte) 23);
        hibernate.saveUser("Вsaся", "Петров", (byte) 23);
        hibernate.saveUser("Ваassassaя", "Петров", (byte) 23);
        hibernate.saveUser("ГадяПетрович", "Хренова", (byte) 23);
        hibernate.getAllUsers();

    }
}
