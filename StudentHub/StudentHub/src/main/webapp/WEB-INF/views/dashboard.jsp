<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 07/04/2026
  Time: 00:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Báo cáo</h2>

<p>Tổng sinh viên: ${total}</p>
<p>GPA trung bình: ${avgGpa}</p>

<p>Thủ khoa: ${topStudent.fullName} (${topStudent.gpa})</p>

<h3>Phần trăm theo trạng thái</h3>

<c:forEach var="e" items="${percent}">
    <p>${e.key} : <fmt:formatNumber value="${e.value}" type="number" minFractionDigits="2" maxFractionDigits="2"/>%</p>
</c:forEach>

<button style="cursor: pointer" onclick="window.location.href='/students'">Quay lại trang danh sách sinh viên</button>
</body>
</html>
