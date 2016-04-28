package dao.impl.hibernate;

import dao.ProductDao;
import entity.Product;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

import static dao.impl.hibernate.HibernateUtil.getSession;

/**
 * @author Shokolov Dmitry
 */
public class HibernateProductDao implements ProductDao {
    Logger logger = Logger.getLogger(HibernateProductDao.class);

    @Override
    public void create(Product product) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        try {
            long id = (long) session.save(product);
            transaction.commit();
        } catch (Exception e) {
            logger.error(e);
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Product product) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.update(product);
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
            Product product = new Product();
            product.setId(id);
            session.delete(product);
            transaction.commit();
        } catch (Exception e) {
            logger.error(e);
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public Product findById(long id) {
        Product product = new Product();

        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(Product.class).add(Restrictions.idEq(id));


        try {
            product = (Product) criteria.uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            logger.error(e);
            transaction.rollback();
        } finally {
            session.close();
        }
        return product;
    }

    @Override
    public Product findByTitle(String title) {
        Product product = new Product();

        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(Product.class).add(Restrictions.eq("title", title));

        try {
            product = (Product) criteria.uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            logger.error(e);
            transaction.rollback();
        } finally {
            session.close();
        }
        return product;
    }

    @Override
    public Product findByPrice(double price) {
        Product product = new Product();

        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(Product.class).add(Restrictions.eq("price", price));

        try {
            product = (Product) criteria.uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            logger.error(e);
            transaction.rollback();
        } finally {
            session.close();
        }
        return product;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();

        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(Product.class);

        try {
            products = criteria.list();
            transaction.commit();
        } catch (Exception e) {
            logger.error(e);
            transaction.rollback();
        } finally {
            session.close();
        }
        return products;
    }
}
