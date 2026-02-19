package com.student.web;

import com.student.model.Student;
import com.student.util.DBConfig;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
    @Override
    public void init() { DBConfig.initializeDB(); }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String branch = request.getParameter("branch");

        try (Connection conn = DBConfig.getConnection()) {
            if ("update".equals(action)) {
                // UPDATE SQL
                PreparedStatement ps = conn.prepareStatement("UPDATE STUDENT SET NAME=?, ADDRESS=?, BRANCH=? WHERE STUD_ID=?");
                ps.setString(1, name);
                ps.setString(2, address);
                ps.setString(3, branch);
                ps.setInt(4, id);
                ps.executeUpdate();
            } else {
                // INSERT SQL
                PreparedStatement ps = conn.prepareStatement("INSERT INTO STUDENT VALUES (?, ?, ?, ?)");
                ps.setInt(1, id);
                ps.setString(2, name);
                ps.setString(3, address);
                ps.setString(4, branch);
                ps.executeUpdate();
            }
            response.sendRedirect("StudentServlet?action=list");
        } catch (Exception e) { e.printStackTrace(); }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        ArrayList<Student> list = new ArrayList<>();
        String targetJSP = "/listStudent.jsp";

        try (Connection conn = DBConfig.getConnection()) {
            if ("list".equals(action)) {
                ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM STUDENT");
                while (rs.next()) list.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            } 
            else if ("search".equals(action)) {
                String name = request.getParameter("name").toLowerCase();
                PreparedStatement ps = conn.prepareStatement("SELECT * FROM STUDENT WHERE LOWER(NAME) = ?");
                ps.setString(1, name);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) list.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
                targetJSP = "/searchStudent.jsp";
            }
            else if ("delete".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                PreparedStatement ps = conn.prepareStatement("DELETE FROM STUDENT WHERE STUD_ID = ?");
                ps.setInt(1, id);
                ps.executeUpdate();
                request.setAttribute("message", "Student deleted successfully.");
                targetJSP = "/searchStudent.jsp";
            }
            // NEW: Prepare the Update Page
            else if ("edit".equals(action)) {
                int id = Integer.parseInt(request.getParameter("id"));
                PreparedStatement ps = conn.prepareStatement("SELECT * FROM STUDENT WHERE STUD_ID = ?");
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    Student s = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                    request.setAttribute("student", s);
                }
                targetJSP = "/updateStudent.jsp";
            }
            
            request.setAttribute("studentList", list);
            request.getRequestDispatcher(targetJSP).forward(request, response);
        } catch (Exception e) { e.printStackTrace(); }
    }
}