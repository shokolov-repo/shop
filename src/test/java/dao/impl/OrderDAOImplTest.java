package dao.impl;

import dao.OrderDAO;
import entity.Order;
import org.junit.Test;

import java.sql.Date;
import java.util.List;

/**
 * Created by dmity on 16.10.15.
 */
public class OrderDAOImplTest extends BeforeTestShop {
    OrderDAO orderDAO = new OrderDAOImpl();

    @Test
    public void testCreate() throws Exception {
//        given
        Order testOrder = new Order();
        testOrder.setId(4);
        testOrder.setCustomerId(1);
        testOrder.setSellerId(1);
        testOrder.setDateOrder(Date.valueOf("2010-03-05"));
        testOrder.setStatus("check");

//        when
        orderDAO.create(testOrder);
        Order order = orderDAO.findById(4);

//        then
        assertEquals(1, order.getCustomerId());
        assertEquals(1, order.getSellerId());
        assertEquals(Date.valueOf("2010-03-05"), order.getDateOrder());
        assertEquals("check", order.getStatus());
    }

    @Test
    public void testUpdate() throws Exception {
//        given
        Order testOrder = orderDAO.findById(1);
        testOrder.setStatus("update");

//        when
        orderDAO.update(testOrder);
        Order order = orderDAO.findById(1);

//        then
        assertEquals("update", order.getStatus());
    }

    @Test
    public void testDelete() throws Exception {
//        when
        orderDAO.delete(3);
        Order order = orderDAO.findById(3);

//        then
        assertNull(order);
    }

    @Test
    public void testFindById() throws Exception {
//        when
        Order order = orderDAO.findById(1);

//        then
        assertEquals("sold1", order.getStatus(), "sold1");
        assertEquals(Date.valueOf("2015-02-12"), order.getDateOrder());
        assertEquals(1, order.getCustomerId());
    }

    @Test
    public void testFindByDate() throws Exception {
//        when
        Order order = orderDAO.findByDate(Date.valueOf("2015-02-12"));

//        then
        assertEquals("sold1", order.getStatus());
        assertEquals(1, order.getId());
        assertEquals(1, order.getCustomerId());
    }

    @Test
    public void testFindByStatus() throws Exception {
//        when
        List<Order> orders = orderDAO.findAllByStatus("sold1");

//        then
        assertEquals(1, orders.get(0).getId());
        assertEquals(1, orders.size());
    }
}