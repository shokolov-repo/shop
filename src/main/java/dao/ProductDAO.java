package dao;

import entity.Product;

import java.util.List;

/**
 * Created by dmity on 13.10.15.
 */
public interface ProductDAO {
    void create(Product product);

    void update(Product product);

    void delete(long id);

    Product findById(long id);

    Product findByTitle(String title);

    Product findByPrice(double price);

    List<Product> findAll();

}
