<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 31.07.2015
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
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

<h1>HTTP Status 403 - Access is denied</h1>

<c:choose>
  <c:when test="${empty username}">
    <h2>You do not have permission to access this page!</h2>
  </c:when>
  <c:otherwise>
    <h2>Username : ${username} <br/>
      You do not have permission to access this page!</h2>
  </c:otherwise>
</c:choose>

</body>
</html>
