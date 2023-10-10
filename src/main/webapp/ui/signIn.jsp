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
<c:choose>
    <c:when test="${sessionScope.user != null}">
        <p>Вы уже вошли, хотите выйти?</p>
        <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/logout'" value="Выйти" /></p>
    </c:when>
    <c:otherwise>
    <c:choose>
        <c:when test="${requestScope.error}">
            <p style="color:red;">${requestScope.message}</p>
        </c:when>
        <c:otherwise>
            <p>Входите!</p>
        </c:otherwise>
</c:choose>
<form action="${pageContext.request.contextPath}/api/login" method="post">
    <p>Login:</p>
    <p><input type="text" name="login" /></p>
    <p>Password:</p>
    <p><input type="password" name="Login" /></p>
    <p><input type="submit" name="Login" /></p>
    <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/';" value="index" /></p>
    </c:otherwise>
</c:choose>
</form>
</body>
</html>



