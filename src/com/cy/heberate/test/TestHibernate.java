package com.cy.heberate.test;

import com.cy.heberate.domain.Customer;
import com.cy.heberate.utils.HibernateUtils;
import com.mysql.jdbc.log.Log;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.List;
import java.util.logging.Logger;

public class TestHibernate {
    @Test
    public void testsave() {
        Session session = HibernateUtils.getHibernateSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = new Customer();
        customer.setCust_name("测试");
        customer.setCust_level("2");
        customer.setCust_phone("13242429815");
        session.save(customer);
        transaction.commit();
        session.close();
    }

    @Test
    public void testlist() {
        Session session = HibernateUtils.getHibernateSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("from Customer");
        List<Customer> list = query.list();
        for (Customer c :
                list) {
            System.out.print(c.toString());
        }
        transaction.commit();
        session.close();
    }
}
