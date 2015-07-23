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
    <title>Registration</title>
</head>
<body>
<form action="/register" method="post">
  Login:<input type="text" name="login">
  <br>
  First Name:<input type="text" name="firstName" >
  <br>
  Last Name:<input type="text" name="lastName">
  <br>
  Age:<input type="text" name="age">
  <br>
  Country:<input type="text" name="country">
  <br>
  Street:<input type="text" name="street">
  <br>
  ZipCode:<input type="text" name="zipCode">
  <br>
  Preferred music type:<input type="text" name="musicType">
  <br>
  Password:<input type="password" name="password">
  <br>
  Repeat password:<input type="password" name="repeatedPassword">
  <br>
  <input type="submit" value="Submit">
  <input type="reset" value="Cancel">
</form>
</body>
</html>
