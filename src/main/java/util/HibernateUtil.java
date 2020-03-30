package util;

import entities.*;
import org.hibernate.SessionFactory;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.Entity;
import java.util.Properties;


public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        Configuration config = new Configuration();
        config.addAnnotatedClass(Author.class);
        config.addAnnotatedClass(Book.class);
        config.addAnnotatedClass(BookExample.class);
        config.addAnnotatedClass(Usage.class);
        config.addAnnotatedClass(User.class);
        config.configure();
        Properties prop = config.getProperties();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(prop);
        ServiceRegistry registry = builder.build();

        // Create the SessionFactory using the ServiceRegistry
        sessionFactory = config.buildSessionFactory(registry);
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
