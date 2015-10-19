package dao;

import entity.Customer;

import java.util.List;

/**
 * Created by dmity on 13.10.15.
 */
public interface CustomerDAO {
    void create(Customer customer);

    void update(Customer customer);

    void delete(long id);

    Customer findById(long id);

    Customer findByEmail(String email);

    List<Customer> findAll();
}
