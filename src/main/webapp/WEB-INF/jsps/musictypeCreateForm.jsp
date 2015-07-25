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
</head>
<body>
<h1>${message}</h1>
<form action="/create_musictype" method="post">
  Music genre:<input type="text" name="musicGenre" >
  <input type="submit" value="Create">
  <input type="reset" value="Clean">
  <a href="<c:url value="/update_musictype" />" >Update existing</a>
</form>
</body>
</html>