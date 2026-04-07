<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>Kết quả tìm kiếm sự kiện</title>
    <style>
        .badge { padding: 2px 5px; border-radius: 4px; color: white; font-weight: bold; }
        .free { background-color: green; }
        .sold-out { color: red; font-weight: bold; }
        .almost-out { color: orange; font-weight: bold; }
        .available { color: green; }
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid #ccc; padding: 5px; text-align: left; }
    </style>
</head>
<body>

<h2>Kết quả tìm kiếm cho: <c:out value="${keyword}"/></h2>

<p>
    <c:choose>
        <c:when test="${empty events}">
            Không tìm thấy sự kiện nào phù hợp.
        </c:when>
        <c:otherwise>
            Tìm thấy <c:out value="${fn:length(events)}"/> sự kiện.
        </c:otherwise>
    </c:choose>
</p>

<c:if test="${not empty events}">
    <table>
        <tr>
            <th>STT</th>
            <th>Tên sự kiện</th>
            <th>Ngày tổ chức</th>
            <th>Giá vé</th>
            <th>Vé còn lại</th>
            <th>Thao tác</th>
        </tr>

        <c:forEach var="event" items="${events}" varStatus="status">
            <tr>
                <td><c:out value="${status.count}"/></td>
                <td><c:out value="${event.name}"/></td>
                <td><c:out value="${event.eventDate}"/></td>
                <td>
                    <c:choose>
                        <c:when test="${event.price == 0}">
                            <span class="badge free">MIỄN PHÍ</span>
                        </c:when>
                        <c:otherwise>
                            <fmt:formatNumber value="${event.price}" type="currency" currencySymbol="₫"/>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${event.remainingTickets == 0}">
                            <span class="sold-out">HẾT VÉ</span>
                        </c:when>
                        <c:when test="${event.remainingTickets < 10}">
                            <span class="almost-out">Sắp hết (còn <c:out value="${event.remainingTickets}"/> vé)</span>
                        </c:when>
                        <c:otherwise>
                            <span class="available"><c:out value="${event.remainingTickets}"/></span>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:url var="bookUrl" value="/events/${event.id}/book"/>
                    <a href="${bookUrl}" <c:if test="${event.remainingTickets == 0}">style="pointer-events:none; color:gray;"</c:if>>Đặt vé</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<footer>
    <c:if test="${not empty events}">
        <p>Sự kiện đầu tiên: ${fn:toUpperCase(events[0].name)}</p>
    </c:if>
    <p>Độ dài từ khóa tìm kiếm: <c:out value="${fn:length(keyword)}"/> ký tự</p>
</footer>

</body>
</html>