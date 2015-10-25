package dao.impl;

import dao.ProductDAO;
import entity.Product;
import org.junit.Test;

import java.util.List;

/**
 * Created by dmity on 16.10.15.
 */
public class ProductDAOImplTest extends BeforeTestShop {
    ProductDAO productDAO = new ProductDAOImpl();

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
        productDAO.create(testProduct);
        Product product = productDAO.findById(4);

//        then
        assertEquals("product 4", product.getTitle());
        assertEquals(5, product.getQuantity());
        assertEquals(4.00, product.getPrice());
        assertEquals("description product 1", product.getDescription());
    }

    @Test
    public void testUpdate() throws Exception {
//        given
        Product testProduct = productDAO.findById(1);
        testProduct.setDescription("update description");

//        when
        productDAO.update(testProduct);
        Product product = productDAO.findById(1);

//        then
        assertEquals("product 1", product.getTitle());
        assertEquals(5, product.getQuantity());
        assertEquals(1.00, product.getPrice());
        assertEquals("update description", product.getDescription());
    }

    @Test
    public void testDelete() throws Exception {
//      when
        productDAO.delete(1);
        Product product = productDAO.findById(1);

//      then
        assertNull(product);
    }

    @Test
    public void testFindById() throws Exception {
//        when
        Product product = productDAO.findById(3);
//        then

        assertEquals("product 3", product.getTitle());
        assertEquals(5, product.getQuantity());
        assertEquals(3.00, product.getPrice());
        assertEquals("description product 3", product.getDescription());
    }

    @Test
    public void testFindByTitle() throws Exception {
//        when
        Product product = productDAO.findByTitle("product 3");
//        then

        assertEquals(3, product.getId());
        assertEquals(5, product.getQuantity());
        assertEquals(3.00, product.getPrice());
        assertEquals("description product 3", product.getDescription());
    }

    @Test
    public void testFindByPrice() throws Exception {
//        when
        Product product = productDAO.findByPrice(3.00);

//        then
        assertEquals(3, product.getId());
        assertEquals(5, product.getQuantity());
        assertEquals("product 3", product.getTitle());
        assertEquals("description product 3", product.getDescription());
    }

    @Test
    public void testFindByAll() throws Exception {
//        when
        List<Product> products = productDAO.findAll();

//        then
        assertEquals(1, products.get(0).getId());
        assertEquals(2, products.get(1).getId());
        assertEquals(3, products.get(2).getId());
        assertEquals("product 3", products.get(2).getTitle());
        assertEquals("description product 3", products.get(2).getDescription());
    }
}