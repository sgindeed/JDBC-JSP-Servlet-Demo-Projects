<%@ page import="java.util.*, com.student.model.Student" %>
<!DOCTYPE html>
<html>
<head>
    <title>Search/Delete Student</title>
</head>
<body>
    <h2>Student Management System</h2>
    
    <form action="StudentServlet" method="get">
        <input type="hidden" name="action" value="search">
        Student Name: <input type="text" name="name">
        <input type="submit" value="Search">
    </form>

    <% 
        String msg = (String)request.getAttribute("message");
        ArrayList<Student> list = (ArrayList<Student>)request.getAttribute("studentList");
        String action = request.getParameter("action");

        if (msg != null) { %>
            <p><%= msg %></p>
    <%  } else if ("search".equals(action) && (list == null || list.isEmpty())) { %>
            <p>Student not found!!!</p>
    <%  } %>

    <% if (list != null && !list.isEmpty()) { %>
        <table border="1">
            <tr>
                <th>STUD_ID</th>
                <th>NAME</th>
                <th>ADDRESS</th>
                <th>BRANCH</th>
                <th>ACTION</th>
            </tr>
            <% for(Student s : list) { %>
            <tr>
                <td><%= s.getId() %></td>
                <td><%= s.getName() %></td>
                <td><%= s.getAddress() %></td>
                <td><%= s.getBranch() %></td>
                <td>
                    <a href="StudentServlet?action=delete&id=<%= s.getId() %>" 
                       onclick="return confirm('Are you sure?')">Delete</a>
                </td>
            </tr>
            <% } %>
        </table>
    <% } %>

    <br>
    <a href="index.jsp">Back to Main Menu</a>
</body>
</html>