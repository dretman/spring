<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>Your profile</h2>
<c:out value="${spitter.username}"/><br/>
<c:out value="${spitter.firstName}"/>
<c:out value="${spitter.lastName}"/>
