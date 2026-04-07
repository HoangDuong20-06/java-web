<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
  <title>Đăng nhập hệ thống - Mini Portal</title>
  <style>
    .error-msg { color: red; margin-bottom: 10px; }
    .login-box { border: 1px solid #ccc; width: 300px; padding: 20px; margin: 50px auto; }
  </style>
</head>
<body>

<div class="login-box">
  <h1>Đăng nhập</h1>
  <c:if test="${not empty errorMessage}">
    <p class="error-msg">
      <c:out value="${errorMessage}" />
    </p>
  </c:if>
  <form action="<c:url value='/loginbai5'/>" method="post">
    <table border="0">
      <tr>
        <td>Tài khoản:</td>
        <td><input type="text" name="username" required></td>
      </tr>
      <tr>
        <td>Mật khẩu:</td>
        <td><input type="password" name="password" required></td>
      </tr>
      <tr>
        <td></td>
        <td>
          <button type="submit">Đăng nhập</button>
        </td>
      </tr>
    </table>
  </form>

  <div style="margin-top: 15px; font-size: 0.8em; color: #666;">
    <p>Gợi ý Manager: manager123 / 123456</p>
    <p>Gợi ý Staff: staff / staff456</p>
  </div>
</div>

</body>
</html>