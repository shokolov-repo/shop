package dao.impl.hibernate;

import dao.CommentDao;
import entity.Comment;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.LinkedList;
import java.util.List;

import static dao.impl.hibernate.HibernateUtil.getSession;

/**
 * @author Shokolov Dmitry
 */
public class HibernateCommentDao implements CommentDao {
    Logger logger = Logger.getLogger(HibernateCommentDao.class);

    @Override
    public void create(Comment comment) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        try {
            long id = (long) session.save(comment);
            transaction.commit();
        } catch (Exception e) {
            logger.error(e);
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Comment comment) {

        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.update(comment);
            transaction.commit();
        } catch (Exception e) {
            logger.error(e);
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(long userId) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        try {
            Comment comment = new Comment();
            comment.setId(userId);
            session.delete(comment);
            transaction.commit();
        } catch (Exception e) {
            logger.error(e);
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Comment> findByUserId(long userId) {
        List<Comment> comments = new LinkedList<>();
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(Comment.class).add(Restrictions.eq("userId", userId));

        try {

            comments = getList(criteria);
            transaction.commit();
        } catch (Exception e) {
            logger.error(e);
            transaction.rollback();
        } finally {
            session.close();
        }
        return comments;
    }

    @Override
    public List<Comment> findByProductId(long prodId) {
        List<Comment> comments = new LinkedList<>();
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(Comment.class).add(Restrictions.eq("productId", prodId));
        Query query = session.createQuery("from Comment c where c.productId = :prodId");
        query.setParameter("prodId", prodId);

        try {
            comments = getList(criteria);
            comments = query.list();
            transaction.commit();
        } catch (Exception e) {
            logger.error(e);
            transaction.rollback();
        } finally {
            session.close();
        }
        return comments;
    }

    private List<Comment> getList(Criteria criteria) {
        return (List<Comment>) criteria.list();
    }

}
