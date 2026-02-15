<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String id = request.getParameter("id");
String name = request.getParameter("name");
String balance = request.getParameter("balance");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Account</title>
</head>
<body>

<h2>Update Account</h2>

<form action="BankServlet" method="post">

    <input type="hidden" name="action" value="update"/>
    <input type="hidden" name="id" value="<%= id %>"/>

    Name:
    <input type="text" name="name" value="<%= name %>" required/>
    
    <br><br>

    Balance:
    <input type="text" name="balance" value="<%= balance %>" required/>
    
    <br><br>

    <input type="submit" value="Update Account"/>

</form>

<br>
<a href="BankServlet?action=view">Back</a>

</body>
</html>
