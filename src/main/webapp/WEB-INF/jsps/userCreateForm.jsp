<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 22.07.2015
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Create new user</title>
  <style>
    legend {
      font-size: 150%;
      text-align: center;
    }
    div.form
    {
      display: block;
      text-align: center;
    }
    form
    {
      display: inline-block;
      margin-left: auto;
      margin-right: auto;
      text-align: center;
    }
  </style>
</head>
<body>
<div class="form">
  <fieldset>
    <legend align="center">Create user:</legend>
    <form action="/create_user" method="post">
      First Name:<br><input type="text" name="firstName" >
      <br>
      Last Name:<br><input type="text" name="lastName">
      <br>
      Age:<br><input type="text" name="age">
      <br>
      Preferred music type:<br><input type="text" name="musicType">
      <br>
      Login:<br><input type="text" name="login">
      <br>
      Password:<br><input type="password" name="password">
      <br>
      <input type="hidden" name="id" value="${user.id}">
      <input type="submit" value="Submit">
      <input type="reset" value="Cancel">
      <a href="<c:url value="/update_user" />" >Update existing</a>
    </form>
  </fieldset>
</div>
</body>
</html>
