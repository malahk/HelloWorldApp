<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25.06.2015
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Get Start</title>
</head>
<body>
<form action="/createForm" method="post" >
  Login:<input type="text" name="login">
  <br>
  Password:<input type="password" name="password">
  <br>
  <input type="submit" value="Sign In">
  <a href="<c:url value="/register" />" >Register</a>
</form>
</body>
</html>
