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
    <title>Music Type</title>
</head>
<body>
<form action="/update_musictype" method="post">
  Genre:<input type="text" name="genre" value="${musicType.musicGenre}">
  <input type="hidden" name="id" value="${musicType.id}">
  <input type="submit" value="Submit">
  <input type="reset" value="Cancel">
  <input type="submit" value="Update">
  <input type="submit" value="Delete">
</form>
</body>
</html>
