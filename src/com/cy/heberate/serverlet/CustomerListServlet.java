package com.cy.heberate.serverlet;

import com.cy.heberate.domain.Customer;
import com.cy.heberate.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerListServlet")
public class CustomerListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String custName=request.getParameter("custName");
        System.out.print("csu:"+custName);
        List<Customer> list = new CustomerService().queryCustomer(custName);
        request.setAttribute("list", list);
        request.getRequestDispatcher("/jsp/customer/list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
