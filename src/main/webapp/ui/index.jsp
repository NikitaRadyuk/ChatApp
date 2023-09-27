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
<form action="${pageContext.request.contextPath}/api" method="POST">
<p>Login:</p>
<input type="hidden" name="Login"/>
<p><input name="loginBtn" type="submit" value="Login" />
</p>
</form>
<form action="${pageContext.request.contextPath}/api" method="POST">
<p>Registration:</p>
    <input type="hidden" name="Registration"/>
<p><input name="regBtn" type="submit" value="Registration" /></p>
</form>
</body>
</html>