<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add customer</title>
</head>
<body>
<div>
	<jsp:include page="header.jsp"></jsp:include>
</div>
<div align="center">
<h3>Enter Customer Details</h3>
<form id="customerDetails" action="/customer/add" method="post">
Customer ID: <input type="number" name="customerId"><br>
Customer Name:           <input type="text" name="customerName"><br>
Contact Number: <input type="tel" name="contactNumber" min=10 max=10><br>
Email-id:       <input type="email" name="emailId"><br>
Date of Birth:	<input type="date" name="dateOfBirth" min=now><br>
Photo: <input type="text" name="url"><br>
<input type="submit" value="Created the customer"><input type="reset" value="Clear">
</form>
</div>
<div>
	<jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
</html>





