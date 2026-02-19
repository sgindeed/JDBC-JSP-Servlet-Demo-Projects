<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Register Student</title>
</head>
<body style="background-color:#99e6e6; text-align:center;">
    <h2>Register New Student</h2>
    <form action="StudentServlet" method="post">
        <table align="center">
            <tr><td>ID:</td><td><input type="number" name="id" required></td></tr>
            <tr><td>Name:</td><td><input type="text" name="name" required></td></tr>
            <tr><td>Address:</td><td><input type="text" name="address" required></td></tr>
            <tr><td>Branch:</td><td><input type="text" name="branch" required></td></tr>
            <tr><td colspan="2"><input type="submit" value="Add Student"></td></tr>
        </table>
    </form>
    <br><a href="index.jsp">Back to Main Menu</a>
</body>
</html>