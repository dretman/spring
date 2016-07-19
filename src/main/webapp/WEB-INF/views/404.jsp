<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>404</title>
    <link rel="stylesheet"
          type="text/css"
          href="<c:url value="/resources/css/404.css" />">
</head>
<body>
<div>
    <h1>ERROR 404: NOT FOUND</h1>
    <img src="<c:url value="/resources/pic/${pic}.jpg"/>"/>
</div>

</body>
</html>
