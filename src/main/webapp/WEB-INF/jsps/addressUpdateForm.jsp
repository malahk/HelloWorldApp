<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 22.07.2015
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Update Address</title>
</head>
<body>
<form action="/update_address" method="post">
  Country:<input type="text" name="country" value="${address.country}">
  <br>
  Street:<input type="text" name="street" value="${address.street}">
  <br>
  ZipCode:<input type="text" name="zipCode" value="${address.zipCode}">
  <br>
  <input type="hidden" name="id" value="${address.id}">
  <input type="submit" value="Update">
  <input type="reset" value="Clean">
</form>
</body>
</html>
