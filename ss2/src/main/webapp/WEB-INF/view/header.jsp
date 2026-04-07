<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<nav style="background: #333; color: white; padding: 10px;">
  <a href="<c:url value='/employees'/>" style="color:white">Danh sách</a> |
  <span>Xin chào, <c:out value="${sessionScope.loggedUser}"/> (<c:out value="${sessionScope.role}"/>)</span> |
  <a href="<c:url value='/logout'/>" style="color:yellow">Đăng xuất</a>
</nav>