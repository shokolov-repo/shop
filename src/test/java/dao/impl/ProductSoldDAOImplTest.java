package dao.impl;

import dao.ProductSoldDAO;
import entity.ProductSold;
import org.junit.Test;

import java.util.List;

/**
 * Created by dmity on 16.10.15.
 */
public class ProductSoldDAOImplTest extends BeforeTestShop {
    ProductSoldDAO productSoldDAO = new ProductSoldDAOImpl();


    @Test
    public void testCreate() throws Exception {
//        given
        ProductSold testProductSold = new ProductSold();
        testProductSold.setOrderId(3);
        testProductSold.setPrice(1.00);
        testProductSold.setQuantity(1);
        testProductSold.setTitle("new productSold");
//        when
        productSoldDAO.create(testProductSold);
        List<ProductSold> productsSold = productSoldDAO.findAll(3);

//        then
        assertEquals(1.00, productsSold.get(0).getPrice());
        assertEquals(1, productsSold.get(0).getQuantity());
        assertEquals("new productSold", productsSold.get(0).getTitle());
    }

    @Test
    public void testUpdate() throws Exception {
//        given
        ProductSold testProductSold = new ProductSold();//productSoldDAO.findAll(1);
        testProductSold.setOrderId(1);
        testProductSold.setPrice(1.00);
        testProductSold.setQuantity(5);
        testProductSold.setTitle("product 1");
//        when
        productSoldDAO.update(testProductSold);
        List<ProductSold> productsSold = productSoldDAO.findAll(1);

//        then
        assertEquals(1.00, productsSold.get(0).getPrice());
        assertEquals(5, productsSold.get(0).getQuantity());
        assertEquals("product 1", productsSold.get(0).getTitle());
    }

    @Test
    public void testDelete() throws Exception {
//        when
        productSoldDAO.deleteAll(1);
        List<ProductSold> productsSold = productSoldDAO.findAll(1);

//        then
        assertEquals(productsSold.size(), 0);
    }

    @Test
    public void testFindByOrderId() throws Exception {
//        when
        List<ProductSold> productsSold = productSoldDAO.findAll(1);

//        then
        //assert list size
        assertEquals(1.00, productsSold.get(0).getPrice());
        assertEquals(1, productsSold.get(0).getQuantity());
        assertEquals("product 1", productsSold.get(0).getTitle());
    }

    @Test
    public void testFindAll() throws Exception {
//        given

//        when
        List<ProductSold> productsSold = productSoldDAO.findAll();

//        then
        assertEquals(2, productsSold.size());
        assertEquals(1, productsSold.get(0).getOrderId());
        assertEquals(1.00, productsSold.get(0).getPrice());
        assertEquals(1, productsSold.get(0).getQuantity());
        assertEquals("product 1", productsSold.get(0).getTitle());
        assertEquals(2, productsSold.get(1).getOrderId(), 2);
        assertEquals(1.00, productsSold.get(1).getPrice());
        assertEquals(2, productsSold.get(1).getQuantity());
        assertEquals("product 1", productsSold.get(1).getTitle());
    }
}