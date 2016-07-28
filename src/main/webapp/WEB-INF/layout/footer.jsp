<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<s:url value="/" var="home"/>
<s:url value="/logoutUrl" var="logout"/>

<a href="${home}">home</a>

<form action="${logout}" method="post">
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}" />
    <input type="submit" value="Logout">
</form>

footer
