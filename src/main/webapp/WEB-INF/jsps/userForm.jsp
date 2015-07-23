<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 22.07.2015
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
</head>
<body>
<form action="/createForm"method="post">
  First Name:<input type="text" name="firstName" >
  <br>
  Last Name:<input type="text" name="lastName">
  <br>
  Age:<input type="text" name="age">
  <br>
  Preferred music type:<input type="text" name="musicType">
  <br>
  Login:<input type="text" name="login">
  <br>
  Password:<input type="password" name="password">
  <br>
  <input type="hidden" name="id" value="${user.id}">
  <input type="submit" value="Submit">
  <input type="reset" value="Cancel">
  <input type="submit" value="Update">
  <input type="submit" value="Delete">
</form>
</body>
</html>
