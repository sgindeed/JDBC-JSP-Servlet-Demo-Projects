<%@ page import="java.util.*, com.student.model.Student" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student List</title>
</head>
<body style="background-color:#99e6e6; text-align:center;">
    <h2>All Registered Students</h2>
    <table border="1" align="center" style="background-color:white;">
        <tr style="background-color:#f2f2f2;">
            <th>STUD_ID</th><th>NAME</th><th>ADDRESS</th><th>BRANCH</th>
        </tr>
        <% 
            ArrayList<Student> list = (ArrayList<Student>)request.getAttribute("studentList");
            if(list != null && !list.isEmpty()) {
                for(Student s : list) { 
        %>
            <tr>
                <td><%= s.getId() %></td>
                <td><%= s.getName() %></td>
                <td><%= s.getAddress() %></td>
                <td><%= s.getBranch() %></td>
            </tr>
        <% 
                } 
            } else {
        %>
            <tr><td colspan="4">No students found in the database.</td></tr>
        <% } %>
    </table>
    <br><a href="index.jsp">Back to Main Menu</a>
</body>
</html>