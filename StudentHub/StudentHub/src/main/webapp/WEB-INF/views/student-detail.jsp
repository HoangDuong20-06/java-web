<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 07/04/2026
  Time: 00:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Chi tiết sinh viên</h2>

<p>ID: ${student.id}</p>
<p>Mã SV: ${student.studentCode}</p>
<p>Họ tên: ${student.fullName}</p>
<p>Khoa: ${student.faculty}</p>
<p>Năm: ${student.enrollmentYear}</p>
<p>GPA: ${student.gpa}</p>
<p>Trạng thái: ${student.status}</p>

<br/>

<button style="cursor: pointer" onclick="window.location.href='${pageContext.request.contextPath}/students'">Quay lại trang danh sách sinh viên</button>
</body>
</html>
