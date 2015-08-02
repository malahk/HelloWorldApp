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
    <legend align="center">Update user:</legend>
    <form action="/update_user" method="post">
      First Name:<br><input type="text" name="firstName" value="${user.firstName}">
      <br>
      Last Name:<br><input type="text" name="lastName" value="${user.lastName}">
      <br>
      Age:<br><input type="text" name="age" value="${user.age}">
      <br>
      Country:<br><input type="text" name="age" value="${user.address.country}">
      <br>
      Street:<br><input type="text" name="age" value="${user.address.street}">
      <br>
      Zip Code:<br><input type="text" name="age" value="${user.address.zipCode}">
      <%--<br>--%>
      <%--Preferred music type:<br><input type="text" name="musicType" value="${user.musicTypes}">--%>
      <br>
      Login:<br><input type="text" name="login" value="${user.login}">
      <br>
      Password:<br><input type="password" name="password" value="${user.password}">
      <br>
      <input type="hidden" name="id" value="${user.id}">
      <input type="hidden" name="addressId" value="${address.id}">
      <input type="hidden" name="roleId" value="${role.id}">
      <input type="submit" value="Update">
      <input type="reset" value="Clean"><input type="button" onclick="location.href='/user_list';" value="Update existing" />
    </form>
  </fieldset>
</div>
</body>
</html>
