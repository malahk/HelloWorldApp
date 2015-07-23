<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 22.07.2015
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Role</title>
</head>
<body>
<form action="/createForm"method="post">
  Role Name:<input type="text" name="roleName" >
  <input type="hidden" name="id" value="${role.id}">
  <input type="submit" value="Submit">
  <input type="reset" value="Cancel">
  <input type="submit" value="Update">
  <input type="submit" value="Delete">
</form>
</body>
</html>
