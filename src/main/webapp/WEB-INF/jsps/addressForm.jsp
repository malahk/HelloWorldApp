<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 22.07.2015
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="editUrl" value="{test}" />
<html>
<head>
    <title>Address</title>
</head>
<body>
<form action="/createForm"method="post">
  Country:<input type="text" name="country">
  <br>
  Street:<input type="text" name="street">
  <br>
  ZipCode:<input type="text" name="zipCode">
  <br>
  <input type="hidden" name="id" value="${address.id}">
  <input type="submit" value="Submit">
  <input type="reset" value="Cancel">
  <input type="submit" value="Update">
  <input type="submit" value="Delete">
</form>
</body>
</html>
