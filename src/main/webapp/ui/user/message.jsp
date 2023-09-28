<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 22.09.2023
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Форма для отправки сообщения</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/api/message" method="post">
<p style="text-align:center">Write a message:</p>

<p>To:</p>
    <c:set var="to" />
<p><input maxlength="15" name="To:" required="required" size="10" type="text" /></p>

<p>Your Text:</p>
    <c:set var="text" />
<p><textarea cols="10" name="text" required="required" rows="4"></textarea></p>

<p><input name="send" type="submit" /></p>
</form>
</body>
</html>
