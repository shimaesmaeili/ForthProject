<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<title>مشتری حقوقی جدید</title>

	<script>
		function Validate() {
			var frm = document.legalForm;
			if (frm.name.value == "") {
				alert("وارد کردن نام الزامی است!");
				return false;
			} else if (frm.registrationDate.value == "") {
				alert("وارد کردن تاریخ ثبت الزامی است!");
				return false;
			} else if (frm.code.value == "") {
				alert("وارد کردن کد اقتصادی الزامی است!");
				return false;
			}
			return true;
		}
		function Clicked() {
			if (Validate()) {
				document.legalForm.submit();
			}
		}
	</script>
</head>
<body>

<h3 class="center">اطلاعات مورد نیاز: </h3>

<div>
	<form action="/new-legal-customer" method="get" name="legalForm">
		<table class="center">
			<tr>
				<td>نام شرکت:</td>
				<td><input type="text" name="name" class="fixed"><br></td>
			</tr>
			<tr>
				<td>تاریخ ثبت:</td>
				<td><input type="date" name="registrationDate" class="fixed"></td>
			</tr>
			<tr>
				<td>کد اقتصادی:</td>
				<td><input type="text" name="eCode" class="fixed"></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="submit" value="ثبت">
				</td>
			</tr>
		</table>
	</form>
</div>
<br><br><br><br>
<a href="/customers.jsp" class="link">صفحه مشتریان</a>
</body>
</html>
