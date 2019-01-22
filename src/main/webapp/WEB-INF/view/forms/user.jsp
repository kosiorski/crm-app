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
    <title>User Form</title>
    <style>
        .error {
            color: red;
        }
    </style>
    <title>User Add Form</title>
</head>
<body>

<%--@elvariable id="user" type="pl.kosiorski.model.User"--%>


<form:form action="/user/add" method="post" modelAttribute="user">

    Login:<form:input path="login"/><form:errors path="login" cssClass="error"/><br>
    Password:<form:password path="password"/><form:errors path="password" cssClass="error"/><br>
    Email:<form:input path="email"/><form:errors path="email" cssClass="error"/><br>
    First Name:<form:input path="firstName"/><form:errors path="firstName" cssClass="error"/><br>
    Last Name:<form:input path="lastName"/><form:errors path="lastName" cssClass="error"/><br>
    <input type="submit" value="Save">

</form:form>

</body>
</html>
