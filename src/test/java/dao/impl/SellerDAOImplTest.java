package dao.impl;

import dao.SellerDAO;
import entity.Seller;
import org.junit.Test;

import java.util.List;

/**
 * Created by dmity on 16.10.15.
 */
public class SellerDAOImplTest extends BeforeTestShop {
    SellerDAO sellerDAO = new SellerDAOImpl();

    @Test
    public void testCreate() throws Exception {
//      given
        Seller TestSeller = new Seller();
        TestSeller.setId(3);
        TestSeller.setFirstName("Seller 3");
        TestSeller.setLastName("Seller 3");
        TestSeller.setPhone("3456");
        TestSeller.setEmail("Seller3@mail.com");
        TestSeller.setPassword("seller");

//      when
        sellerDAO.create(TestSeller);
        Seller seller = sellerDAO.findById(3);

//      then
        assertEquals("Seller 3", seller.getFirstName());
        assertEquals("Seller 3", seller.getLastName());
        assertEquals("3456", seller.getPhone());
        assertEquals("Seller3@mail.com", seller.getEmail());
        assertEquals("seller", seller.getPassword());
    }

    @Test
    public void testUpdate() throws Exception {
//      given
        Seller testSeller = sellerDAO.findById(2);
        testSeller.setPassword("newpassword");

//      when
        sellerDAO.update(testSeller);
        Seller seller = sellerDAO.findById(2);

//      then
        assertEquals("seller 2", seller.getFirstName());
        assertEquals("seller 2", seller.getLastName());
        assertEquals("2345", seller.getPhone());
        assertEquals("seller2@email.com", seller.getEmail());
        assertEquals("newpassword", seller.getPassword());
    }

    @Test
    public void testDelete() throws Exception {
//      when
        sellerDAO.delete(2);
        Seller seller = sellerDAO.findById(2);

//      then
        assertNull(seller);
    }

    @Test
    public void testFindById() throws Exception {
//        when
        Seller seller = sellerDAO.findById(1);

//        then
        assertEquals("seller 1", seller.getFirstName());
    }

    @Test
    public void testFindAll() throws Exception {
//        when
        List<Seller> sellers = sellerDAO.findAll();

//        then
        //list size
        assertEquals("seller 1", sellers.get(0).getFirstName());
        assertEquals("seller 2", sellers.get(1).getFirstName());
    }
}