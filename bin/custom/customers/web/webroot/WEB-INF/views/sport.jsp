<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sport</title>
</head>
<body>
<h1>Sport Details</h1>
<p><img src="${sport.imageURL}"/></p>
<p>${sport.id}</p>
<p>${sport.name}</p>
<table>
    <thead>
    <tr>
        <th>id</th>
        <th>name</th>
    </tr>
    </thead>
    <c:forEach var="product" items="${sport.products}">
        <tr>
            <th>${product.id}</th>
            <th>${product.name}</th>
        </tr>
    </c:forEach>
</table>
</body>
</html>
