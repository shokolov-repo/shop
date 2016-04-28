package dao;

import entity.User;

import java.util.List;

/**
 * @author Shokolov Dmitry
 */
public interface UserDao {
    void create(User user);

    void update(User user);

    void delete(long id);

    User findById(long id);

    User findByEmail(String email);

    List<User> findByRole(String role);

    List<User> findAll();

}
