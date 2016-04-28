package dao.impl.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * @author Shokolov Dmitry
 */
public class HibernateUtil {

    private static SessionFactory factory = new Configuration()
            .buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());

    public static Session getSession() {
        return factory.openSession();
    }

    public static SessionFactory getFactory() {
        return factory;
    }
 }
