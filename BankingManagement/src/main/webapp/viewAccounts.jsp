<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.bank.bean.BankAccount" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Accounts</title>
</head>
<body>

<h2>All Accounts</h2>

<table border="1">
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Balance</th>
    <th>Update</th>
    <th>Delete</th>
</tr>

<%
List<BankAccount> list = 
    (List<BankAccount>) request.getAttribute("accountList");

if(list != null){
    for(BankAccount acc : list){
%>

<tr>
    <td><%= acc.getAccountId() %></td>
    <td><%= acc.getAccountHolderName() %></td>
    <td><%= acc.getBalance() %></td>

    <!-- UPDATE BUTTON -->
    <td>
	    <a href="updateAccount.jsp?id=<%= acc.getAccountId() %>&name=<%= acc.getAccountHolderName() %>&balance=<%= acc.getBalance() %>">
    	    Update
    	</a>
	</td>


    <!-- DELETE BUTTON -->
    <td>
        <a href="BankServlet?action=delete&id=<%= acc.getAccountId() %>"
           onclick="return confirm('Are you sure you want to delete this account?');">
           Delete
        </a>
    </td>
</tr>

<%
    }
}
%>

</table>

<br>
<a href="index.jsp">Back</a>

</body>
</html>