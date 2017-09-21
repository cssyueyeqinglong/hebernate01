package com.cy.heberate.service;

import com.cy.heberate.dao.UserDao;
import com.cy.heberate.domain.User;
import com.cy.heberate.utils.HibernateUtils;
import org.hibernate.Session;

public class UserService {
    public User login(User user) {
        Session session = HibernateUtils.getCurrentSession();
        session.beginTransaction();
        return new UserDao().findUser(user);
    }
}
