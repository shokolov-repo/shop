package dao.impl.jdbc;

import dao.OrderDao;
import entity.Order;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;


/**
 * @author Shokolov Dmitry
 */
public class OrderDaoImpl implements OrderDao {
    Logger logger = Logger.getLogger(OrderDaoImpl.class);
    java.sql.Connection connection;
    private String CREATE = "INSERT INTO ORDERS (USER_ID , DATE_ORDER , STATUS )" +
            "VALUES ( ? , ? , ? )";
    private String UPDATE = "UPDATE ORDERS SET STATUS = ? WHERE ID = ?";
    private String DELETE = "DELETE FROM ORDERS WHERE ID = ?";
    private String FIND_BY_ID = "SELECT * FROM ORDERS WHERE ID = ?";
    private String FIND_BY_DATE = "SELECT * FROM ORDERS WHERE DATE_ORDER = ?";
    private String FIND_ALL_BY_STATUS = "SELECT * FROM ORDERS WHERE STATUS = ?";
    private String FIND_ALL_BY_USER_ID = "SELECT * FROM ORDERS WHERE USER_ID = ?";
    private String FIND_ALL = "SELECT * FROM ORDERS";

    @Override
    public void create(Order order) {
        if (order == null) {
            logger.error("Order == null");
            throw new NullPointerException();
        }
        connection = ConnectionJdbc.createConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(CREATE);

            statement.setLong(1, order.getUserId());
            statement.setDate(2, order.getDateOrder());
            statement.setString(3, order.getStatus());
            int i = statement.executeUpdate();

            if (i == 0) {
                logger.trace(order + "wasn't create");
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            ConnectionJdbc.closeConnection(connection);
        }
    }

    @Override
    public void update(Order order) {
        connection = ConnectionJdbc.createConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE);

            statement.setString(1, order.getStatus());
            statement.setLong(2, order.getId());
            int i = statement.executeUpdate();

            if (i == 0) {
                logger.trace(order + "wasn't update");
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            ConnectionJdbc.closeConnection(connection);
        }
    }

    @Override
    public void delete(long id) {
        connection = ConnectionJdbc.createConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE);

            statement.setLong(1, id);
            int i = statement.executeUpdate();

            if (i == 0) {
                logger.trace("order + wasn't delete");
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public Order findById(long id) {
        Order order = null;
        ResultSet resultSet;
        connection = ConnectionJdbc.createConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(FIND_BY_ID);

            statement.setLong(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                order = getOrder(resultSet);
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return order;
    }

    @Override
    public Order findByDate(Date date) {
        Order order = null;
        ResultSet resultSet;
        connection = ConnectionJdbc.createConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(FIND_BY_DATE);

            statement.setDate(1, date);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                order = getOrder(resultSet);
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return order;
    }

    @Override
    public List<Order> findAllByUserId(long userId) {
        List<Order> orders = new LinkedList<>();
        ResultSet resultSet;
        connection = ConnectionJdbc.createConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(FIND_ALL_BY_USER_ID);

            statement.setLong(1, userId);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                orders.add(getOrder(resultSet));
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return orders;
    }

    @Override
    public List<Order> findAllByStatus(String status) {
        List<Order> orders = new LinkedList<>();
        ResultSet resultSet;
        connection = ConnectionJdbc.createConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(FIND_ALL_BY_STATUS);

            statement.setString(1, status);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                orders.add(getOrder(resultSet));
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return orders;
    }

    @Override
    public List<Order> findAll() {
        List<Order> orders = new LinkedList<>();
        ResultSet resultSet;
        connection = ConnectionJdbc.createConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(FIND_ALL);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                orders.add(getOrder(resultSet));
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return orders;
    }

    private Order getOrder(ResultSet resultSet) {
        Order order = new Order();
        try {
            order.setId(resultSet.getLong("ID"));
            order.setUserId(resultSet.getLong("USER_ID"));
            order.setDateOrder(resultSet.getDate("DATE_ORDER"));
            order.setStatus(resultSet.getString("STATUS"));
        } catch (SQLException e) {
            logger.info("Order not create." + e.getMessage());
        }
        return order;
    }
}
