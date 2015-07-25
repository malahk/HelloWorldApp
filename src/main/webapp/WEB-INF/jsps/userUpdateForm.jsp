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
<form action="/update_user" method="post">
  First Name:<input type="text" name="firstName" value="${user.firstName}">
  <br>
  Last Name:<input type="text" name="lastName" value="${user.lastName}">
  <br>
  Age:<input type="text" name="age" value="${user.age}">
  <br>
  Preferred music type:<input type="text" name="musicType" value="${user.musicTypes}">
  <br>
  Login:<input type="text" name="login" value="${user.login}">
  <br>
  Password:<input type="password" name="password" value="${user.password}">
  <br>
  <input type="hidden" name="id" value="${user.id}">
  <input type="hidden" name="addressId" value="${address.id}">
  <input type="hidden" name="roleId" value="${role.id}">
  <input type="submit" value="Update">
  <input type="reset" value="Clean">
</form>
</body>
</html>
