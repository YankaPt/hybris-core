<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sports</title>
</head>
<body>
<h1>Sport List</h1>
<table>
    <thead>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>products</th>
    </tr>
    </thead>
    <c:forEach var="sport" items="${sports}">
        <tr>
            <th>${sport.id}</th>
            <th>${sport.name}</th>
            <th>${sport.products.size()} </th>
        </tr>
    </c:forEach>
</table>
</body>
</html>
