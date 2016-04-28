package dao.impl.hibernate;

import dao.OrderDao;
import entity.Order;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static dao.impl.hibernate.HibernateUtil.getSession;

/**
 * @author Shokolov Dmitry
 */
public class HibernateOrderDao implements OrderDao {
    private Logger logger = Logger.getLogger(HibernateOrderDao.class);

    @Override
    public void create(Order order) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        try {
            long id = (long) session.save(order);
            transaction.commit();
        } catch (Exception e) {
            logger.error(e);
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Order order) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.update(order);
            transaction.commit();
        } catch (Exception e) {
            logger.error(e);
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(long id) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        try {
            Order order = new Order();
            order.setId(id);
            session.delete(order);
            transaction.commit();
        } catch (Exception e) {
            logger.error(e);
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public Order findById(long id) {
        Order order = new Order();
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(Order.class).add(Restrictions.idEq(id));

        try {

            order = (Order) criteria.uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            logger.error(e);
            transaction.rollback();
        } finally {
            session.close();
        }
        return order;
    }

    @Override
    public Order findByDate(Date date) {
        Order order = new Order();
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(Order.class).add(Restrictions.eq("date", date));


        try {

            order = (Order) criteria.uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            logger.error(e);
            transaction.rollback();
        } finally {
            session.close();
        }
        return order;
    }

    @Override
    public Set<Order> findAllByUserId(long userId) {
        Set<Order> orders = new HashSet<>();
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(Order.class).add(Restrictions.eq("userId", userId));

        try {

            orders.addAll(criteria.list());
            transaction.commit();
        } catch (Exception e) {
            logger.error(e);
            transaction.rollback();
        } finally {
            session.close();
        }
        return orders;
    }

    @Override
    public Set<Order> findAllByStatus(String status) {
        Set<Order> orders = new HashSet<>();
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(Order.class).add(Restrictions.eq("status", status));

        try {

            orders.addAll(criteria.list());
            transaction.commit();
        } catch (Exception e) {
            logger.error(e);
            transaction.rollback();
        } finally {
            session.close();
        }
        return orders;
    }

    @Override
    public Set<Order> findAll() {
        Set<Order> orders = new HashSet<>();
        Session session = getSession();
//        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(Order.class);

        try {
            orders.addAll(criteria.list());
//            transaction.commit();
        } catch (Exception e) {
            logger.error(e);
//            transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
        return orders;
    }
 }
