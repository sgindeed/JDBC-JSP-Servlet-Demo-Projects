<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Patient</title>
</head>
<body>

    <h2>Add New Patient</h2>

    <form action="HospitalServlet" method="post">
    
        <input type="hidden" name="action" value="add"/>
        
        Name: <input type="text" name="name" required/>
        
        <br><br>
        
        Balance: <input type="text" name="balance" required/>
        
        <br><br>
        
        <input type="submit" value="Add Patient"/>
        
    </form>

    <br>
    
    <a href="index.jsp">Back to Home</a>

</body>
</html>