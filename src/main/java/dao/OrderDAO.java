package dao;

import entity.Order;

import java.sql.Date;
import java.util.List;


/**
 * Created by dmity on 13.10.15.
 */
public interface OrderDAO {
    void create(Order order);

    void update(Order order);

    void delete(long id);

    Order findById(long id);

    Order findByDate(Date date);

    List<Order> findAllByUserId(long userId);

    List<Order> findAllByStatus(String status);

    List<Order> findAll();
}
