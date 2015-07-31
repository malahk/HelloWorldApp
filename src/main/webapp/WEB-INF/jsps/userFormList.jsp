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
    <style>
        #header {
            width: 100%;
            min-width: 100%;
        }
        #header .logOut {
            float: right;
        }
    </style>

</head>
<body>
<h1>${message}</h1>
<div id="header">
    Hi ${user.firstName}, you are ${user.role.roleName}.
    <a class="logOut" href="<c:url value="/logOut" />">logout</a>
</div>
<fieldset>
    <legend>List of users:</legend>
    <c:forEach var="user" items="${userList}">
    <p>${user.firstName}
        ${user.lastName}
        ${user.age}
        ${user.login}
        ${user.password}

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
</fieldset>
</body>
</html>
