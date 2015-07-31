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
</head>
<body>
<h1>${message}</h1>
<fieldset>
  <legend>Address list:</legend>
  <c:forEach var="address" items="${addressList}">
    <p>
        ${address.country}
        ${address.street}
        ${address.zipCode}

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
    </p>
  </c:forEach>
</fieldset>
</body>
</html>
