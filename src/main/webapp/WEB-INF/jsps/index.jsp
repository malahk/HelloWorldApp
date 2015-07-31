<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25.06.2015
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index page</title>
    <style>
        .header {
            width: 100%;
        }
    </style>
</head>
<body>
<div id="header">
    Hello ${user.getRole.roleName} ${user.getName}:
</div>
</body>
</html>
