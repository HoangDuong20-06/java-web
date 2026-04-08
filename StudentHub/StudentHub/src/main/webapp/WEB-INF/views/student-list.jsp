<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    .full-width-table {
        border-collapse: collapse;
        margin-top: 20px;
        width: 100%;
    }
    .full-width-table th, .full-width-table td {
        text-align: left;
        border-bottom: 1px solid #ddd;
    }
    .search-container {
        display: flex;
        gap: 15px;
        align-items: center;
        margin-bottom: 20px;
    }
</style>
<h2>Danh sách sinh viên</h2>
<form action="/students" method="get" class="search-container">
    <div>Tên: <input type="text" name="search" style="width: 200px;"/></div>
    <div>Khoa: <input type="text" name="faculty" style="width: 200px;"/></div>
    <button type="submit">Tìm</button>
</form>

<div class="mb-3">
    <button style="cursor: pointer" onclick="window.location.href='/students?sortBy=name'">Sắp xếp theo tên</button>
    <button style="cursor: pointer" onclick="window.location.href='/students?sortBy=gpa'">Sắp xếp theo điểm GPA</button>
</div>

<table class="full-width-table">
    <tr>
        <th style="background-color: #f2f2f2; padding: 12px;">STT</th>
        <th style="background-color: #f2f2f2; padding: 12px;">Mã SV</th>
        <th style="background-color: #f2f2f2; padding: 12px;">Họ tên</th>
        <th style="background-color: #f2f2f2; padding: 12px;">Khoa</th>
        <th style="background-color: #f2f2f2; padding: 12px;">Năm</th>
        <th style="background-color: #f2f2f2; padding: 12px;">GPA</th>
        <th style="background-color: #f2f2f2; padding: 12px;">Trạng thái</th>
        <th style="background-color: #f2f2f2; padding: 12px;">Action</th>
    </tr>
    <c:forEach var="s" items="${students}" varStatus="loop">
        <tr>
            <td style="padding: 12px;">${loop.count}</td>
            <td style="padding: 12px;">${s.studentCode}</td>
            <td style="padding: 12px;">${s.fullName}</td>
            <td style="padding: 12px;">${s.faculty}</td>
            <td style="padding: 12px;">${s.enrollmentYear}</td>
            <td style="padding: 12px;">${s.gpa}</td>

            <td style="padding: 12px;">
                <c:choose>
                    <c:when test="${s.status == 'Đang học'}">
                        <span style="color:green; font-weight: bold;">${s.status}</span>
                    </c:when>
                    <c:when test="${s.status == 'Bảo lưu'}">
                        <span style="color:orange; font-weight: bold;">${s.status}</span>
                    </c:when>
                    <c:when test="${s.status == 'Tốt nghiệp'}">
                        <span style="color:blue; font-weight: bold;">${s.status}</span>
                    </c:when>
                    <c:otherwise>
                        ${s.status}
                    </c:otherwise>
                </c:choose>
            </td>

            <td style="padding: 12px;">
                <button style="cursor: pointer" onclick="window.location.href='/students/detail?id=${s.id}'">Xem chi tiết</button>
            </td>
        </tr>
    </c:forEach>

    <c:if test="${not empty message}">
        <p style="color: red;">${message}</p>
    </c:if>
</table>

<br/>
<button style="cursor: pointer; padding: 10px 20px;" onclick="window.location.href='/dashboard'">Xem Báo cáo hệ thống</button>