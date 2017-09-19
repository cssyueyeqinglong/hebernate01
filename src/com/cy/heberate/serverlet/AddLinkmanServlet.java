package com.cy.heberate.serverlet;

import com.cy.heberate.domain.Linkman;
import com.cy.heberate.service.CustomerService;
import com.cy.heberate.service.LinkmanService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "AddLinkmanServlet")
public class AddLinkmanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String foreignId = request.getParameter("lkm_cust_id");//外键id
        String lkm_name = request.getParameter("lkm_name");//外键id
        String lkm_gender = request.getParameter("lkm_gender");//外键id
        String lkm_phone = request.getParameter("lkm_phone");//外键id
        String lkm_mobile = request.getParameter("lkm_mobile");//外键id
        System.out.print("foreignId:" + foreignId +
                ",lkm_name" + lkm_name +
                ",lkm_gender" + lkm_gender +
                ",lkm_phone" + lkm_phone +
                ",lkm_mobile" + lkm_mobile);
        Linkman linkman = new Linkman();
        try {
            BeanUtils.populate(linkman, request.getParameterMap());
            new LinkmanService().addLinkman(linkman);
            response.sendRedirect(request.getContextPath()+"/jsp/success.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
