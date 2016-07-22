<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<div id="registrationForm">

    <strong>Register Form</strong>

    <sf:form method="post" commandName="spitter" enctype="multipart/form-data">
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
            <tr class="border_bottom">
                <td>
                    Profile Picture
                </td>
                <td>
                    <input type="file"
                           name="profilePicture"
                           accept="image/jpeg,image/png,image/gif"/>
                </td>
                <td>

                </td>
            </tr>
        </table>
        <input type="submit" value="Register">
    </sf:form>

</div>