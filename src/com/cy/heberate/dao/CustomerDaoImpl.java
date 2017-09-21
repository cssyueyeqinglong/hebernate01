package com.cy.heberate.dao;

public class CustomerDaoImpl implements ICustomerDao {
    @Override
    public void saveCustomer() {
        System.out.print("持久化层保存数据");
    }
}
