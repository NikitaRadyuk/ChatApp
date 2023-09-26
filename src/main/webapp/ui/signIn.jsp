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
<form action="${pageContext.request.contextPath}/ui/signIn.jsp" method="POST">
    <p style="text-align:center">Authorization:</p>

    <p>Login:</p>

    <p><input maxlength="15" name="login" required="required" size="10" type="text" value="login" /></p>

    <p>Password:</p>

    <p><input maxlength="15" name="password" required="required" size="10" type="password" value="password" /></p>

    <p><input name="loginBtn" type="button" value="Login" /></p>

</form>
</body>
</html>