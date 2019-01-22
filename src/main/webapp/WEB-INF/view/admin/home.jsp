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
    Welcome to the company home page for ADMINS!
</p>

<hr>

<p>
    User: <security:authentication property="principal.username"/>
    <br><br>
    Role(s): <security:authentication property="principal.authorities"/>
</p>

</body>
</html>









