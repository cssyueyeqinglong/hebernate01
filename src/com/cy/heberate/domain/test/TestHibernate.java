package com.cy.heberate.domain.test;

import com.cy.heberate.domain.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class TestHibernate {
    @Test
    public void testsave() {
        Configuration conf = new Configuration().configure();
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();
        Customer customer = new Customer();
        customer.setCust_name("测试");
        customer.setCust_level("2");
        customer.setCust_phone("13242429815");
        session.save(customer);
        transaction.commit();

        session.close();
        factory.close();
    }
}
