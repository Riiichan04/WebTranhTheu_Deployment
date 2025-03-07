<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

</head>
<body>

<!--Pickup Orders (PAID)-->
<div id="pickedlist" class="order-details">
    <c:if test="${empty pickup}">
        <div class="h3 main-color opacity-50 d-flex justify-content-center align-items-center fw-semibold text-center">
            Trống
        </div>
    </c:if>
    <c:if test="${not empty pickup}">
        <c:forEach var="order" items="${pickup}">
            <!-- Card-->
            <div id="${order.id}" class="card border container">
                <div class="row">
                    <div class="col-9"></div>
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
                <div class="row py-4 list-products">
                    <c:forEach var="orderProduct" items="${order.products}">
                        <div id="product_${orderProduct.id}" class="row py-3">
                            <img src="${orderProduct.thumbnail}"
                                 class="resized-image col-3">
                            <div class="col text-start">
                                <div class="title h5 main-color">${orderProduct.title}</div>
                                <div class="p-0">Số lượng: <span class="fw-semibold">${orderProduct.quantity}</span> </div>
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
                <div class="row my-2">
                    <div class="col-5"></div>
                    <button type="button" class="cancel-btn col-3 me-2" onclick="getCancelForm(${order.id})">Hủy hàng
                    </button>
                    <button type="button" class="details-btn col-3" onclick="getDetailsForm(${order.id})">Chi
                        tiết
                    </button>
                </div>
            </div>
        </c:forEach>
    </c:if>
</div>
<script>
    <c:forEach var="order" items="${pickup}">
    formatPrice($("div#" +${order.id}).find(".total").find("#totalPrice"))
    <c:forEach var="orderProduct" items="${order.products}">
    formatPrice($("div#product_" +${orderProduct.id}).find("#productPrice"))
    </c:forEach>
    </c:forEach>
</script>
</body>
</html>
