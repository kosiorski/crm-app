<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!doctype html>
<html lang="en">

<head>

    <title>Registration Page</title>

</head>

<body>

<form:form action="/login" method="get">
    <button type="Submit">Go To Login Page</button>
</form:form>

<form:form action="/registration" method="POST">

    <c:if test="${param.error != null}">
        <div style="color: red">
            Invalid data.
        </div>
    </c:if>

    <br/>

    <input type="text" id="login" name="login" placeholder="Login"><br/>

    <input type="password" placeholder="Password" name="password"/> <br/>

    <input type="text" placeholder="First Name" name="firstName"/> <br/>

    <input type="text" placeholder="Last Name" name="lastName"/> <br/>

    <input type="email" placeholder="Email" name="email"/> <br/>

    <button type="submit">Register</button>

</form:form>

</body>
</html>