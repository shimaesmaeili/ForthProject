<%@page pageEncoding="UTF-8" language="java" %>
<%@page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>مشتری حقیقی جدید</title>
    <script>
        function IDCode(input) {
            var sum = 0;
            for (var i = 0; i < input.length - 1; i++) {
                sum += input[i] * (i + 1);
            }
            if (sum % 11 == input[input.length - 1] || sum % 11 == 11 - input[input.length - 1]) {
                return true;
            } else {
                return false;
            }
        }

        function Validate() {
            var frm = document.realForm;
            if (frm.firstName.value == "") {
                alert("وارد کردن نام الزامی است!");
                return false;
            } else if (frm.lastName.value == "") {
                alert("وارد کردن نام خانوادگی الزامی است!");
                return false;
            } else if (frm.fatherName.value == "") {
                alert("وارد کردن نام پدر الزامی است!");
                return false;
            } else if (frm.birthDate.value == "") {
                alert("وارد کردن تاریخ تولد الزامی است!");
                return false;
            } else if (frm.idCode.value == "") {
                alert("وارد کردن کد ملی الزامی است!");
                return false;
            } else if (frm.idCode.value.length != 10) {
                alert("کد ملی می‌بایست ده رقمی باشد!");
                return false;
            } else if (!IDCode(frm.idCode.value)) {
                alert("کد ملی نامعتبر است!");
                return false;
            }
            return true;
        }

        function Clicked() {
            if (Validate()) {
                document.realForm.submit();
            }
        }
    </script>
</head>
<body>
<h3 class="center">اطلاعات مورد نیاز: </h3>
<div>
    <form action="newRealCustomer" method="get" name="realForm">
        <table>
            <tr>
                <td>نام:</td>
                <td><input type="text" name="firstName" class="fixed"><br></td>
            </tr>
            <tr>
                <td>نام خانوادگی:</td>
                <td><input type="text" name="lastName" class="fixed"></td>
            </tr>
            <tr>
                <td>نام پدر:</td>
                <td><input type="text" name="fatherName" class="fixed"></td>
            </tr>
            <tr>
                <td>تاریخ تولد:</td>
                <td><input type="date" name="birthDate" class="fixed"></td>
            </tr>
            <tr>
                <td>کد ملی:</td>
                <td><input type="number" name="idCode" class="fixed"></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="button" value="ثبت" onclick="Clicked()">
                </td>
            </tr>
        </table>
    </form>
</div>
<br><br><br><br>
<a href="/customers.jsp" class="link">صفحه اصلی</a>
</body>
</html>
