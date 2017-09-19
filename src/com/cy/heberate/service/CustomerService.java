package com.cy.heberate.service;

import com.cy.heberate.dao.CustomerDao;
import com.cy.heberate.domain.Customer;
import org.junit.Test;

import java.util.List;

public class CustomerService {
    @Test
    public void addCustomer(Customer customer) {
        new CustomerDao().addCustomer(customer);
    }

    public List<Customer> queryCustomer(String custName) {
        return new CustomerDao().queryCustomer(custName);
    }


}
