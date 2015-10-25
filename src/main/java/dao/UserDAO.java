package dao;

import entity.User;

import java.util.List;

/**
 * Created by dmity on 13.10.15.
 */
public interface UserDAO {
    void create(User user);

    void update(User user);

    void delete(long id);

    User findById(long id);

    User findByEmail(String email);

    List<User> findByRole(String role);

    List<User> findAll();

}
