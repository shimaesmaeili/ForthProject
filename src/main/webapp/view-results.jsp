<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<title>نتایج جستجو</title>
</head>
<body>
<h3 class="center">نتایج جستجو:</h3>
<table border=1 cellpadding=5>
	<tr>
		<th>
			شماره مشتری
		</th>
		<c:if test="${customerType=='real'}">
			<th>
				نام
			</th>
			<th>
				نام خانوادگی
			</th>
			<th>
				نام پدر
			</th>
			<th>
				کد ملی
			</th>
			<th>
				تاریخ تولد
			</th>
		</c:if>
		<c:if test="${customerType=='legal'}">
			<th>
				نام شرکت
			</th>
			<th>
				کد اقتصادی
			</th>
			<th>
				تاریخ ثبت
			</th>
		</c:if>
	</tr>
	<c:forEach var="customer" items="${customers}">
		<tr>
			<td>
				<c:out value="${customer.id}"/>
			</td>
			<c:if test="${customerType=='real'}">
				<td><c:out value="${customer.firstName}"/></td>
				<td><c:out value="${customer.lastName}"/></td>
				<td><c:out value="${customer.fatherName}"/></td>
				<td><c:out value="${customer.idCode}"/></td>
				<td><c:out value="${customer.birthDate}"/></td>
			</c:if>
			<c:if test="${customerType=='legal'}">
				<td><c:out value="${customer.name}"/></td>
				<td><c:out value="${customer.eCode}"/></td>
				<td><c:out value="${customer.registrationDate}"/></td>
			</c:if>
			<td>
				<c:url var="editUrl" value="/showCustomer">
					<c:param name="customerType" value="${customerType}"/>
					<c:param name="id" value="${customer.id}"/>
				</c:url>
				<a href="${editUrl}">ویرایش</a>
			</td>
			<td>
				<c:url var="removeUrl" value="/removeCustomer">
					<c:param name="customerType" value="${customerType}"/>
					<c:param name="id" value="${customer.id}"/>
				</c:url>
				<a href="${removeUrl}">حذف</a>
			</td>
		</tr>
	</c:forEach>
</table>
<br><br><br><br>
<a href="/search.jsp" class="link">بازگشت به صفحه جستجو</a>
<br>
<a href="/customers.jsp" class="link">صفحه اصلی</a>
</body>
</html>