package dao.impl.hibernate;

import dao.UserDao;
import entity.User;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

import static dao.impl.hibernate.HibernateUtil.getSession;

/**
 * @author Shokolov Dmitry
 */

public class HibernateUserDao implements UserDao {
    private static Logger logger = Logger.getLogger(HibernateUserDao.class);

    @Override
    public void create(User user) {

        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        try {
            long id = (long) session.save(user);
            transaction.commit();
        } catch (Exception e) {
            logger.error(e);
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(User user) {

        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.update(user);
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
            User user = new User();
            user.setId(id);
            session.delete(user);
            transaction.commit();
        } catch (Exception e) {
            logger.error(e);
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public User findById(long id) {

        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(User.class).add(Restrictions.idEq(id));
        User user = null;

        try {

            user = (User) criteria.uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            logger.error(e);
            transaction.rollback();
        } finally {
            session.close();
        }
        return user;
    }

    @Override
    public User findByEmail(String email) {

        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(User.class).add(Restrictions.eq("email", email));
        User user = null;

        try {

            user = (User) criteria.uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            logger.error(e);
            transaction.rollback();
        } finally {
            session.close();
        }
        return user;
    }

    @Override
    public List<User> findByRole(String role) {

        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(User.class).add(Restrictions.eq("role", role));
        List<User> users = null;

        try {

            users = getList(criteria);
            transaction.commit();
        } catch (Exception e) {
            logger.error(e);
            transaction.rollback();
        } finally {
            session.close();
        }
        return users;
    }

    @Override
    public List<User> findAll() {

        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(User.class);
        List<User> users = null;

        try {

            users = getList(criteria);
            transaction.commit();
        } catch (Exception e) {
            logger.error(e);
            transaction.rollback();
        } finally {
            session.close();
        }
        return users;
    }

    private List<User> getList(Criteria criteria) {
        return (List<User>) criteria.list();
    }

}
