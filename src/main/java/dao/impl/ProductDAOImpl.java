package dao.impl;

import dao.ConnectionDB;
import dao.ProductDAO;
import entity.Product;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmity on 16.10.15.
 */
public class ProductDAOImpl implements ProductDAO {
    Logger logger = Logger.getLogger(UserDAOImpl.class);
    Connection connection;
    private String CREATE = "INSERT INTO PRODUCTS (TITLE , PRICE , QUANTITY , DESCRIPTION )" +
            " VALUES ( ? , ? , ? , ? )";
    private String UPDATE = "UPDATE PRODUCTS SET TITLE = ? , PRICE = ? , QUANTITY = ? , DESCRIPTION = ? WHERE ID = ?";
    private String DELETE = "DELETE FROM PRODUCTS WHERE ID = ?";
    private String FIND_BY_ID = "SELECT * FROM PRODUCTS WHERE ID = ?";
    private String FIND_BY_TITLE = "SELECT * FROM PRODUCTS WHERE TITLE = ?";
    private String FIND_BY_PRICE = "SELECT * FROM PRODUCTS WHERE PRICE = ?";
    private String FIND_ALL = "SELECT * FROM PRODUCTS";

    @Override
    public void create(Product product) {
        if (product == null) {
            logger.error("product == null");
            throw new NullPointerException();
        }
        connection = ConnectionDB.createConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(CREATE);

            statement.setString(1, product.getTitle());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getQuantity());
            statement.setString(4, product.getDescription());
            int i = statement.executeUpdate();

            if (i == 0) {
                logger.trace(product + "wasn't create");
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(connection);
        }
    }

    @Override
    public void update(Product product) {
        connection = ConnectionDB.createConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE);

            statement.setString(1, product.getTitle());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3, product.getQuantity());
            statement.setString(4, product.getDescription());
            statement.setLong(5, product.getId());
            int i = statement.executeUpdate();

            if (i == 0) {
                logger.trace(product + "wasn't update");
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
                logger.trace("product wasn't delete");
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public Product findById(long id) {
        Product product = null;
        ResultSet resultSet;
        connection = ConnectionDB.createConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(FIND_BY_ID);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                product = getProduct(resultSet);
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return product;
    }

    @Override
    public Product findByTitle(String title) {
        Product product = null;
        ResultSet resultSet;
        connection = ConnectionDB.createConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(FIND_BY_TITLE);
            statement.setString(1, title);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                product = getProduct(resultSet);
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return product;
    }

    @Override
    public Product findByPrice(double price) {
        Product product = null;
        ResultSet resultSet;
        connection = ConnectionDB.createConnection();


        try {
            PreparedStatement statement = connection.prepareStatement(FIND_BY_PRICE);
            statement.setDouble(1, price);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                product = getProduct(resultSet);
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return product;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        ResultSet resultSet;
        connection = ConnectionDB.createConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(FIND_ALL);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                products.add(getProduct(resultSet));
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return products;
    }

    private Product getProduct(ResultSet resultSet) {
        Product product = new Product();
        try {
            product.setId(resultSet.getLong("ID"));
            product.setTitle(resultSet.getString("TITLE"));
            product.setPrice(resultSet.getDouble("PRICE"));
            product.setQuantity(resultSet.getInt("QUANTITY"));
            product.setDescription(resultSet.getString("DESCRIPTION"));
        } catch (SQLException e) {
            logger.info("Product not create.");
        }
        return product;
    }
}
