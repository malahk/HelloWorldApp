<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 23.07.2015
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Address List</title>
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
  <legend>Address list:</legend>
  <table>
    <tr>
      <th>Country</th>
      <th>Street</th>
      <th>ZipCode</th>
      <th>Action</th>
    </tr>
    <c:forEach var="address" items="${addressList}">
      <p>
      <tr>
          <td>${address.country}</td>
          <td>${address.street}</td>
          <td>${address.zipCode}</td>
    <td>
        <a href="
      <c:url value="/update_address">
        <c:param name="id" value="${address.id}"/>
      </c:url>
      " >Edit</a>

        <a href="
      <c:url value="/delete_address">
        <c:param name="id" value="${address.id}"/>
      </c:url>
      " >Delete</a>
    </td>
      </tr>
      </p>
    </c:forEach>
  </table>
</fieldset>
</body>
</html>
