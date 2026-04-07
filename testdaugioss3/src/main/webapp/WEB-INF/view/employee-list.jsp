<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 4/7/2026
  Time: 2:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Danh sách nhân viên</title>
    <style>
        table { border-collapse: collapse; width: 50%; }
        th, td { border: 1px solid black; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Tên nhân viên</th>
        <th>Lương</th>
        <th>Đánh giá</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="emp" items="${employeeList}">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.fullName}</td>
            <td>${emp.salary}</td>
            <td>
                <c:choose>
                    <c:when test="${emp.salary >= 10000}">
                        <b style="color: green;">Mức lương cao</b>
                    </c:when>
                    <c:otherwise>
                        Mức lương cơ bản
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

