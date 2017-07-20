<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script>
        function showCustomer(customerId) {
            var xhttp;
            if (customerId == "") {
                document.getElementById("test").innerHTML = "";
                return;
            }
            xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200) {
                    document.getElementById("test").innerHTML = this.responseText;
                }
            };
            xhttp.open("GET", "/get-real-customer?customerId=" + customerId, true);
            xhttp.send();
        }
    </script>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>تشکیل پرونده تسهیلاتی</title>
</head>
<body>
<form action="/get-real-customer" method="get">
    <table>
        <tr>
            <td>شماره مشتری:</td>
            <td>
                <input type="text" name="customerId" class="fixed">
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="button" value="جستجو" name="getCustomer">
            </td>
        </tr>
    </table>
</form>
<c:if test="${customer != null}">
    <div id="customerInfo">
        <table>
            <tr>
                <td>نام:</td>
                <td><input type="text" name="firstName" value="${customer.firstName}" readonly><br></td>
            </tr>
            <tr>
                <td>نام خانوادگی:</td>
                <td><input type="text" name="lastName" value="${customer.lastName}" readonly></td>
            </tr>
        </table>
    </div>
    <br><br><br><br>
    <div class="center">
        <form action="/check-verification" method="get">
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
            </table>
        </form>
    </div>
</c:if>
<div id="test"></div>
$(document).on("click", "getCustomer", function() {               // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
$.get("/get-real-customer", function(responseJson) {                 // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response JSON...
var $select = $("test");                           // Locate HTML DOM element with ID "someselect".
$select.find("option").remove();                          // Find all child elements with tag name "option" and remove them (just to prevent duplicate options when button is pressed again).
$.each(responseJson, function(key, value) {               // Iterate over the JSON object.
$("<option>").val(key).text(value).appendTo($select); // Create HTML <option> element, set its value with currently iterated key and its text content with currently iterated item and finally append it to the <select>.
    });
    });
    });
<br><br><br><br>
<a href="/index.jsp" class="link">صفحه اصلی</a>
</body>
</html>
