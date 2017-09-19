package com.cy.heberate.serverlet;

import com.cy.heberate.domain.Customer;
import com.cy.heberate.service.CustomerService;

import java.io.IOException;

public class CustomerServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        try {
            Customer customer=new Customer();
            customer.setCust_name(request.getParameter("cust_name"));
            customer.setCust_level(request.getParameter("cust_level"));
            customer.setCust_source(request.getParameter("cust_source"));
            customer.setCust_linkman(request.getParameter("cust_linkman"));
            customer.setCust_phone(request.getParameter("cust_phone"));
            customer.setCust_mobile(request.getParameter("cust_mobile"));
//            BeanUtils.populate(customer,map);
            new CustomerService().addCustomer(customer);
            response.sendRedirect(request.getContextPath()+"/customer_list");
            System.out.print("保存数据成功了");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}
