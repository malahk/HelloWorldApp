<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25.06.2015
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Get Start</title>
    <style>
      legend {
        text-size: 150%;
        text-align: center;
      }
      div.form {
      display: block;
      text-align: center;
    }
    form {
      display: inline-block;
      margin-left: auto;
      margin-right: auto;
      text-align: center;
    }
    </style>
</head>
<body>
<div class="form">

  <c:if test="${not empty error}">
    <div class="error">${error}</div>
  </c:if>
  <c:if test="${not empty msg}">
    <div class="msg">${msg}</div>
  </c:if>

  <fieldset>
    <legend align="center">Log In:</legend>
    <form
            action="<c:url value='/j_spring_security_check' />" method='POST'>
      Login<br><input type="text" name="login">
      <br>
      Password<br><input type="password" name="password">
      <br>
      <input type="submit" value="Sign In">
      <a href="<c:url value="/register" />" >Register</a>

      <input type="hidden" name="${_csrf.parameterName}"
             value="${_csrf.token}" />

    </form>
  </fieldset>
</div>
</body>
</html>
