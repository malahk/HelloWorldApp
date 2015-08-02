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
  <style>
    table, th, td {
      border: 2px solid black;
      border-collapse: collapse;
    }
    th, td {
      padding: 5px;
    }
  </style>
</head>
<body>
<h1>${message}</h1>
<fieldset>
  <legend>List of roles:</legend>
  <table>
    <tr>
      <th>Role name</th>
      <th>Action</th>
    </tr>
    <c:forEach var="role" items="${roleList}">
      <p>
      <tr>
        <td>${role.roleName}</td>
        <td>
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
        </td>
        </tr>
      </p>
    </c:forEach>
  </table>
  <br>
  <input type="button" onclick="location.href='/create_role';" value="Add new role" />
</fieldset>
</body>
</html>
