package dao;

import entity.Comment;

import java.util.List;

/**
 * @author Shokolov Dmitry
 */
public interface CommentDao {
    void create(Comment comment);

    void update(Comment comment);

    void delete(long UserId);

    List<Comment> findByProductId(long productId);

    List<Comment> findByUserId(long userId);
}
