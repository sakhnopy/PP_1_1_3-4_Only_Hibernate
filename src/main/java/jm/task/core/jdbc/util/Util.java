package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Objects;
import java.util.Properties;

public class Util {

    private static Connection connection = null;
    private static SessionFactory sessionFactory = null;
    private static Util instance = null;


    public static SessionFactory getSessionFactory() {

        try {
            Configuration configuration = new Configuration().addAnnotatedClass(User.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return sessionFactory;
    }

    //JDDDDDDDDDDDDDDDDDDDDDDDDDDBBBBBBBBBBBBBBBBBBBBCCCCCCCCCCCCCCCCCCCCCCCCCC
    public static Connection getConnection() {
        return connection;
    }

    private Util() {
        try {
            if (connection == null || connection.isClosed()) {
                Properties properties = getProps();
                connection = DriverManager.getConnection(
                        properties.getProperty("url"),
                        properties.getProperty("username"),
                        properties.getProperty("password"));
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }


    public static Util getInstance() {
        if (instance == null) {
            instance = new Util();
        }
        return instance;
    }

    private static Properties getProps() throws IOException {
        Properties props = new Properties();
        try (InputStream in = Files.newInputStream
                (Paths.get(Objects.requireNonNull(Util.class.getResource("/database.properties")).toURI()))) {
            props.load(in);
            return props;
        } catch (IOException | URISyntaxException e) {
            throw new IOException("Database config file not found", e);
        }
    }



}
