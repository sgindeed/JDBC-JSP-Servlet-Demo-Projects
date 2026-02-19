<%@ page import="com.student.model.Student" %>
<!DOCTYPE html>
<html>
<body>
    <h2>Update Student Details</h2>
    <% Student s = (Student)request.getAttribute("student"); %>
    <form action="StudentServlet" method="post">
        <input type="hidden" name="action" value="update">
        ID (Read-only): <input type="number" name="id" value="<%= s.getId() %>" readonly><br><br>
        Name: <input type="text" name="name" value="<%= s.getName() %>" required><br><br>
        Address: <input type="text" name="address" value="<%= s.getAddress() %>" required><br><br>
        Branch: <input type="text" name="branch" value="<%= s.getBranch() %>" required><br><br>
        <input type="submit" value="Update Student">
    </form>
    <br><a href="index.jsp">Back to Main Menu</a>
</body>
</html>