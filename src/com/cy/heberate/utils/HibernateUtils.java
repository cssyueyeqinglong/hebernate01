package com.cy.heberate.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private static final Configuration CONFIG;
    private static final SessionFactory FACTORY;

    static {
        CONFIG = new Configuration().configure();
        FACTORY = CONFIG.buildSessionFactory();
    }

    public static Session getHibernateSession() {
        return FACTORY.openSession();//从threadlocal中获取到的session
    }

    public static Session getCurrentSession() {
        return FACTORY.getCurrentSession();//从threadlocal中获取到的session
    }
}
