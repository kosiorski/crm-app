<%--
  Created by IntelliJ IDEA.
  User: tomasz
  Date: 2018-12-31
  Time: 12:13
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

<%--@elvariable id="element" type="pl.kosiorski.model.Project"--%>


<h1>Projects List: </h1>

<table border="1" width="100%" cellpadding="1">
    <tr>
        <th>Name</th>
        <th>Description</th>
        <th>Details</th>
    </tr>
    <c:forEach items='${projects}' var='element'>
        <tr>
            <td>${element.getName()}</td>
            <td>${element.getDescription()}</td>
            <td><a href="${pageContext.request.contextPath}/project/details/${element.id}">Show details</a>


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
