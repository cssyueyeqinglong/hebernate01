package com.cy.heberate.service;

import com.cy.heberate.dao.CustomerDaoImpl;

public class CustomerServiceImpl implements ICustomerService {
    public void setCustomerdao(CustomerDaoImpl customerdao) {
        this.customerdao = customerdao;
    }

    private CustomerDaoImpl customerdao;

    @Override
    public void addCustomer() {
        System.out.print("业务层保存数据");
        customerdao.saveCustomer();
    }
}
