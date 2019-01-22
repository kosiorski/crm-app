<%--
  Created by IntelliJ IDEA.
  User: tomasz
  Date: 2018-12-31
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Task Form</title>

    <title>User Form</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>

<%--@elvariable id="task" type="pl.kosiorski.model.Task"--%>


<form:form action="/task/add" method="post" modelAttribute="task">

    <form:hidden path="project.id" value="1"/>
    <form:hidden path="user.id" value="1"/>
    <form:hidden path="status.id" value="1"/>
    <form:hidden path="priority.id" value="1"/>

    Description:<form:input path="description"/><form:errors path="description" cssClass="error"/><br>
    Subject:<form:input path="subject"/><form:errors path="subject" cssClass="error"/><br>

    <input type="submit" value="Save">
</form:form>


</body>
</html>
