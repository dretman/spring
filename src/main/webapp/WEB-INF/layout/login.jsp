<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>--%>

<%--<div>--%>

    <%--<strong>Register Form</strong>--%>

    <%--<sf:form method="post" action="/login">--%>

        <%--&lt;%&ndash;&lt;%&ndash;<sf:errors path="*" element="div" cssClass="error"/>&ndash;%&gt;&ndash;%&gt;--%>
        <%--<table>--%>
            <%--<tr class="border_bottom">--%>
                <%--<td>--%>
                    <%--<sf:label path="username" cssErrorClass="error">User</sf:label>--%>
                <%--</td>--%>
                <%--<td>--%>
                    <%--<sf:input path="username" cssErrorClass="error"/>--%>
                <%--</td>--%>
                <%--<td>--%>
                    <%--<sf:errors path="username" cssClass="error"/>--%>
                <%--</td>--%>
            <%--</tr>--%>

            <%--<tr class="border_bottom">--%>
                <%--<td>--%>
                    <%--Password--%>
                <%--</td>--%>
                <%--<td>--%>
                    <%--<sf:password path="password"/>--%>
                <%--</td>--%>
                <%--<td>--%>
                    <%--<sf:errors path="password" cssClass="error"/>--%>
                <%--</td>--%>
            <%--</tr>--%>
        <%--</table>--%>
        <%--<input type="submit" value="Register">--%>
    <%--</sf:form>--%>

<%--</div>--%>

<c:url value="/login" var="loginUrl"/>
<form action="${loginUrl}" method="post">
    <c:if test="${param.error != null}">
        <p>
            Invalid username and password.
        </p>
    </c:if>
    <c:if test="${param.logout != null}">
        <p>
            You have been logged out.
        </p>
    </c:if>
    <p>
        <label for="username">Username</label>
        <input type="text" id="username" name="username"/>
    </p>
    <p>
        <label for="password">Password</label>
        <input type="password" id="password" name="password"/>
    </p>
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
    <button type="submit" class="btn">Log in</button>
</form>