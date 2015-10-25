package dao.impl;

import dao.ConnectionDB;
import dao.UserDAO;
import entity.User;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dmity on 13.10.15.
 */
public class UserDAOImpl implements UserDAO {
    Logger logger = Logger.getLogger(UserDAOImpl.class);
    private String CREATE = "INSERT INTO USERS ( FIRST_NAME , LAST_NAME , ADDRESS , PHONE ,  EMAIL , PASSWORD, ROLE )" +
            "VALUES ( ? , ? , ? , ? , ? , ? , ? )";
    private String UPDATE = "UPDATE USERS SET FIRST_NAME = ?, LAST_NAME = ?, ADDRESS = ?, PHONE = ?, EMAIL = ? , " +
            "PASSWORD = ? WHERE ID = ?";
    private String DELETE = "DELETE FROM USERS WHERE ID = ?";
    private String FIND_BY_ID = "SELECT * FROM USERS WHERE ID = ?";
    private String FIND_BY_EMAIL = "SELECT * FROM USERS WHERE EMAIL = ?";
    private String FIND_ALL_BY_ROLE = "SELECT * FROM USERS WHERE ROLE = ?";
    private String FIND_ALL = "SELECT * FROM USERS";
    Connection connection;

    @Override
    public void create(User user) {
        if (user == null) {
            logger.info("User == null");
            return;
        }
        connection = ConnectionDB.createConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(CREATE);

            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getAddress());
            statement.setString(4, user.getPhone());
            statement.setString(5, user.getEmail());
            statement.setString(6, user.getPassword());
            statement.setString(7, user.getRole());
            int i = statement.executeUpdate();

            if (i == 0) {
                logger.trace(user + "wasn't create");
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(connection);
        }
    }

    @Override
    public void update(User user) {
        connection = ConnectionDB.createConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE);

            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getAddress());
            statement.setString(4, user.getPhone());
            statement.setString(5, user.getEmail());
            statement.setString(6, user.getPassword());
            statement.setLong(7, user.getId());
            int i = statement.executeUpdate();

            if (i == 0) {
                logger.trace(user + "wasn't update");
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(connection);
        }
    }

    @Override
    public void delete(long id) {
        connection = ConnectionDB.createConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.setLong(1, id);
            int i = statement.executeUpdate();

            if (i == 0) {
                logger.trace("User wasn't delete");
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public User findById(long id) {
        User user = null;
        ResultSet resultSet;
        connection = ConnectionDB.createConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(FIND_BY_ID);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = getUser(resultSet);
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return user;
    }

    @Override
    public User findByEmail(String email) {
        User user = null;
        ResultSet resultSet;
        connection = ConnectionDB.createConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(FIND_BY_EMAIL);
            statement.setString(1, email);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = getUser(resultSet);
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return user;
    }

    @Override
    public List<User> findByRole(String role) {
        List<User> users = new LinkedList<>();
        ResultSet resultSet;
        connection = ConnectionDB.createConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(FIND_ALL_BY_ROLE);
            statement.setString(1, role);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                users.add(getUser(resultSet));
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return users;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        ResultSet resultSet;
        connection = ConnectionDB.createConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(FIND_ALL);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                users.add(getUser(resultSet));
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return users;
    }

    private User getUser(ResultSet resultSet) {
        User user = new User();
        try {
            user.setId(resultSet.getLong("ID"));
            user.setFirstName(resultSet.getString("FIRST_NAME"));
            user.setLastName(resultSet.getString("LAST_NAME"));
            user.setAddress(resultSet.getString("ADDRESS"));
            user.setPhone(resultSet.getString("PHONE"));
            user.setEmail(resultSet.getString("EMAIL"));
            user.setPassword(resultSet.getString("PASSWORD"));
            user.setRole(resultSet.getString("ROLE"));
        } catch (SQLException e) {
            logger.info("User not create.");
        }
        return user;
    }
}
