<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link href="<c:out value="/resources/css/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>

<div id="registrationForm">

<strong>Register Form</strong>

<sf:form method="post" commandName="spitter">
    <%--<sf:errors path="*" element="div" cssClass="error"/>--%>
    <table>
        <tr class="border_bottom">
            <td>
                <sf:label path="firstName" cssErrorClass="error">First Name</sf:label>
            </td>
            <td>
                <sf:input path="firstName" cssErrorClass="error"/>
            </td>
            <td>
                <sf:errors path="firstName" cssClass="error"/>
            </td>
        </tr>

        <tr class="border_bottom">
            <td>
                Last Name
            </td>
            <td>
                <sf:input path="lastName"/>
            </td>
            <td>
                <sf:errors path="lastName" cssClass="error"/>
            </td>
        </tr>
        <tr class="border_bottom">
            <td>
                Username
            </td>
            <td>
                <sf:input path="username"/>
            </td>
            <td>
                <sf:errors path="username" cssClass="error"/>
            </td>
        </tr>
        <tr class="border_bottom">
            <td>
                Password
            </td>
            <td>
                <sf:password path="password"/>
            </td>
            <td>
                <sf:errors path="password" cssClass="error"/>
            </td>
        </tr>
    </table>
    <input type="submit" value="Register">
</sf:form>

</div>

</body>
</html>
