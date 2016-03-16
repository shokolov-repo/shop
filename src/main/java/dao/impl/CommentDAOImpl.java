package dao.impl;

import dao.CommentDAO;
import dao.ConnectionDB;
import entity.Comment;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dmity on 16.10.15.
 */
public class CommentDAOImpl implements CommentDAO {
    Logger logger = Logger.getLogger(UserDAOImpl.class);
    Connection connection;
    private String CREATE = "INSERT INTO COMMENTS (PRODUCT_ID , USER_ID , USER_NAME , CONTENT )" +
            "VALUES ( ? , ? , ? , ? )";
    private String UPDATE = "UPDATE COMMENTS SET CONTENT = ?  WHERE ID = ?";
    private String DELETE = "DELETE FROM COMMENTS WHERE USER_ID = ?";
    private String FIND_BY_USER_ID = "SELECT * FROM COMMENTS WHERE USER_ID = ? ";
    private String FIND_BY_PRODUCT_ID = "SELECT * FROM COMMENTS WHERE PRODUCT_ID = ?";

    @Override
    public void create(Comment comment) {
        if (comment == null) {
            logger.error("Comment == null");
            throw new NullPointerException();
        }
        connection = ConnectionDB.createConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(CREATE);

            statement.setLong(1, comment.getProductId());
            statement.setLong(2, comment.getUserId());
            statement.setString(3, comment.getUserName());
            statement.setString(4, comment.getContent());
            int i = statement.executeUpdate();

            if (i == 0) {
                logger.trace(comment + "wasn't create");
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(connection);
        }
    }

    @Override
    public void update(Comment comment) {
        connection = ConnectionDB.createConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE);

            statement.setString(1, comment.getContent());
            statement.setLong(2, comment.getId());
            int i = statement.executeUpdate();

            if (i == 0) {
                logger.trace(comment + "wasn't update");
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            ConnectionDB.closeConnection(connection);
        }
    }

    @Override
    public void delete(long userId) {
        connection = ConnectionDB.createConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE);
            statement.setLong(1, userId);
            int i = statement.executeUpdate();

            if (i == 0) {
                logger.trace("Comment wasn't delete");
            }
        } catch (SQLException e) {

            logger.error(e.getMessage());
        }
    }

    @Override
    public List<Comment> findByUserId(long userId) {
        List<Comment> comments = new LinkedList<>();
        ResultSet resultSet;
        connection = ConnectionDB.createConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(FIND_BY_USER_ID);
            statement.setLong(1, userId);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                comments.add(getComment(resultSet));
            }

        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return comments;
    }

    @Override
    public List<Comment> findByProductId(long productId) {
        List<Comment> comments = new LinkedList<>();
        ResultSet resultSet;
        connection = ConnectionDB.createConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(FIND_BY_PRODUCT_ID);
            statement.setLong(1, productId);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                comments.add(getComment(resultSet));
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return comments;
    }

    private Comment getComment(ResultSet resultSet) {
        Comment comment = new Comment();
        try {
            comment.setId(resultSet.getLong("ID"));
            comment.setProductId(resultSet.getLong("PRODUCT_ID"));
            comment.setUserId(resultSet.getLong("USER_ID"));
            comment.setUserName(resultSet.getString("USER_NAME"));
            comment.setContent(resultSet.getString("CONTENT"));

        } catch (SQLException e) {
            logger.info("Comment not create.");
        }
        return comment;
    }

}
