<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 23.07.2015
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>
<head>
    <title>User List</title>
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
<%--<div id="header">--%>
<%--Hi ${user.firstName}, you are ${user.role.roleName}.--%>
<%--<a class="logOut" href="<c:url value="/logOut" />">logout</a>--%>
<%--</div>--%>
<fieldset>
    <legend>List of users:</legend>
    <table>
        <tr>
            <th>First name</th>
            <th>Last name</th>
            <th>Age</th>
            <th>Country</th>
            <th>Street</th>
            <th>Zip Code</th>
            <th>Login</th>
            <th>Password</th>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <th>Action</th>
            </sec:authorize>
        </tr>
        <c:forEach var="user" items="${userList}">
            <p>
                <tr>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.age}</td>
                    <td>${user.address.country}</td>
                    <td>${user.address.street}</td>
                    <td>${user.address.zipCode}</td>
                    <td>${user.login}</td>
                    <td>${user.password}</td>

                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                        <td>
                            <a href=" <c:url value="/update_user"> <c:param name="id" value="${user.id}"/> </c:url>" >Edit</a>

                            <a href=" <c:url value="/delete_user"> <c:param name="id" value="${user.id}"/> </c:url>" >Delete</a>
                        </td>
                    </sec:authorize>
                </tr>
            </p>
        </c:forEach>
    </table>
    <br>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <input type="button" onclick="location.href='/create_user';" value="Add new user" />
        <input type="button" onclick="location.href='/list_musictype';" value="Edit music types" />
        <input type="button" onclick="location.href='/role_list';" value="Edit roles" />
    </sec:authorize>
</fieldset>
</body>
</html>
