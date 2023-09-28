<%@ page import="by.it.jd2.Mk_JD2_103_23.chatApp.core.dto.User" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 22.09.2023
  Time: 21:08
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
    <title>Здесь будут отображаться сообщения, отправленные текущему пользователю</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/api/message" method="POST">
<h1>Hello, <%= ((User) request.getSession().getAttribute("loggedInUser")).getFullName()%>></h1>
</form>
</body>
</html>
