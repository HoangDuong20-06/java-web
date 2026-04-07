<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- Khai báo thư viện Jakarta cho Tomcat 10+ --%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<html>
<head>
    <title>Danh sách đơn hàng</title>
    <style>
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { border: 1px solid #ccc; padding: 12px; text-align: left; }
        th { background-color: #f4f4f4; }
        tr:nth-child(even) { background-color: #fafafa; }
        .amount { color: #d32f2f; font-weight: bold; }
        .footer-info { margin-top: 20px; font-style: italic; color: #555; }
    </style>
</head>
<body>

<h2>Xin chào, <span style="color: blue;">${sessionScope.loggedUser}</span>!
    Vai trò: <strong>${sessionScope.role}</strong>
</h2>

<table>
    <thead>
    <tr>
        <th>Mã đơn</th>
        <th>Sản phẩm</th>
        <th style="text-align: right;">Tổng tiền</th>
        <th>Ngày đặt</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${order}" var="o">
        <tr>
            <td>${o.id}</td>
            <td>${o.productName}</td>
            <td class="amount" style="text-align: right;">
                <fmt:formatNumber value="${o.amount}" maxFractionDigits="0" />VNĐ
            </td>
            <td>
                <fmt:formatDate value="${o.orderDate}" pattern="dd/MM/yyyy"/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="footer-info">
    <p>Tổng lượt xem toàn hệ thống: <strong>${applicationScope.totalViewCount}</strong></p>
    <a href="<c:url value='/logout'/>" style="color: red; text-decoration: none;">[ Đăng xuất ]</a>
</div>

</body>
</html>