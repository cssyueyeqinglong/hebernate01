package com.cy.heberate.service;

import com.cy.heberate.dao.CustomerDao;
import com.cy.heberate.dao.LinkmanDao;
import com.cy.heberate.domain.Customer;
import com.cy.heberate.domain.Linkman;
import com.cy.heberate.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.List;

public class LinkmanService {

    public void addLinkman(Linkman linkman) {
        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            Customer customer = new CustomerDao().findCById(linkman.getLkm_cust_id());//先根据主键查询客户
            linkman.setCustomer(customer);
            new LinkmanDao().addLinkman(linkman);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            throw e;
        }
    }

    public List<Linkman> querylinkmList() {
        return new LinkmanDao().findAll();
    }
}
