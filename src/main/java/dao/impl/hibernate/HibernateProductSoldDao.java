package dao.impl.hibernate;

import dao.ProductSoldDao;
import entity.ProductSold;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.LinkedList;
import java.util.List;

import static dao.impl.hibernate.HibernateUtil.getSession;

/**
 * @author Shokolov Dmitry
 */
public class HibernateProductSoldDao implements ProductSoldDao {
    Logger logger = Logger.getLogger(HibernateProductSoldDao.class);

    @Override
    public void create(ProductSold productSold) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        try {
            long id = (long) session.save(productSold);
            transaction.commit();
        } catch (Exception e) {
            logger.error(e);
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(ProductSold productSold) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.update(productSold);
            transaction.commit();
        } catch (Exception e) {
            logger.error(e);
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void deleteAll(long orderId) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        ProductSold productSold=new ProductSold();

        try {

//            productSold.getOrder().setId(orderId);
            session.delete(productSold);
            transaction.commit();
        } catch (Exception e) {
            logger.error(e);
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public List<ProductSold> findAll(long orderId) {
        List<ProductSold> productsSold = new LinkedList<>();
        Session session = getSession();
//        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(ProductSold.class).add(Restrictions.eq("order.id", orderId));

        try {

            productsSold = getList(criteria);
//            transaction.commit();
        } catch (Exception e) {
            logger.error(e);
//            transaction.rollback();
        } finally {
            session.close();
        }
        return productsSold;
    }

    @Override
    public List<ProductSold> findAll() {
        List<ProductSold> productsSold = new LinkedList<>();
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(ProductSold.class);

        try {

            productsSold = getList(criteria);
            transaction.commit();
        } catch (Exception e) {
            logger.error(e);
            transaction.rollback();
        } finally {
            session.close();
        }
        return productsSold;
    }
    private List<ProductSold> getList(Criteria criteria) {
        return (List<ProductSold>) criteria.list();
    }


}
