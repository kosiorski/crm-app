<%--
  Created by IntelliJ IDEA.
  User: tomasz
  Date: 2018-12-31
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>User List</title>
</head>
<body>

<%--@elvariable id="user" type="pl.kosiorski.model.User"--%>


<h1>Users List: </h1>

<table border="1" width="70%" cellpadding="2">
    <tr>
        <th>Id</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
    </tr>
    <c:forEach items='${users}' var='task'>
        <tr>
            <td>${task.getId()}</td>
            <td>${task.getFirstName()}</td>
            <td>${task.getLastName()}</td>
            <td>${task.getEmail()} </td>

        </tr>
    </c:forEach>
</table>

<br><br>

<form:form action="/home" method="get">
    <button type="Submit">Go To Home Page</button>
</form:form>

</table>
</body>
</html>
