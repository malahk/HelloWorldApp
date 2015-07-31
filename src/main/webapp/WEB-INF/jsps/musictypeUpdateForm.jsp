<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 22.07.2015
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update genre</title>
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
    <legend align="center">Update genre:</legend>
    <form action="/update_musictype" method="post">
      Genre:<input type="text" name="genre" value="${musicType.musicGenre}">
      <input type="hidden" name="id" value="${musicType.id}">
      <input type="submit" value="Update">
      <input type="reset" value="Clean">
    </form>
  </fieldset>
</div>
</body>
</html>
