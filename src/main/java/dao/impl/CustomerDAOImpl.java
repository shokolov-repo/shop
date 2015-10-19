package dao.impl;

import dao.ConnectionDB;
import dao.CustomerDAO;
import entity.Customer;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmity on 13.10.15.
 */
public class CustomerDAOImpl implements CustomerDAO {
    Logger logger = Logger.getLogger(CustomerDAOImpl.class);
    private String CREATE = "INSERT INTO CUSTOMERS ( FIRST_NAME , LAST_NAME , ADDRESS , PHONE ,  EMAIL , PASSWORD )" +
            "VALUES ( ? , ? , ? , ? , ? , ?  )";
    private String UPDATE = "UPDATE CUSTOMERS SET FIRST_NAME = ?, LAST_NAME = ?, ADDRESS = ?, PHONE = ?, EMAIL = ? , " +
            "PASSWORD = ? WHERE ID = ?";
    private String DELETE = "DELETE FROM CUSTOMERS WHERE ID = ?";
    private String FIND_BY_ID = "SELECT * FROM CUSTOMERS WHERE ID = ?";
    private String FIND_BY_EMAIL = "SELECT * FROM CUSTOMERS WHERE EMAIL = ?";
    private String FIND_ALL = "SELECT * FROM CUSTOMERS";
    Connection connection;

    @Override
    public void create(Customer customer) {
        if (customer == null) {
            logger.error("Customer == null");
            throw new NullPointerException();
        }
        connection = ConnectionDB.createConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(CREATE);

            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getLastName());
            statement.setString(3, customer.getAddress());
            statement.setString(4, customer.getPhone());
            statement.setString(5, customer.getEmail());
            statement.setString(6, customer.getPassword());
            int i = statement.executeUpdate();

            if (i == 0) {
                logger.trace(customer + "wasn't create");
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(connection);
        }
    }

    @Override
    public void update(Customer customer) {
        connection = ConnectionDB.createConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE);

            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getLastName());
            statement.setString(3, customer.getAddress());
            statement.setString(4, customer.getPhone());
            statement.setString(5, customer.getEmail());
            statement.setString(6, customer.getPassword());
            statement.setLong(7, customer.getId());
            int i = statement.executeUpdate();

            if (i == 0) {
                logger.trace(customer + "wasn't update");
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
                logger.trace("customer + wasn't delete");
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public Customer findById(long id) {
        Customer customer = null;
        ResultSet resultSet;
        connection = ConnectionDB.createConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(FIND_BY_ID);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                customer = getCustomer(resultSet);
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return customer;
    }

    @Override
    public Customer findByEmail(String email) {
        Customer customer = null;
        ResultSet resultSet;
        connection = ConnectionDB.createConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(FIND_BY_EMAIL);
            statement.setString(1, email);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                customer = getCustomer(resultSet);
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return customer;
    }


    @Override
    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList<>();
        ResultSet resultSet;
        connection = ConnectionDB.createConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(FIND_ALL);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                customers.add(getCustomer(resultSet));
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return customers;
    }

    private Customer getCustomer(ResultSet resultSet) {
        Customer customer = new Customer();
        try {
            customer.setId(resultSet.getLong("ID"));
            customer.setFirstName(resultSet.getString("FIRST_NAME"));
            customer.setLastName(resultSet.getString("LAST_NAME"));
            customer.setAddress(resultSet.getString("ADDRESS"));
            customer.setPhone(resultSet.getString("PHONE"));
            customer.setEmail(resultSet.getString("EMAIL"));
            customer.setPassword(resultSet.getString("PASSWORD"));
        } catch (SQLException e) {
            logger.info("Customer not create.");
        }
        return customer;
    }
}
