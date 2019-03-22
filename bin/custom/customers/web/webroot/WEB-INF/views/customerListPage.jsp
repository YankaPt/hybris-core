<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customers</title>
</head>
<body>
<h1>Customer List</h1>
<table>
    <thead>
        <tr>
            <th>UID</th>
            <th>Customer Id</th>
            <th>Sports</th>
            <th>Quantity of Sport</th>
        </tr>
    </thead>
<c:forEach var="customer" items="${customers}">
    <tr>
        <th>${customer.uid}</th>
        <th>${customer.customerId}</th>
        <th><c:forEach var="sport" items="${customer.sports}">
            ${sport.name}
        </c:forEach> </th>
        <th>${customer.quantityOfSport}</th>
    </tr>
</c:forEach>
</table>
</body>
</html>
