<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<script>
		function Validate() {
			var frm = document.loanForm;
			if (frm.loanName.value == "") {
				alert("وارد کردن نام تسهیلات الزامی است!");
				return false;
			} else if (frm.interestRate.value == "") {
				alert("وارد کردن نرخ سود الزامی است!");
				return false;
			}
			return true;
		}

		function Clicked() {
			if (Validate()) {
				document.loanForm.submit();
			}
		}
	</script>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<title>تسهیلات</title>
</head>
<body>
<h3 class="center">اطلاعات مورد نیاز: </h3>
<div>
	<form action="/get-new-Loan-info" method="post" name="loanForm">
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
					<input type="button" value="ثبت" onclick="Clicked()">
				</td>
			</tr>
		</table>
	</form>

	<br><br><br><br>
	<a href="/index.jsp" class="link">صفحه اصلی</a>
</div>
</body>
</html>
