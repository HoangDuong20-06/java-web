<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Đăng nhập hệ thống</title>
    <style>
        body { font-family: Arial, sans-serif; display: flex; justify-content: center; padding-top: 50px; }
        .login-card { border: 1px solid #ccc; padding: 20px; border-radius: 8px; width: 300px; box-shadow: 0 2px 5px rgba(0,0,0,0.1); }
        .error-msg { color: red; font-size: 14px; margin-bottom: 10px; }
        .form-group { margin-bottom: 15px; }
        input { width: 100%; padding: 8px; margin-top: 5px; box-sizing: border-box; }
        button { width: 100%; padding: 10px; background-color: #007bff; color: white; border: none; cursor: pointer; border-radius: 4px; }
        button:hover { background-color: #0056b3; }
    </style>
</head>
<body>

<div class="login-card">
    <h2 style="text-align: center;">Đăng nhập</h2>
    <c:if test="${not empty error}">
        <div class="error-msg">${error}</div>
    </c:if>

    <form action="<c:url value='/login'/>" method="post">
        <div class="form-group">
            <label>Tài khoản:</label>
            <input type="text" name="username" placeholder="admin hoặc staff" required>
        </div>

        <div class="form-group">
            <label>Mật khẩu:</label>
            <input type="password" name="password" placeholder="admin123 hoặc staff123" required>
        </div>

        <button type="submit">Đăng nhập</button>
    </form>

    <div style="margin-top: 15px; font-size: 12px; color: #666;">
        <p>Gợi ý: admin/admin123 hoặc staff/staff123</p>
    </div>
</div>

</body>
</html>