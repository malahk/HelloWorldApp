<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 23.07.2015
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Roles List</title>
</head>
<body>
<h1>${message}</h1>

<c:forEach var="role" items="${roleList}">
  <p>${role.roleName}

    <a href="
      <c:url value="/update_role">
        <c:param name="id" value="${role.id}"/>
      </c:url>
      " >Edit</a>

    <a href="
      <c:url value="/delete_role">
        <c:param name="id" value="${role.id}"/>
      </c:url>
      " >Delete</a>


  </p>
</c:forEach>
</body>
</html>
