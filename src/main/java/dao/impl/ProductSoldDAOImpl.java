package dao.impl;

import dao.ConnectionDB;
import dao.ProductSoldDAO;
import entity.ProductSold;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dmity on 16.10.15.
 */
public class ProductSoldDAOImpl implements ProductSoldDAO {
    Logger logger = Logger.getLogger(UserDAOImpl.class);
    private String CREATE = "INSERT INTO PRODUCTS_SOLD (ORDER_ID , TITLE , QUANTITY , PRICE )" +
            "VALUES ( ? , ? , ? , ? )";
    private String UPDATE = "UPDATE PRODUCTS_SOLD SET TITLE = ? , QUANTITY = ? , PRICE = ? WHERE ORDER_ID = ?";
    private String DELETE_ALL_BY_ORDER_ID = "DELETE FROM PRODUCTS_SOLD WHERE ORDER_ID = ?";
    private String FIND_ALL_BY_ORDER_ID = "SELECT * FROM PRODUCTS_SOLD WHERE ORDER_ID = ?";
    private String FIND_ALL = "SELECT * FROM PRODUCTS_SOLD";
    Connection connection;

    @Override
    public void create(ProductSold productSold) {
        if (productSold == null) {
            logger.error("ProductSold == null");
            throw new NullPointerException();
        }
        connection = ConnectionDB.createConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(CREATE);

            statement.setLong(1, productSold.getOrderId());
            statement.setString(2, productSold.getTitle());
            statement.setInt(3, productSold.getQuantity());
            statement.setDouble(4, productSold.getPrice());
            int i = statement.executeUpdate();

            if (i == 0) {
                logger.trace(productSold + "wasn't create");
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(connection);
        }
    }

    @Override
    public void update(ProductSold productSold) {
        connection = ConnectionDB.createConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE);

            statement.setString(1, productSold.getTitle());
            statement.setInt(2, productSold.getQuantity());
            statement.setDouble(3, productSold.getPrice());
            statement.setLong(4, productSold.getOrderId());
            int i = statement.executeUpdate();

            if (i == 0) {
                logger.trace(productSold + "wasn't update");
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(connection);
        }
    }

    @Override
    public void deleteAll(long orderId) {
        connection = ConnectionDB.createConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_ALL_BY_ORDER_ID);

            statement.setLong(1, orderId);
            int i = statement.executeUpdate();

            if (i == 0) {
                logger.trace("productSold + wasn't delete");
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public List<ProductSold> findAll(long orderId) {
        List<ProductSold> productsSold = new LinkedList<>();
        ResultSet resultSet;
        connection = ConnectionDB.createConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(FIND_ALL_BY_ORDER_ID);

            statement.setLong(1, orderId);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                productsSold.add(getProductSold(resultSet));
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return productsSold;
    }

    @Override
    public List<ProductSold> findAll() {
        List<ProductSold> productsSold = new ArrayList<>();
        ResultSet resultSet;
        connection = ConnectionDB.createConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(FIND_ALL);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                productsSold.add(getProductSold(resultSet));
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return productsSold;
    }

    private ProductSold getProductSold(ResultSet resultSet) {
        ProductSold productSold = new ProductSold();
        try {
            productSold.setOrderId(resultSet.getLong("ORDER_ID"));
            productSold.setTitle(resultSet.getString("TITLE"));
            productSold.setQuantity(resultSet.getInt("QUANTITY"));
            productSold.setPrice(resultSet.getDouble("PRICE"));
        } catch (SQLException e) {
            logger.info("ProductSold not create.");
        }
        return productSold;
    }
}
