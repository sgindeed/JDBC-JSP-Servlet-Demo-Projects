<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.bank.bean.Hospital" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Patients</title>
</head>
<body>

<h2>All Patients</h2>

<table border="1">
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Balance</th>
    <th>Update</th>
    <th>Delete</th>
</tr>

<%
List<Hospital> list = 
    (List<Hospital>) request.getAttribute("hospitalList");

if(list != null){
    for(Hospital hosp : list){
%>

<tr>
    <td><%= hosp.getHospitalId() %></td>
    <td><%= hosp.getHospitalName() %></td>
    <td><%= hosp.getBalance() %></td>

    <!-- UPDATE BUTTON -->
    <td>
	    <a href="updatePatient.jsp?id=<%= hosp.getHospitalId() %>&name=<%= hosp.getHospitalName() %>&balance=<%= hosp.getBalance() %>">
    	    Update
    	</a>
	</td>


    <!-- DELETE BUTTON -->
    <td>
        <a href="HospitalServlet?action=delete&id=<%= hosp.getHospitalId() %>"
           onclick="return confirm('Are you sure you want to delete this patient?');">
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