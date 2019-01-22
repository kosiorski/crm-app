<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!doctype html>
<html lang="en">

<head>

    <title>Login Page</title>


</head>

<body>

<form:form action="/registration" method="get">
    <button type="Submit">Go To Registration Page</button>
</form:form>

<form:form action="/login" method="POST">

    <c:if test="${param.error != null}">
        <div style="color: red">
            Invalid username or password.
        </div>
    </c:if>

    <c:if test="${param.logout != null}">
        <div style="color: green">
            You have been logged out.
        </div>
    </c:if>
    <br/>

    <input type="text" id="login" name="login" placeholder="Login"><br/>

    <input type="password" placeholder="Password" name="password"/> <br/>


    <button type="submit">Login</button>
</form:form>

</body>
</html>