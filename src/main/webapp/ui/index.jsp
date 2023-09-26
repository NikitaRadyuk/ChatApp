<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 22.09.2023
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Главная страница</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/ui/" method="POST">
<p>Login:</p>

<p><input name="loginBtn" type="submit" value="Login" /></p>

<p>Registration:</p>

<p><input name="regBtn" type="submit" value="Registration" /></p>
</form>
</body>
</html>