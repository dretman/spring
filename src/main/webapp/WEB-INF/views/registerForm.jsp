<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link href="<c:out value="/resources/css/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>

<strong>Register Form</strong>

<sf:form method="post" commandName="spitter">
    First Name:<sf:input path="firstName"/><sf:errors path="firstName" cssClass="error"/> <br/>
    Last Name:<sf:input path="lastName"/><sf:errors path="lastName" cssClass="error"/><br/>
    Username:<sf:input path="username"/><sf:errors path="username" cssClass="error"/><br/>
    Password:<sf:password path="password"/><sf:errors path="password" cssClass="error"/><br/>
    <input type="submit" value="Register">
</sf:form>

</body>
</html>
