<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 4/9/2026
  Time: 1:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>price</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${foodslist}">
        <tr>
            <td><c:out value="${item.getId()}"></c:out></td>
            <td>
                <c:out value="${item.getName()}"></c:out>
            </td>
            <td><c:out value="${item.getPrice()}"></c:out></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</form><h3>Thêm món mới</h3>
<form action="${pageContext.request.contextPath}/add" method="post">
    <label>ID:</label>
    <input type="number" name="id" required/><br/>

    <label>Name:</label>
    <input type="text" name="name" required/><br/>

    <label>Price:</label>
    <input type="number" step="0.01" name="price" required/><br/>

    <button type="submit">Add</button>
</form>

</body>
</html>