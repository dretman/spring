<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link href="<c:out value="/resources/css/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>

<strong>Register Form</strong>

<form method="post">
    First Name:<input type="text" name="firstName"><br/>
    Last Name:<input type="text" name="lastName"><br/>
    Username:<input type="text" name="username"><br/>
    Password:<input type="password" name="password"><br/>
    <input type="submit" value="Register">
</form>

</body>
</html>
