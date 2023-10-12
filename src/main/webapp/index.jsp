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
<p>Добро пожаловать, <c:choose>
            <c:when test="${pageContext.session != null && sessionScope.user != null}">
                ${sessionScope.user.userName}
            </c:when>
            <c:otherwise>
                Гость
            </c:otherwise>
        </c:choose>
</p>
<c:choose>
    <c:when test="${sessionScope.user == null}">
        <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/ui/signIn';" value="Войти" /></p>
        <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/ui/signUp';" value="Зарегистрироваться" /></p>
    </c:when>
    <c:otherwise>
        <c:if test="${'ADMIN'.equals(sessionScope.user.role.name())}">
            <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/ui/admin/statistics';" value="Статистика" /></p>
        </c:if>
        <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/ui/user/chats';" value="Мои сообщения" /></p>
        <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/ui/user/message';" value="Отправить сообщение" /></p>
        <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/ui/user/logout';" value="Выйти" /></p>
    </c:otherwise>
</c:choose>
</body>
</html>
