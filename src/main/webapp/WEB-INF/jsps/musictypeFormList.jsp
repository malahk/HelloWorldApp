<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 22.07.2015
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>List of Music</title>
</head>
<body>
<h1>${message}</h1>
<fieldset>
  <legend>Genres list:</legend>
  <c:forEach var="musicType" items="${musicTypeList}">
    <p>${musicType.musicGenre}

      <a href="
      <c:url value="/update_musictype">
        <c:param name="id" value="${musicType.id}"/>
      </c:url>
      " >Edit</a>


      <a href="
      <c:url value="/delete_MusicType">
        <c:param name="id" value="${musicType.id}"/>
      </c:url>
      " >Delete</a>


    </p>
  </c:forEach>
</fieldset>
</body>
</html>
