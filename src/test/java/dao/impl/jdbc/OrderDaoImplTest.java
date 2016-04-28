package dao.impl.jdbc;

import dao.OrderDao;
import entity.Order;
import org.junit.Test;

import java.sql.Date;
import java.util.List;

/**
 * Created by dmity on 16.10.15.
 */
public class OrderDaoImplTest extends BeforeTestShop {
    OrderDao orderDao = new OrderDaoImpl();

    @Test
    public void testCreate() throws Exception {
//        given
        Order testOrder = new Order();
        testOrder.setId(4);
        testOrder.setUserId(1);
        testOrder.setDateOrder(Date.valueOf("2010-03-05"));
        testOrder.setStatus("check");

//        when
        orderDao.create(testOrder);
        Order order = orderDao.findById(4);

//        then
        assertEquals(1, order.getUserId());
        assertEquals(Date.valueOf("2010-03-05"), order.getDateOrder());
        assertEquals("check", order.getStatus());
    }

    @Test
    public void testUpdate() throws Exception {
//        given
        Order testOrder = orderDao.findById(1);
        testOrder.setStatus("update");

//        when
        orderDao.update(testOrder);
        Order order = orderDao.findById(1);

//        then
        assertEquals("update", order.getStatus());
    }

    @Test
    public void testDelete() throws Exception {
//        when
        orderDao.delete(3);
        Order order = orderDao.findById(3);

//        then
        assertNull(order);
    }

    @Test
    public void testFindById() throws Exception {
//        when
        Order order = orderDao.findById(1);

//        then
        assertEquals("sold", order.getStatus(), "sold");
        assertEquals(Date.valueOf("2015-02-12"), order.getDateOrder());
        assertEquals(1, order.getUserId());
    }

    @Test
    public void testFindByDate() throws Exception {
//        when
        Order order = orderDao.findByDate(Date.valueOf("2015-02-12"));

//        then
        assertEquals("sold", order.getStatus());
        assertEquals(1, order.getId());
        assertEquals(1, order.getUserId());
    }

    @Test
    public void testFindByStatus() throws Exception {
//        when
        List<Order> orders = (List<Order>) orderDao.findAllByStatus("sold");

//        then
        assertEquals(1, orders.get(0).getId());
        assertEquals(2, orders.size());
    }

    @Test
    public void testFindAll() throws Exception {
//        when
        List<Order> orders = (List<Order>) orderDao.findAll();

//        then
        assertEquals(1, orders.get(0).getId());
        assertEquals(3, orders.size());
    }

}