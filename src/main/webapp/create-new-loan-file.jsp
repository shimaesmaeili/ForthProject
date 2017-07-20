<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="http://code.jquery.com/jquery-1.10.2.js" type="text/javascript"></script>
    <script src="js/dynamic.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>تشکیل پرونده تسهیلاتی</title>
</head>
<body>
<form>
    <table>
        <tr>
            <td>
                شماره مشتری:
            </td>
            <td>
                <input type="text" name="customerId" id="customerId" class="fixed">
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="button" value="جستجو" id="search"/>
            </td>
        </tr>
    </table>
</form>
<div id="customerInfo" style="display: none">
    <table>
        <tr>
            <td>نام:</td>
            <td><input type="text" name="firstName" id="firstName" value="" readonly><br></td>
        </tr>
        <tr>
            <td>نام خانوادگی:</td>
            <td><input type="text" name="lastName" id="lastName" value="" readonly></td>
        </tr>
    </table>
</div>
<br><br><br><br>
<div class="center" id="loansInfo" style="display:none">
    <form action="/check-verification" method="get">
        <table>
            <tr>
                <td>نوع تسهیلات:</td>
                <td>
                    <select name="loanId" id="loans" class="fixed">
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
                    <input type="hidden" name="customerId" id="userId" value="">
                    <input type="submit" value="بررسی">
                </td>
            </tr>
        </table>
    </form>
</div>
<div id="test"></div>
<br><br><br><br>
<a href="/index.jsp" class="link">صفحه اصلی</a>
</body>
</html>
