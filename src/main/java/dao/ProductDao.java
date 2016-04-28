package dao;

import entity.Product;

import java.util.List;

/**
 * @author Shokolov Dmitry
 */
public interface ProductDao {
    void create(Product product);

    void update(Product product);

    void delete(long id);

    Product findById(long id);

    Product findByTitle(String title);

    Product findByPrice(double price);

    List<Product> findAll();

}
