package dao;

import entity.ProductSold;

import java.util.List;

/**
 * Created by dmity on 13.10.15.
 */
public interface ProductSoldDAO {
    void create(ProductSold productSold);

    void update(ProductSold productSold);

    void deleteAll(long orderId);

    List<ProductSold> findAll(long orderId);

    List<ProductSold> findAll();

}
