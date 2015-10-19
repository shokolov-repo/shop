package dao;

import entity.Seller;

import java.util.List;

/**
 * Created by dmity on 13.10.15.
 */
public interface SellerDAO {
    void create(Seller seller);

    void update(Seller seller);

    void delete(long id);

    Seller findById(long id);

    List<Seller> findAll();

}
