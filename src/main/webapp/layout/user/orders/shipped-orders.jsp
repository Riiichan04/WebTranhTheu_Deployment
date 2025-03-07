<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<!--Shipped Orders-->
<div id="shippedlist" class=" order-details">
    <c:if test="${empty shipped}">
        <div class="h3 main-color opacity-50 d-flex justify-content-center align-items-center fw-semibold text-center">
            Trống
        </div>
    </c:if>
    <c:if test="${not empty shipped}">
        <c:forEach var="order" items="${shipped}">
            <!-- Card-->
            <div id="${order.id}" class="card container">
                <div class="row">
                    <div class="col-5"></div>
                    <div class="col-4 shipped">Giao hàng thành công</div>
                    <div class="col-3">
                        <c:choose>
                            <c:when test="${order.status == 1}">Chờ xác nhận</c:when>
                            <c:when test="${order.status == 2}">Chờ lấy hàng </c:when>
                            <c:when test="${order.status == 3}">Chờ giao hàng</c:when>
                            <c:when test="${order.status == 4}">Đã giao hàng</c:when>
                            <c:when test="${order.status == 5}">Đã nhận được hàng</c:when>
                            <c:when test="${order.status == 6}">Yêu cầu hoàn đơn - đổi trả</c:when>
                            <c:when test="${order.status == 0}">Đã hủy</c:when>
                            <c:otherwise> Trạng thái không xác định</c:otherwise>
                        </c:choose>
                    </div>
                </div>
                <hr>
                <!--Danh sach sp trong 1 orrder-->
                <div class="row py-4 list-products">
                    <c:forEach var="orderProduct" items="${order.products}">
                        <div id="product_${orderProduct.id}" class="row py-3">
                            <img src="${orderProduct.thumbnail}"
                                 class="resized-image col-3">
                            <div class="col text-start">
                                <div class="title h5 main-color">${orderProduct.title}</div>
                                <div class="p-0">Số lượng: <span class="fw-semibold">${orderProduct.quantity}</span>
                                </div>
                            </div>
                            <div id="productPrice" class="col-3 p-4">${orderProduct.price}</div>
                        </div>
                    </c:forEach>
                </div>
                <hr>
                <!-- Tổng tiền-->
                <div class="total row py-3">
                    <div class="col"></div>
                    <div class="col-3 title">
                        Thành tiền:
                    </div>
                    <div id="totalPrice" class="col-3">
                            ${order.totalPrice}
                    </div>
                </div>
                <!--Hủy hàng + Liên hệ chi tiết-->
                <div class="row py-2">
                    <div class="col"></div>
                    <div class="col-3">
                        <button type="button" class="received" onclick="updateOrderStatus(${order.id},5)">Đã nhận hàng
                        </button>
                    </div>
                </div>
            </div>
        </c:forEach>
    </c:if>
</div>
<script>
    <c:forEach var="order" items="${shipped}">
    formatPrice($("div#" +${order.id}).find(".total").find("#totalPrice"))
    <c:forEach var="orderProduct" items="${order.products}">
    formatPrice($("div#product_" +${orderProduct.id}).find("#productPrice"))
    </c:forEach>
    </c:forEach>
</script>
</body>
</html>
