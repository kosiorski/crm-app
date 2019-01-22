<%--
  Created by IntelliJ IDEA.
  User: tomasz
  Date: 2019-01-04
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Priority List</title>
</head>
<body>


<h1>Projects List: </h1>
<p>
<table border="1" width="100%" cellpadding="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Status</th>

    </tr>
    <c:forEach items='${priorities}' var='task'>
    <tr>
        <td>${task.getId()}</td>
        <td>${task.getName()}</td>
        <td>${task.getActive()}

            <c:choose>
                <c:when test="${task.getActive()}">
                    <a href="/priority/change-status/${task.id}">Deactivate</a>
                </c:when>
                <c:otherwise>
                    <a href="/priority/change-status/${task.id}">Activate</a>
                </c:otherwise>
            </c:choose>
        </td>
    </tr>
    </c:forEach>
</table>

<br><br>

<form:form action="/home" method="get">
    <button type="Submit">Go To Home Page</button>
</form:form>
</body>
</html>
