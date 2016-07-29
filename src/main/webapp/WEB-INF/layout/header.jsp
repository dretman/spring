<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<%--<c:if test="${principal!='anonymousUser'}">--%>
<%----%>
<%--</c:if>--%>

<security:authorize access="isAuthenticated() and principal.username=='habuma'">
    <security:authentication property="principal" var="principal"/>
    <h3>Hello <c:out value="${principal.username}"/></h3>
    <p>
        <a href="/picture">Link to the pic</a>
    </p>
</security:authorize>

header