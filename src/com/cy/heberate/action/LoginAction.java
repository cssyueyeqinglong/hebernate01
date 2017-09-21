package com.cy.heberate.action;

import com.cy.heberate.domain.User;
import com.cy.heberate.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.logging.Logger;

public class LoginAction extends ActionSupport implements ModelDriven<User> {

    private User user = new User();

    @Override
    public User getModel() {
        return user;
    }

    public String login() {
        System.out.print(user.toString());
        User cu = new UserService().login(user);
        if (cu == null) {//登录失败
            return LOGIN;
        }
        ActionContext.getContext().getSession().put("user", cu);
        return SUCCESS;
    }

}
