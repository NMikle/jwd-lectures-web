<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Books</title>
</head>
<body>
<h2>Books list</h2>
<c:if test="${not empty requestScope.books}">
    <h2>Columns</h2>
    <ul>
        <c:forEach var="book" items="${requestScope.books}">
            <li>${book.name}</li>
        </c:forEach>
    </ul>
</c:if>
</body>
</html>
