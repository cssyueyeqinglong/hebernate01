package com.cy.heberate.interceptor;

import com.cy.heberate.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import static com.opensymphony.xwork2.Action.LOGIN;

/**
 * 自定义拦截器。判断是否登录
 */
public class LoginInterceptor extends MethodFilterInterceptor {

    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        User user = (User) ActionContext.getContext().getSession().get("user");
        if (user == null) {//没有登录，就先跳转到登录页面
            return LOGIN;
        }
        return actionInvocation.invoke();
    }
}
