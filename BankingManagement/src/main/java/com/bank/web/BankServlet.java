package com.bank.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.bank.bean.BankAccount;
import com.bank.service.BankAccountService;

@WebServlet("/BankServlet")
public class BankServlet extends HttpServlet {

    BankAccountService service = new BankAccountService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        try {

            if ("view".equals(action)) {
                List<BankAccount> list = service.viewAccounts();
                request.setAttribute("accountList", list);
                RequestDispatcher rd = request.getRequestDispatcher("viewAccounts.jsp");
                rd.forward(request, response);
            }

            if ("delete".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                service.removeAccount(id);
                response.sendRedirect("BankServlet?action=view");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        try {

            if ("add".equals(action)) {
                String name = request.getParameter("name");
                double balance = Double.parseDouble(request.getParameter("balance"));
                service.createAccount(name, balance);
                response.sendRedirect("BankServlet?action=view");
            }

            if ("update".equals(action)) {

                String idStr = request.getParameter("id");
                String name = request.getParameter("name");
                String balStr = request.getParameter("balance");

                int id = Integer.parseInt(idStr.trim());
                double balance = Double.parseDouble(balStr.trim());

                service.editAccount(id, name, balance);
                response.sendRedirect("BankServlet?action=view");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}