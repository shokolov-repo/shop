package dao.impl;

import entity.Customer;
import org.junit.Test;

import java.util.List;

/**
 * Created by dmity on 14.10.15.
 */
public class CustomerDAOImplTest extends BeforeTestShop {
    CustomerDAOImpl customerDAO = new CustomerDAOImpl();

    @Test
    public void testCreate() throws Exception {

//      given
        Customer testCustomer = new Customer();
        testCustomer.setId(4);
        testCustomer.setFirstName("taras");
        testCustomer.setLastName("bulba");
        testCustomer.setAddress("Ukraine");
        testCustomer.setPhone("4567");
        testCustomer.setEmail("taras@bulba.us");
        testCustomer.setPassword("shablya");

//      when
        customerDAO.create(testCustomer);
        Customer customer = customerDAO.findById(4);

//      then
        assertEquals("taras", customer.getFirstName());
        assertEquals("bulba", customer.getLastName());
        assertEquals("Ukraine", customer.getAddress());
        assertEquals("4567", customer.getPhone());
        assertEquals("taras@bulba.us", customer.getEmail());
        assertEquals("shablya", customer.getPassword());
    }

    @Test
    public void testUpdate() throws Exception {
//      given
        Customer customer = customerDAO.findById(1);
        customer.setPassword("texas");

//      when
        customerDAO.update(customer);
        customer = customerDAO.findById(1);

//      then
        assertEquals("chuck", customer.getFirstName());
        assertEquals("norris", customer.getLastName());
        assertEquals("USA", customer.getAddress());
        assertEquals("1234", customer.getPhone());
        assertEquals("chuck@norris.us", customer.getEmail());
        assertEquals("texas", customer.getPassword());
    }

    @Test
    public void testDelete() throws Exception {
//      when
        customerDAO.delete(3);
        Customer customer = customerDAO.findById(3);

//      then
        assertNull(customer);
    }

    @Test
    public void testFindById() throws Exception {
//      when
        Customer customer = customerDAO.findById(1);

//      then
        assertEquals("chuck", customer.getFirstName());
    }

    @Test
    public void testFindByEmail() throws Exception {
//      when
        Customer customer = customerDAO.findByEmail("chuck@norris.us");

//      then
        assertEquals(1, customer.getId());
        assertEquals("chuck", customer.getFirstName());
    }

    @Test
    public void testFindAll() throws Exception {
//      when
        List<Customer> customers = customerDAO.findAll();

//      then
        assertEquals(3, customers.size());
        assertEquals(1, customers.get(0).getId());
        assertEquals("chuck", customers.get(0).getFirstName());
        assertEquals(2, customers.get(1).getId());
        assertEquals("bruce", customers.get(1).getFirstName());
        assertEquals(3, customers.get(2).getId());
    }
}