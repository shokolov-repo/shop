package dao;

import entity.Order;

import java.sql.Date;
import java.util.Collection;
import java.util.List;


/**
 * @author Shokolov Dmitry
 */
public interface OrderDao {
    void create(Order order);

    void update(Order order);

    void delete(long id);

    Order findById(long id);

    Order findByDate(Date date);

    Collection<Order> findAllByUserId(long userId);

    Collection<Order> findAllByStatus(String status);

    Collection<Order> findAll();
}
