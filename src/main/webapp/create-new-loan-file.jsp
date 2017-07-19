<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<title>تشکیل پرونده تسهیلاتی</title>
</head>
<body>
<form action="/get-real-customer" method="post">
	<table>
		<tr>
			<td>
				شماره مشتری:
			</td>
		</tr>
		<tr>
			<td>
				<input type="text" name="customerId" class="fixed">
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="جستجو">
			</td>
		</tr>
	</table>
</form>
<table>
	<c:if test="${customer != null}">
		<tr>
			<td>نام:</td>
			<td><input type="text" name="firstName" value=${customer.firstName}><br></td>
		</tr>
		<tr>
			<td>نام خانوادگی:</td>
			<td><input type="text" name="lastName" value=${customer.lastName}></td>
		</tr>
		<tr>
			<td>نام پدر:</td>
			<td><input type="text" name="fatherName" value=${customer.fatherName}></td>
		</tr>
		<tr>
			<td>تاریخ تولد:</td>
			<td><input type="date" name="birthDate" value=${customer.birthDate}></td>
		</tr>
		<tr>
			<td>کد ملی:</td>
			<td><input type="text" name="idCode" value=${customer.idCode}></td>
		</tr>
	</c:if>
</table>
</body>
</html>
