<%--
  Created by IntelliJ IDEA.
  User: tomasz
  Date: 2019-01-04
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Project Tasks</title>
</head>
<body>

<h1>Current Project Tasks List: </h1>

<table border="1" width="70%" cellpadding="2">
    <tr>
        <th>Subject</th>
        <th>Description</th>
        <th>Created on</th>
        <th>Assigned user</th>
        <th>Edit</th>
    </tr>
    <c:forEach items='${tasks}' var="task">
        <tr>
            <td>${task.getSubject()}</td>
            <td>${task.getDescription()}</td>
            <td>${task.getCreated()}</td>
            <td>${task.user.getLogin()}</td>
            <td><a href="${pageContext.request.contextPath}/task/edit/${task.id}">Edit task</a>

        </tr>
    </c:forEach>
</table>

<br><br>

<form:form action="/home" method="get">
    <button type="Submit">Go To Home Page</button>
</form:form>
</tbody>
</table>


</body>
</html>
