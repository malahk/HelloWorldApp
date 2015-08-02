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

    .error {
      color: red;
    }
  </style>
</head>
<body>
<div class="form">
  <fieldset>
    <legend align="center">Registration:</legend>
    <form action="/register" method="post">
      Login:
      <em class="error">${login_error}</em>
      <br><input type="text" name="login">
      <br>
      First Name:<br><input type="text" name="firstName" >
      <br>
      Last Name:<br><input type="text" name="lastName">
      <br>
      Age:<br><input type="text" name="age">
      <br>
      Country:<br><input type="text" name="country">
      <br>
      Street:<br><input type="text" name="street">
      <br>
      ZipCode:<br><input type="text" name="zipCode">
      <br>
      Password:<br><input type="password" name="password">
      <br>
      Repeat password:
      <em class="error">${password_error}</em>
      <br><input type="password" name="repeatedPassword">
      <br>
      <input type="submit" value="Register">
      <input type="reset" value="Clean">
    </form>
  </fieldset>
  </div>
</body>
</html>
