<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 23.07.2015
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>User List</title>
</head>
<body>
<h1>${message}</h1>

<c:forEach var="user" items="${userList}">
  <p>${user.firstName}
  <p>${user.lastName}
  <p>${user.age}
  <p>${user.login}
  <p>${user.password}

    <a href="
      <c:url value="/update_user">
        <c:param name="id" value="${user.id}"/>

      </c:url>
      " >Edit</a>

    <a href="
      <c:url value="/delete_user">
        <c:param name="id" value="${user.id}"/>
      </c:url>
      " >Delete</a>


  </p>
</c:forEach>
</body>
</html>
