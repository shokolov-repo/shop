package dao;

import entity.ProductSold;

import java.util.List;

/**
 * @author Shokolov Dmitry
 */
public interface ProductSoldDao {
    void create(ProductSold productSold);

    void update(ProductSold productSold);

    void deleteAll(long orderId);

    List<ProductSold> findAll(long orderId);

    List<ProductSold> findAll();

}
