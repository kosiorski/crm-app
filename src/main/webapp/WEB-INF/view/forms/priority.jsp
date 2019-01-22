<%--
  Created by IntelliJ IDEA.
  User: tomasz
  Date: 2018-12-31
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Priority Form</title>

    <title>User Form</title>
    <style>
        .error {
            color: red;
        }
    </style>

</head>
<body>

<%--@elvariable id="priority" type="pl.kosiorski.model.Priority"--%>

<form:form action="/priority/add" method="post" modelAttribute="priority">
    Name:<form:input path="name"/><form:errors path="name" cssClass="error"/><br>
         <form:hidden path="isActive" value="true"/>

    <input type="submit" value="Save">
</form:form>


</body>
</html>
