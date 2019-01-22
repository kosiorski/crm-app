<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>


<html>

<head>
    <title>Company Home Page</title>
</head>

<body>
<h2>Company Home Page</h2>
<hr>

<p>
    Welcome to the company home page!
</p>

<hr>

<p>
    User: <security:authentication property="principal.username"/>
    <br><br>
    Role(s): <security:authentication property="principal.authorities"/>
</p>


<table border="1" width="100%" cellpadding="1">
    <thead>
    <tr>
        <th>Projects</th>
        <th>Users</th>
        <th>Statuses</th>
        <th>Priorities</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td><a href="${pageContext.request.contextPath}/project/list">Project list</a>
            <a href="${pageContext.request.contextPath}/project/add">Add new project</a></td>
        <td><a href="${pageContext.request.contextPath}/user/list">User list</a>
            <a href="${pageContext.request.contextPath}/user/add">Add a new user</a></td>
        <td><a href="${pageContext.request.contextPath}/status/list">Status list</a>
            <a href="${pageContext.request.contextPath}/status/add">Add a new status</a></td>
        <td><a href="${pageContext.request.contextPath}/priority/list">Priority list</a>
            <a href="${pageContext.request.contextPath}/priority/add">Add a new priority</a></td>
    </tr>
    </tbody>
</table>


<h3>Recent activities</h3>

<table border="1" width="100%" cellpadding="1">
    <tr>
        <th>Content</th>
        <th>Created</th>
    </tr>
    <c:forEach items='${activities}' var='task'>
        <tr>
            <td>${task.getContent()}</td>
            <td>${task.getCreated()}</td>
        </tr>
    </c:forEach>
</table>

<br>


<form:form action="${pageContext.request.contextPath}/logout"
           method="POST">

    <input type="submit" value="Logout"/>

</form:form>

<form:form action="${pageContext.request.contextPath}/admin/home"
           method="GET">

    <input type="submit" value="Go to Admin Page"/>

</form:form>

</body>
</html>









