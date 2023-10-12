<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Регистрация</title>
</head>
<body>
<c:choose>
    <c:when test="${requestScope.error}">
        <p style="color:red;">${requestScope.message}</p>
    </c:when>
    <c:otherwise>
        <p>Пройдите регистрацию</p>
    </c:otherwise>
</c:choose>
<form action="${pageContext.request.contextPath}/api/reg" method="POST">

    <p style="text-align:center">Регистрация</p>

    <label>Логин
        <c:set var="login" />
        <p><input maxlength="15" name="login" required="required" size="10" type="text" value="${login}" /></p>
    </label>

    <label>Пароль
        <c:set var="password" />
        <p><input maxlength="15" name="password" required="required" size="10" type="password" value="${password}" /></p>
    </label>

    <label>ФИО
        <c:set var="username" />
        <p><input maxlength="50" name="username" required="required" size="10" type="text" value="${username}" /></p>
    </label>

    <label>День рождения
        <c:set var="birthday" />
        <p><input maxlength="15" name="birthday" size="10" type="text" value="${birthday}" /></p>
    </label>


    <p><input type="submit" value="Зарегистрироваться" /></p>
    <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/'" value="index" /></p>
</form>
</body>
</html>