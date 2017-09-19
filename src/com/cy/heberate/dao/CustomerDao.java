package com.cy.heberate.dao;

import com.cy.heberate.domain.Customer;
import com.cy.heberate.domain.Linkman;
import com.cy.heberate.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import java.util.List;

public class CustomerDao {
    public void addCustomer(Customer customer) {
        Session session = HibernateUtils.getHibernateSession();
        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();
        session.close();
    }


    public List<Customer> queryCustomer(String custName) {
        Session session = HibernateUtils.getHibernateSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(Customer.class);
        if (custName != null && !"".equals(custName)) {
            criteria.add(Restrictions.like("cust_name", "%" + custName + "%"));
        }
        List list = criteria.list();
        transaction.commit();
        session.close();
        return list;
    }



    public Customer findCById(Long cust_id) {
        Session session = HibernateUtils.getCurrentSession();
        return session.get(Customer.class, cust_id);
    }
}
