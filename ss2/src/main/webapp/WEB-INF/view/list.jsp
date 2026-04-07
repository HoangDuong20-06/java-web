<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<html>
<body>
<%@ include file="./header.jsp" %>
<h2>Danh sách nhân viên</h2>
<table border="1" width="100%">
  <tr>
    <th>STT</th><th>Mã</th><th>Họ tên</th><th>Phòng ban</th><th>Lương</th><th>Ngày vào</th><th>Trạng thái</th><th>Thao tác</th>
  </tr>
  <c:forEach var="emp" items="${employees}" varStatus="status">
    <tr>
      <td>${status.count}</td>
      <td><c:out value="${emp.code}"/></td>
      <td><c:out value="${emp.name}"/></td>
      <td><c:out value="${emp.department}"/></td>
      <td><fmt:formatNumber value="${emp.salary}" pattern="#,### VNĐ"/></td>
      <td>
        <fmt:parseDate value="${emp.joinDate}" pattern="yyyy-MM-dd" var="pDate"/>
        <fmt:formatDate value="${pDate}" pattern="dd/MM/yyyy"/>
      </td>
      <td>
        <c:choose>
          <c:when test="${emp.status == 'Đang làm'}"><span style="color:green">●</span></c:when>
          <c:when test="${emp.status == 'Nghỉ phép'}"><span style="color:orange">●</span></c:when>
          <c:otherwise><span style="color:blue">●</span></c:otherwise>
        </c:choose>
        <c:out value="${emp.status}"/>
      </td>
      <td><a href="<c:url value='/employees/${emp.code}'/>">Xem chi tiết</a></td>
    </tr>
  </c:forEach>
</table>
<h4>Tổng lương phòng Kỹ thuật: <fmt:formatNumber value="${techTotalSalary}" pattern="#,### VNĐ"/></h4>
</body>
</html>