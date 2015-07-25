<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 24.07.2015
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
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
</head>
<body>
<h1>${message}</h1>
<form action="/create_address" method="post">
  Country:<input type="text" name="country">
  <br>
  Street:<input type="text" name="street">
  <br>
  ZipCode:<input type="text" name="zipCode">
  <br>
  <input type="hidden" name="userId" value="${userId}">
  <input type="submit" value="Create">
  <input type="reset" value="Cancel">
  <a href="<c:url value="/update_address" />" >Update existing</a>
</form>
</body>
</html>

</body>
</html>
