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
			var frm = document.voteForm;

			var sub = frm.subject.value;
			if (sub == "") {
				alert("Subject is a required field");
				return false;
			}

			var choiceInputs = document.getElementById('choicesDiv').getElementsByTagName('input');
			for (i = 0; i < choiceInputs.length; i++)
				if (choiceInputs[i].value == "") {
					alert("Empty choices are not allowed");
					return false;
				}

			return true;
		}

		function saveClicked() {
//    if (Validate())
			document.voteForm.submit();
		}

	</script>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<title>تعریف شروط اعطا</title>
</head>
<body onLoad="addInput();">
<br><br><br><br>
<p>

<form action="/create-new-Loan" method="POST" name="voteForm">
	<%--<input type="text" name="loanName" value="${loanName}" readonly>--%>
	<table id="tableForm">
		<tr>
			<th>
				نام
			</th>
			<th>
				حداقل مدت قرارداد
			</th>
			<th>
				حداکثر مدت قرارداد
			</th>
			<th>
				حداقل مبلغ قرارداد
			</th>
			<th>
				حداکثر مبلغ قرارداد
			</th>
		</tr>
	</table>
	<a href="javascript:void(0)" onclick="addInput();" class="link">
		شرط اعطای جدید
	</a>
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
	<div class="center">

	</div>
</form>
</body>
</html>
