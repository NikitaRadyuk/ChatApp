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
<form action="${pageContext.request.contextPath}/registration" method="POST">

    <p style="text-align:center">Регистрация</p>

    <p><input maxlength="15" name="Логин" required="required" size="10" type="text" value="login" /></p>

    <p><input maxlength="15" name="password" required="required" size="10" type="text" value="password" /></p>

    <p><input maxlength="50" name="ФИО" required="required" size="10" type="text" value="username" /></p>

    <p><input maxlength="15" name="birthday" size="10" type="text" value="birthday" /></p>

    <p><input name="regBtn" type="submit" value="Зарегистрироваться" /></p>
</form>
</body>
</html>