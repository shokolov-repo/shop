package dao.impl.jdbc;

import dao.ProductDao;
import entity.Product;
import org.junit.Test;

import java.util.List;

/**
 * Created by dmity on 16.10.15.
 */
public class ProductDaoImplTest extends BeforeTestShop {
    ProductDao productDao = new ProductDaoImpl();

    @Test
    public void testCreate() throws Exception {
//        given
        Product testProduct = new Product();
        testProduct.setId(4);
        testProduct.setTitle("product 4");
        testProduct.setQuantity(5);
        testProduct.setPrice(4.00);
        testProduct.setDescription("description product 1");

//        when
        productDao.create(testProduct);
        Product product = productDao.findById(4);

//        then
        assertEquals("product 4", product.getTitle());
        assertEquals(5, product.getQuantity());
        assertEquals(4.00, product.getPrice());
        assertEquals("description product 1", product.getDescription());
    }

    @Test
    public void testUpdate() throws Exception {
//        given
        Product testProduct = productDao.findById(1);
        testProduct.setDescription("update description");

//        when
        productDao.update(testProduct);
        Product product = productDao.findById(1);

//        then
        assertEquals("product 1", product.getTitle());
        assertEquals(5, product.getQuantity());
        assertEquals(1.00, product.getPrice());
        assertEquals("update description", product.getDescription());
    }

    @Test
    public void testDelete() throws Exception {
//      when
        productDao.delete(1);
        Product product = productDao.findById(1);

//      then
        assertNull(product);
    }

    @Test
    public void testFindById() throws Exception {
//        when
        Product product = productDao.findById(3);
//        then

        assertEquals("product 3", product.getTitle());
        assertEquals(5, product.getQuantity());
        assertEquals(3.00, product.getPrice());
        assertEquals("description product 3", product.getDescription());
    }

    @Test
    public void testFindByTitle() throws Exception {
//        when
        Product product = productDao.findByTitle("product 3");
//        then

        assertEquals(3, product.getId());
        assertEquals(5, product.getQuantity());
        assertEquals(3.00, product.getPrice());
        assertEquals("description product 3", product.getDescription());
    }

    @Test
    public void testFindByPrice() throws Exception {
//        when
        Product product = productDao.findByPrice(3.00);

//        then
        assertEquals(3, product.getId());
        assertEquals(5, product.getQuantity());
        assertEquals("product 3", product.getTitle());
        assertEquals("description product 3", product.getDescription());
    }

    @Test
    public void testFindByAll() throws Exception {
//        when
        List<Product> products = productDao.findAll();

//        then
        assertEquals(1, products.get(0).getId());
        assertEquals(2, products.get(1).getId());
        assertEquals(3, products.get(2).getId());
        assertEquals("product 3", products.get(2).getTitle());
        assertEquals("description product 3", products.get(2).getDescription());
    }
}