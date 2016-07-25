<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page session="false" %>

<s:url value="/spitter/register" var="registerUrl"/>
<s:url value="/spittles/spittle" var="addSpittelUrl"/>
<s:url value="/spittles" var="spittlesUrl">
    <s:param name="count" value="3"/>
</s:url>

<s:url value="/spitter/{username}" var="spitterProfileUrl">
    <s:param name="username" value="doesnotmatter"/>
</s:url>

<h1><s:message code="spittr.welcome"/></h1>

<a href="${spittlesUrl}">Spittles</a> |
<a href="${addSpittelUrl}">Add Spittle</a> |
<a href="${registerUrl}">Register</a> |
<a href="${spitterProfileUrl}">User profile</a>
<br>
<s:escapeBody htmlEscape="true">
    <h1>Hello World</h1>
</s:escapeBody>
