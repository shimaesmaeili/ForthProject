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
			<td>
				<input type="text" name="customerId" class="fixed">
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<input type="submit" value="جستجو">
			</td>
		</tr>
	</table>
</form>
<br><br><br><br>
<c:if test="${customer != null}">
	<table>
		<tr>
			<td>نام:</td>
			<td><input type="text" name="firstName" value=${customer.firstName} readonly><br></td>
		</tr>
		<tr>
			<td>نام خانوادگی:</td>
			<td><input type="text" name="lastName" value=${customer.lastName} readonly></td>
		</tr>
	</table>
	<br><br><br><br>
	<div class="center">
		<form action="/check-verification" method="post">
			<table>
				<tr>
					<td>نوع تسهیلات:</td>
					<td>
						<select name="loanId" class="fixed">
							<option selected disabled hidden style='display: none' value=''></option>
							<c:forEach items="${loans}" var="loan">
								<option name="loanId" value="${loan.id}">"${loan.name}"</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>مدت قرارداد:</td>
					<td>
						<input type="text" name="duration">
					</td>
				</tr>
				<tr>
					<td>مبلغ قرارداد:</td>
					<td>
						<input type="text" name="amount">
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="hidden" name="customerId" value="${customer.id}">
						<input type="submit" value="بررسی">
					</td>
				</tr>
		</form>
	</div>
</c:if>
</body>
</html>
