<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 23.07.2015
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>
<head>
  <title>User List</title>
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
  <legend>List of users:</legend>
  <table>
    <tr>
      <th>First name</th>
      <th>Last name</th>
      <th>Age</th>
      <th>Country</th>
      <th>Street</th>
      <th>Zip Code</th>
      <th>Login</th>
      <th>Password</th>
    </tr>
    <c:forEach var="user" items="${userList}">
      <p>
        <tr>
          <td>${user.firstName}</td>
          <td>${user.lastName}</td>
          <td>${user.age}</td>
          <td>${user.address.country}</td>
          <td>${user.address.street}</td>
          <td>${user.address.zipCode}</td>
          <td>${user.login}</td>
          <td>${user.password}</td>
        </tr>
      </p>
    </c:forEach>
  </table>
</fieldset>
</body>
</html>
