package dao;

import entity.Comment;

import java.util.List;

/**
 * Created by dmity on 13.10.15.
 */
public interface CommentDAO {
    void create(Comment comment);

    void update(Comment comment);

    void delete(long id);

    List<Comment> findByProductId(long productId);

    List<Comment> findByCustomerId(long customerId);
}
