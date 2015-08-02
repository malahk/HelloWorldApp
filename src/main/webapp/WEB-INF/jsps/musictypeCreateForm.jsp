<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25.07.2015
  Time: 1:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Create new genre</title>
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
    <legend align="center">Create genre:</legend>
    <form action="/create_musictype" method="post">
      Music genre:<input type="text" name="musicGenre" >
      <input type="submit" value="Create">
      <input type="reset" value="Clean">
      <input type="button" onclick="location.href='/list_musictype';" value="Update existing" />
    </form>
  </fieldset>
</div>
</body>
</html>