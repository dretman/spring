<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<div id="registrationForm">

    <strong>Add Apittle Form</strong>

    <sf:form method="post" commandName="spittle">
        <table>
            <tr class="border_bottom">
                <td>
                    <sf:input path="message"/>
                </td>
            </tr>
        </table>
        <input type="submit" value="Add Spittle">
    </sf:form>

</div>