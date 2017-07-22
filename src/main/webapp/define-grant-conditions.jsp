<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<script>
		var nextId = 0;

		function addInput() {
			nextId++;
			var newRow = document.createElement('tr');
			var newCol1 = document.createElement('td');
			newCol1.innerHTML = "<input type='text' name='name' id='conditions[]' class='type2'>";
			var newCol2 = document.createElement('td');
			newCol2.innerHTML = "<input type='text' name='minDuration' class='type2'>";
			var newCol3 = document.createElement('td');
			newCol3.innerHTML = "<input type='text' name='maxDuration' class='type2'>";
			var newCol4 = document.createElement('td');
			newCol4.innerHTML = "<input type='text' name='minAmount' class='type2'>";
			var newCol5 = document.createElement('td');
			newCol5.innerHTML = "<input type='text' name='maxAmount' class='type2'>";
			newRow.appendChild(newCol1);
			newRow.appendChild(newCol2);
			newRow.appendChild(newCol3);
			newRow.appendChild(newCol4);
			newRow.appendChild(newCol5);
			document.getElementById('tableForm').appendChild(newRow);
		}

		function Validate() {
			var frm = document.grantConditionForm;
			var inputs = document.getElementById('tableForm').getElementsByTagName('input');
			for (i = 0; i < inputs.length; i++)
				if (inputs[i].value == "") {
					alert("پر کردن تمام فیلدها الزامی است!");
					return false;
				}

			return true;
		}

		function saveClicked() {
			if (Validate()) {
				document.grantConditionForm.submit();
			}
		}

	</script>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<title>تعریف شروط اعطا</title>
</head>
<body onLoad="addInput();">
<br><br><br><br>
<p>

<h3 class="center">شروط اعطای تسهیلات <%=request.getAttribute("loanName")%>:</h3>

<form action="/create-new-Loan" method="get" name="grantConditionForm">
	<table id="tableForm">
		<tr>
			<th>نام</th>
			<th>حداقل مدت قرارداد</th>
			<th>حداکثر مدت قرارداد</th>
			<th>حداقل مبلغ قرارداد</th>
			<th>حداکثر مبلغ قرارداد</th>
		</tr>
	</table>
	<a href="javascript:void(0)" onclick="addInput();" class="link">شرط اعطای جدید</a>
	<br><br><br><br>
	<table>
		<tr></tr>
		<tr>
			<td></td>
			<td>
				<input type="hidden" name="loanName" value="${loanName}">
				<input type="hidden" name="interestRate" value="${interestRate}">
				<input type="button" value="ثبت" onclick="saveClicked();"/>
			</td>
		</tr>
	</table>
</form>
<br><br><br><br>
<a href="/index.jsp" class="link">صفحه اصلی</a>
</body>
</html>
