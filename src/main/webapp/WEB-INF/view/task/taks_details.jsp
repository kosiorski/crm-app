<%--
  Created by IntelliJ IDEA.
  User: tomasz
  Date: 2019-01-04
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Task details</title>
</head>
<body>

<h1>Task Details: </h1>

<table border="1" width="100%" cellpadding="1">
    <tr>
        <th>Subject</th>
        <th>Description</th>
        <th>Assigned user</th>
        <th>Status</th>
        <th>Priority</th>
        <th>Edit</th>
    </tr>

    <form:form modelAttribute="task">

        <tr>
            <td>${task.geSubject()}</td>
            <td>${task.getDescription()}</td>
            <td>${task.user.getLogin()}</td>
            <td>${task.status.getName()}</td>
            <td>${task.priority.getName()}</td>
            <td><a href="${pageContext.request.contextPath}/task/edit/${task.id}">Edit task</a>
        </tr>
    </form:form>
</table>

</body>
</html>
