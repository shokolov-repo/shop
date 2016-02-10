package dao;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by dmity on 13.10.15.
 */
public abstract class ConnectionDB {
    static Logger logger = Logger.getLogger(ConnectionDB.class);
    private static String prop = "./database.properties";
    private static String url;
    private static String user;
    private static String passWord;
    private static String driver;

    static {
        Properties properties = new Properties();
        InputStream inputStream = ConnectionDB.class.getClassLoader().getResourceAsStream(prop);

        try {
            properties.load(inputStream);
        } catch (IOException e) {
            logger.trace(e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                logger.error("InputStream was not closed.");
            }
        }
        url = properties.getProperty("url");
        user = properties.getProperty("user");
        passWord = properties.getProperty("password");
        driver = properties.getProperty("driver");

        try {
            Class.forName(driver).newInstance();
        } catch (ClassNotFoundException e) {
            logger.trace("Driver is not exist.");
        } catch (InstantiationException e) {
            logger.trace(e);
        } catch (IllegalAccessException e) {
            logger.trace(e);
        }
    }

    public static Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, passWord);
            logger.info("Connection was create.");
        } catch (SQLException e) {
            logger.trace(e);
        }
        return connection;
    }

    public static void closeConnection(Connection connection) {
        try {
            connection.close();
            logger.info("Connection was close.");
        } catch (SQLException e) {
            logger.error("Connection not close.");
        }
    }

    public static String getUrl() {
        return url;
    }

    public static String getUser() {
        return user;
    }

    public static String getPassWord() {
        return passWord;
    }

    public static String getDriver() {
        return driver;
    }
}
