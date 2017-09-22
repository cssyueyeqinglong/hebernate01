package com.cy.heberate.test;

import com.cy.heberate.domain.Customer;
import com.cy.heberate.domain.Linkman;
import com.cy.heberate.service.CustomerServiceImpl;
import com.cy.heberate.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestHibernate {

    @Resource(name = "customerServiceImpl")
    CustomerServiceImpl csi;

    @Test
    public void tests2j(){
        csi.addCustomer();
    }

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

    /**
     * 一对多测试,双向保存
     */
    @Test
    public void testone_to_more() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = new Customer();
        customer.setCust_name("第一");

        Linkman linkman1 = new Linkman();
        linkman1.setLkm_name("熊二");
        Linkman linkman2 = new Linkman();
        linkman2.setLkm_name("熊大");
        //双向关联
        customer.getLinkmens().add(linkman1);
        customer.getLinkmens().add(linkman2);
        linkman1.setCustomer(customer);
        linkman2.setCustomer(customer);
        session.save(customer);
        session.save(linkman1);
        session.save(linkman2);
        transaction.commit();
//        session.close();
    }

    /**
     * 一对多测试,单向保存,级联保存
     */
    @Test
    public void testmore_to_one() {
        Session session = HibernateUtils.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = new Customer();
        customer.setCust_name("第一");

        Linkman linkman1 = new Linkman();
        linkman1.setLkm_name("熊二");
        Linkman linkman2 = new Linkman();
        linkman2.setLkm_name("熊大");
        //双向关联
        customer.getLinkmens().add(linkman1);
        customer.getLinkmens().add(linkman2);
        linkman1.setCustomer(customer);
        linkman2.setCustomer(customer);
        session.save(customer);
        transaction.commit();
    }
}
