package com.cy.heberate.dao;

import com.cy.heberate.domain.User;
import com.cy.heberate.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class UserDao {
    public User findUser(User user) {
        Session session = HibernateUtils.getCurrentSession();
        Query query = session.createQuery("from User where password=? and username=?");
        query.setParameter(0, user.getPassword());
        query.setParameter(1, user.getUsername());
        List<User> list = query.list();
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
}
