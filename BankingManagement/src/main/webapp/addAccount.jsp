<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Bank Account</title>
</head>
<body>

    <h2>Add New Bank Account</h2>

    <form action="BankServlet" method="post">
    
        <input type="hidden" name="action" value="add"/>
        
        Name: <input type="text" name="name" required/>
        
        <br><br>
        
        Balance: <input type="text" name="balance" required/>
        
        <br><br>
        
        <input type="submit" value="Add Account"/>
        
    </form>

    <br>
    
    <a href="index.jsp">Back to Home</a>

</body>
</html>