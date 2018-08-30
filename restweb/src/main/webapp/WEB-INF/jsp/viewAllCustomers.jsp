<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Account</title>
<style>body {
	background-color: #7fffda;
}</style>
</head>
<body>
<div>
	<jsp:include page="header.jsp"></jsp:include>
</div>
<div align="center">
<h1>Customer List</h1>

<table>
<tr>
	<th>Customer ID</th>
	<th>Customer Name</th>
	<th>Contact Number</th>
	<th>Email</th>
	<th>D.O.B</th>
	<th>Photo</th>
</tr>

<tr>
	<td>${customer.customerId}</td>
	<td>${customer.customerName}</td>
	<td>${customer.contactNumber}</td>
	<td>${customer.emailId}</td>
	<td>${customer.dateOfBirth}</td>
	<td>${customer.url}</td>
	</tr>
</table>
</div>
<div>
	<jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
</html>