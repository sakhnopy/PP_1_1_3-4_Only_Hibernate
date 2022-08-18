package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.util.Util;


public class Main {
        public static void main(String[] args) {
//            Util.getConnection();
//            UserDao userDao = new UserDaoJDBCImpl();
//            userDao.createUsersTable();
//            userDao.saveUser("Name1", "LastName1", (byte) 20);
//            userDao.saveUser("Name1", "LastName1", (byte) 20);
//            userDao.saveUser("Name1", "LastName1", (byte) 20);
//            userDao.saveUser("Name1", "LastName1", (byte) 20);
//
            UserDao hibernate = new UserDaoHibernateImpl();

            hibernate.createUsersTable();
//            hibernate.dropUsersTable();
            hibernate.saveUser("gася", "Петров", (byte) 23);
            hibernate.saveUser("dfася", "Петров", (byte) 23);
            hibernate.saveUser("Вfся", "Петров", (byte) 23);
            hibernate.saveUser("Вsaся", "Петров", (byte) 23);
            hibernate.saveUser("Ваassassaя", "Петров", (byte) 23);
            hibernate.saveUser("Васsadasdя", "Петров", (byte) 23);
            hibernate.cleanUsersTable();

            hibernate.getAllUsers();




    }
}
