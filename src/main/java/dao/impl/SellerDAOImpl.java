package dao.impl;

import dao.ConnectionDB;
import dao.SellerDAO;
import entity.Seller;
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
public class SellerDAOImpl implements SellerDAO {
    Logger logger = Logger.getLogger(CustomerDAOImpl.class);
    private String CREATE = "INSERT INTO SELLERS (FIRST_NAME , LAST_NAME , PHONE ,  EMAIL , PASSWORD )" +
            "VALUES ( ? , ? , ? , ? , ? )";
    private String UPDATE = "UPDATE SELLERS SET FIRST_NAME = ? , LAST_NAME = ? , PHONE = ? , EMAIL = ? ," +
            "PASSWORD = ? WHERE ID = ?";
    private String DELETE = "DELETE FROM SELLERS WHERE ID = ?";
    private String FIND_BY_ID = "SELECT * FROM SELLERS WHERE ID = ?";
    private String FIND_ALL = "SELECT * FROM SELLERS";
    Connection connection;

    @Override
    public void create(Seller seller) {
        if (seller == null) {
            logger.error("Seller == null");
            throw new NullPointerException();
        }
        connection = ConnectionDB.createConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(CREATE);

            statement.setString(1, seller.getFirstName());
            statement.setString(2, seller.getLastName());
            statement.setString(3, seller.getPhone());
            statement.setString(4, seller.getEmail());
            statement.setString(5, seller.getPassword());
            int i = statement.executeUpdate();

            if (i == 0) {
                logger.trace(seller + "wasn't create");
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(connection);
        }
    }

    @Override
    public void update(Seller seller) {
        connection = ConnectionDB.createConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE);

            statement.setString(1, seller.getFirstName());
            statement.setString(2, seller.getLastName());
            statement.setString(3, seller.getPhone());
            statement.setString(4, seller.getEmail());
            statement.setString(5, seller.getPassword());
            statement.setLong(6, seller.getId());
            int i = statement.executeUpdate();

            if (i == 0) {
                logger.trace(seller + "wasn't update");
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
                logger.trace("seller + wasn't delete");
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public Seller findById(long id) {
       Seller seller = null;
        ResultSet resultSet;
        connection = ConnectionDB.createConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(FIND_BY_ID);

            statement.setLong(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                seller = getSeller(resultSet);
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return seller;
    }

    @Override
    public List<Seller> findAll() {
        List<Seller> sellers = new ArrayList<>();
        ResultSet resultSet;
        connection = ConnectionDB.createConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(FIND_ALL);
            resultSet = statement.executeQuery();

            while (resultSet.next()){
                sellers.add(getSeller(resultSet));
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return sellers;
    }

    private Seller getSeller(ResultSet resultSet) {
        Seller seller = new Seller();
        try {
            seller.setId(resultSet.getLong("ID"));
            seller.setFirstName(resultSet.getString("FIRST_NAME"));
            seller.setLastName(resultSet.getString("LAST_NAME"));
            seller.setPhone(resultSet.getString("PHONE"));
            seller.setEmail(resultSet.getString("EMAIL"));
            seller.setPassword(resultSet.getString("PASSWORD"));
        } catch (SQLException e) {
            logger.info("Seller not created.");
        }
        return seller;
    }
}
