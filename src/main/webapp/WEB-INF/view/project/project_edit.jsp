<%--
  Created by IntelliJ IDEA.
  User: tomasz
  Date: 2018-12-31
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <style>
        .error {
            color: red;
        }
    </style>
    <title>Project Edit Form</title>
</head>
<body>

<h3>Edit project: </h3>

<form:form action="/project/editsave" method="post">

    Name:<form:input path="name"/><form:errors path="name" cssClass="error"/><br>
    Description:<form:input path="description"/><form:errors path="description" cssClass="error"/><br>
    Url Address:<form:input path="urlAddress"/><form:errors path="urlAddress" cssClass="error"/><br>


    <select name="user" multiple="multiple">
        <c:forEach items="${users}" var="user">
            <option value="${user.id}">${user.login}</option>
        </c:forEach>
    </select>


    <input type="submit" value="Save">
</form:form>

</body>
</html>
