<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<title>تسهیلات</title>
</head>
<body>
<h3 class="center">اطلاعات مورد نیاز: </h3>
<div>
	<form action="/get-new-Loan-info" method="post" name="realForm">
		<table>
			<tr>
				<td>نام نوع تسهیلات:</td>
				<td><input type="text" name="loanName" class="fixed"><br></td>
			</tr>
			<tr>
				<td>نرخ سود (درصد):</td>
				<td><input type="number" name="interestRate" class="fixed"></td>
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
</body>
</html>
