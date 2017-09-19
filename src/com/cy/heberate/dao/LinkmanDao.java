package com.cy.heberate.dao;

import com.cy.heberate.domain.Customer;
import com.cy.heberate.domain.Linkman;
import com.cy.heberate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class LinkmanDao {
    public void addLinkman(Linkman linkman) {
        Session session = HibernateUtils.getCurrentSession();
        session.save(linkman);
    }

    public List<Linkman> findAll() {
        List<Linkman> lis = null;
        Session session = HibernateUtils.getHibernateSession();
        Transaction transaction = session.beginTransaction();
        lis = session.createQuery("from Linkman ").list();
        transaction.commit();
        return lis;
    }
}
