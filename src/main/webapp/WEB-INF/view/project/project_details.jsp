<%--
  Created by IntelliJ IDEA.
  User: tomasz
  Date: 2019-01-04
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Project Details</title>
</head>
<body>


<h1>Projects Details: </h1>

<table border="1" width="100%" cellpadding="1">
    <tr>
        <th>Name</th>
        <th>Description</th>
        <th>Created</th>
        <th>Tasks</th>
        <th>Add task</th>
        <th>Edit</th>
    </tr>

    <form:form modelAttribute="project">

    <tr>
        <td>${project.getName()}</td>
        <td>${project.getDescription()}</td>
        <td>${project.getCreated()}</td>

        <td><a href="${pageContext.request.contextPath}/project/tasks/${project.id}">Show tasks</a>
        <td><a href="${pageContext.request.contextPath}/task/add/${project.id}">Add task</a>
        <td><a href="${pageContext.request.contextPath}/project/edit/${project.id}">Edit project</a>
    </tr>
</table>

<h3>Project users: </h3>

<table border="1" width="100%" cellpadding="1">
    <tr>
        <th>Id</th>
        <th>First Name</th>
        <th>Last Name</th>
    </tr>
    <c:forEach items='${project.users}' var='user'>
        <tr>
            <td>${user.getId()}</td>
            <td>${user.getFirstName()}</td>
            <td>${user.getLastName()}</td>
        </tr>
    </c:forEach>
    </form:form>

</table>


<br><br>

<form:form action="/home" method="get">
    <button type="Submit">Go To Home Page</button>
</form:form>


</body>
</html>
