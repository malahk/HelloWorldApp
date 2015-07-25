<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  <title>Create new role</title>
</head>
<body>
<h1>${message}</h1>
<form action="/create_role" method="post">
  Role Name:<input type="text" name="roleName" >
  <input type="submit" value="Create">
  <input type="reset" value="Clean">
  <a href="<c:url value="/update_role" />" >Update existing</a>
</form>
</body>
</html>
