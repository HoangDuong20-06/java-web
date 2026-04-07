<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<html>
<body>
<%@ include file="./header.jsp" %>
<h3>Chi tiết nhân viên: <c:out value="${emp.name}"/></h3>
<p>Mã: <c:out value="${emp.code}"/></p>
<p>Phòng ban: <c:out value="${emp.department}"/></p>
<p>Lương:
    <c:choose>
        <c:when test="${sessionScope.role == 'manager'}">
            <fmt:formatNumber value="${emp.salary}" pattern="#,### VNĐ"/>
        </c:when>
        <c:otherwise>***</c:otherwise>
    </c:choose>
</p>
<a href="<c:url value='/employees'/>">Quay lại</a>
</body>
</html>