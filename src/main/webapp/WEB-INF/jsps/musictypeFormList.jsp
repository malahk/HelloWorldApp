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
  <style>
    table, th, td {
      border: 2px solid black;
      border-collapse: collapse;
    }
    th, td {
      padding: 5px;
    }
  </style>
</head>
<body>
<h1>${message}</h1>
<fieldset>
  <legend>Genres list:</legend>
  <table>
    <tr>
      <th>Genre</th>
      <th>Action</th>
    </tr>
  <c:forEach var="musicType" items="${musicTypeList}">
    <p>
      <tr>
        <td>${musicType.musicGenre}
        <td>
          <a href="<c:url value="/update_musictype"> <c:param name="id" value="${musicType.id}"/> </c:url>" >Edit</a>

          <a href="<c:url value="/delete_MusicType"> <c:param name="id" value="${musicType.id}"/> </c:url>" >Delete</a>
        </td>
      </tr>
    </p>
  </c:forEach>
  </table>
  <br>
  <input type="button" onclick="location.href='/create_musictype';" value="Add new genre" />
</fieldset>
</body>
</html>
