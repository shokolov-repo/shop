package dao.impl.jdbc;

import dao.ProductSoldDao;
import entity.ProductSold;
import org.junit.Test;

import java.util.List;

/**
 * @author Shokolov Dmitry
 */
public class ProductSoldDaoImplTest extends BeforeTestShop {
    ProductSoldDao productSoldDao = new ProductSoldDaoImpl();


    @Test
    public void testCreate() throws Exception {
//        given
        ProductSold testProductSold = new ProductSold();
        testProductSold.setId(3);
        testProductSold.setPrice(1.00);
        testProductSold.setQuantity(1);
        testProductSold.setTitle("new productSold");
//        when
        productSoldDao.create(testProductSold);
        List<ProductSold> productsSold = productSoldDao.findAll(3);

//        then
        assertEquals(1.00, productsSold.get(0).getPrice());
        assertEquals(1, productsSold.get(0).getQuantity());
        assertEquals("new productSold", productsSold.get(0).getTitle());
    }

    @Test
    public void testUpdate() throws Exception {
//        given
        List<ProductSold> testProductsSold = productSoldDao.findAll(1);
        testProductsSold.get(0).setQuantity(5);

//        when
        productSoldDao.update(testProductsSold.get(0));
        List<ProductSold> productsSold = productSoldDao.findAll(1);

//        then
        assertEquals(1.00, productsSold.get(0).getPrice());
        assertEquals(5, productsSold.get(0).getQuantity());
        assertEquals("product 1", productsSold.get(0).getTitle());
    }

    @Test
    public void testDelete() throws Exception {
//        when
        productSoldDao.deleteAll(1);
        List<ProductSold> productsSold = productSoldDao.findAll(1);

//        then
        assertEquals(productsSold.size(), 0);
    }

    @Test
    public void testFindByOrderId() throws Exception {
//        when
        List<ProductSold> productsSold = productSoldDao.findAll(1);

//        then
        assertEquals(1,productsSold.size());
        assertEquals(1.00, productsSold.get(0).getPrice());
        assertEquals(1, productsSold.get(0).getQuantity());
        assertEquals("product 1", productsSold.get(0).getTitle());
    }

    @Test
    public void testFindAll() throws Exception {
//        given

//        when
        List<ProductSold> productsSold = productSoldDao.findAll();

//        then
        assertEquals(2, productsSold.size());

        assertEquals(1, productsSold.get(0).getId());
        assertEquals(1.00, productsSold.get(0).getPrice());
        assertEquals(1, productsSold.get(0).getQuantity());
        assertEquals("product 1", productsSold.get(0).getTitle());

        assertEquals(2, productsSold.get(1).getId(), 2);
        assertEquals(1.00, productsSold.get(1).getPrice());
        assertEquals(2, productsSold.get(1).getQuantity());
        assertEquals("product 1", productsSold.get(1).getTitle());
    }
}