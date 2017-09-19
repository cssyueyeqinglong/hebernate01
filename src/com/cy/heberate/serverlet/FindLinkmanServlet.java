package com.cy.heberate.serverlet;

import com.cy.heberate.domain.Customer;
import com.cy.heberate.domain.Linkman;
import com.cy.heberate.service.CustomerService;
import com.cy.heberate.service.LinkmanService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FindLinkmanServlet")
public class FindLinkmanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //查询所有 的客户
        List<Linkman> customers = new LinkmanService().querylinkmList();
        request.setAttribute("list", customers);
        request.getRequestDispatcher( "/jsp/linkman/list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
