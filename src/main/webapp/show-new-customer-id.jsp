<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<title>شماره مشتری</title>
</head>
<body>
<p id="generatedID" class="big">شماره مشتری:
	<%=request.getAttribute("id")%>
</p>
<a href="/customers.jsp" class="link">صفحه اصلی</a>
</body>
</html>
