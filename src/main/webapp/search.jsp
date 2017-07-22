<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<title>جستجو</title>

	<script>
		function Validate() {
			var frm = document.searchForm;
			if (frm.customerType.value == "") {
				alert("انتخاب نوع مشتری الزامی است!");
				return false;
			} else if (frm.field.value == "") {
				alert("انتخاب فیلد جستجو الزامی است!");
				return false;
			} else if (frm.value.value == "") {
				alert("وارد کردن عبارت جستجو الزامی است!");
				return false;
			}
			return true;
		}
		function Clicked() {
			if (Validate()) {
				document.searchForm.submit();
			}
		}
	</script>
</head>

<body>
<form id="search" action="/find" method="post" name="searchForm">
	<fieldset class="size">
		نوع مشتری: <br>
		<select id="customerType" name="customerType" onchange="byType(this.value)" class="fixed">
			<option selected disabled hidden style='display: none' value=''></option>
			<option value="real">مشتری حقیقی</option>
			<option value="legal">مشتری حقوقی</option>
		</select>

		<br>جستجو بر اساس: <br>
		<select id="field" name="field" selected="id" class="fixed">
			<option data-option="real" value="firstName">نام</option>
			<option data-option="real" value="lastName">نام خانوادگی</option>
			<option data-option="real" value="idCode">کد ملی</option>
			<option data-option="real" value="id">شماره مشتری</option>
			<option data-option="legal" value="name">نام شرکت</option>
			<option data-option="legal" value="eCode">کد اقتصادی</option>
			<option data-option="legal" value="id">شماره مشتری</option>
		</select>

		<br>مقدار مورد نظر:<br>
		<input type="text" name="value" class="fixed">
		<br><br>
		<input type="button" value="جستجو" onclick="Clicked()">

		<script type="text/javascript">
			var sel1 = document.querySelector('#customerType');
			var sel2 = document.querySelector('#field');
			var options2 = sel2.querySelectorAll('option');

			function byType(selValue) {
				sel2.innerHTML = '';
				for (var i = 0; i < options2.length; i++) {
					if (options2[i].dataset.option == selValue) {
						sel2.appendChild(options2[i]);
					}
				}
			}
			byType(sel1.value);
		</script>
	</fieldset>
</form>
<br><br>
<a href="/customers.jsp" class="link">صفحه مشتریان</a>
</body>
</html>
