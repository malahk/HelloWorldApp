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
    <title>Update role</title>
</head>
<body>
<form action="/update_role" method="post">
  Role Name:<input type="text" name="roleName" value="${role.roleName}">
  <input type="hidden" name="id" value="${role.id}">
  <input type="submit" value="Update">
  <input type="reset" value="Clean">
</form>
</body>
</html>
