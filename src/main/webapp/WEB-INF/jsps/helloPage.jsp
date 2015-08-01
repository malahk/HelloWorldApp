<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25.07.2015
  Time: 3:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <title>Welcome Back</title>
  <style>
    h1 {
      font-size: 400%;
      font-family: Geneva, Arial, Helvetica, sans-serif;
    }
    p {
      font-size: 400%;
      font-family: Georgia, 'Times New Roman', Times, serif;
    }
    p.oblique {
      font-style: oblique;
    }

    #header {
      width: 100%;
      min-width: 100%;
    }
    #header .logOut {
      float: right;
    }
  </style>
</head>
<body>

<c:url value="/j_spring_security_logout" var="logoutUrl" />
<form action="${logoutUrl}" method="post" id="logoutForm">
  <input type="hidden" name="${_csrf.parameterName}"
         value="${_csrf.token}" />
</form>
<script>
  function formSubmit() {
    document.getElementById("logoutForm").submit();
  }
</script>

<div id="header">
  Hi ${user.firstName}, you are ${user.role.roleName}.
  <a class="logOut" href="<c:url value="/logOut" />">logout</a>
</div>
<h1>Welcome back</h1>
<p class="oblique">
  Hello ${user.firstName} :)
</p>
</body>
</html>
