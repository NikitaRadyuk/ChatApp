<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 22.09.2023
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Главная страница</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/api/login" method="POST">
    <p style="text-align:center">Authorization:</p>

    <p>Login:</p>

    <p><input maxlength="15" name="login" required="required" size="10" type="text" placeholder="login"/></p>

    <p>Password:</p>

    <p><input maxlength="15" name="password" required="required" size="10" type="password" placeholder="password"/></p>

    <p><input name="loginBtn" type="button" value="Login" /></p>

</form>
</body>
</html>