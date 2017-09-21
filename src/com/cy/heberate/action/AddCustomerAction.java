package com.cy.heberate.action;

import com.cy.heberate.domain.Customer;
import com.cy.heberate.service.CustomerService;
import com.cy.heberate.service.CustomerServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class AddCustomerAction extends ActionSupport implements ModelDriven<Customer> {


    private Customer customer = new Customer();

    @Override
    public Customer getModel() {
        return customer;
    }

    public String addCustomerTest() {
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext());
        CustomerServiceImpl csi = (CustomerServiceImpl) context.getBean("customerservice");
        csi.addCustomer();
        return NONE;
    }

    public String addCustomer() {
        try {
            new CustomerService().addCustomer(customer);
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return LOGIN;
        }

    }


}
