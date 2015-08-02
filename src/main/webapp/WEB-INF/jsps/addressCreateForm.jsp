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
  <title>Create new address</title>
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
<h1 align="center">${message}</h1>
<div class="form">
  <fieldset>
    <legend align="center">Create address:</legend>
    <form action="/create_address" method="post">
      Country:<br><input type="text" name="country">
      <br>
      Street:<br><input type="text" name="street">
      <br>
      ZipCode:<br><input type="text" name="zipCode">
      <br>
      <input type="hidden" name="userId" value="${userId}">
      <input type="submit" value="Create">
      <input type="reset" value="Cancel">
      <input type="button" onclick="location.href='/address_list';" value="Update existing" />
    </form>
  </fieldset>
  </div>
</body>
</html>
