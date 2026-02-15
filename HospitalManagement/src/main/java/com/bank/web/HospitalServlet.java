package com.bank.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.bank.bean.Hospital;
import com.bank.service.HospitalService;

@WebServlet("/HospitalServlet")
public class HospitalServlet extends HttpServlet {

    HospitalService service = new HospitalService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        try {

            if ("view".equals(action)) {
                List<Hospital> list = service.viewHospitals();
                request.setAttribute("hospitalList", list);
                RequestDispatcher rd = request.getRequestDispatcher("viewHospitals.jsp");
                rd.forward(request, response);
            }

            if ("delete".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                service.removeHospital(id);
                response.sendRedirect("HospitalServlet?action=view");
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
                service.createHospital(name, balance);
                response.sendRedirect("HospitalServlet?action=view");
            }

            if ("update".equals(action)) {

                String idStr = request.getParameter("id");
                String name = request.getParameter("name");
                String balStr = request.getParameter("balance");

                int id = Integer.parseInt(idStr.trim());
                double balance = Double.parseDouble(balStr.trim());

                service.editHospital(id, name, balance);
                response.sendRedirect("HospitalServlet?action=view");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}