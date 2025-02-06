<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<!--Order details info-->
<script>
    $(".bi-chevron-left").click(function () {
        $("#order-detail").addClass("d-none")
        $("#user-ordered-list").removeClass("d-none")
    })
    $(".date").each(function () {
        formatDate($(this))
    })
</script>
<div id="order-detail-info" class=" content-details col">
    <div class="row"><i class="backpage pt-4 bi bi-chevron-left">Trở lại</i></div>
    <div class="row">
        <div class="col-8 h3 fw-semibold px-4 pt-2 pb-2 ">Chi tiết đơn hàng</div>
        <div class="col-4 justify-content-center align-items-center text-center">
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
    <hr/>
    <c:if test="${order.status==5}">
        <div class="m-2 row rebuy-area">
            <div class="col-8">Cảm ơn quý khách đã tham gia mua sắm!</div>
            <button class="col-4 rebuy_btn" onclick="rebuyOrder(${order.id})">Mua lại</button>
        </div>
    <hr/>
    </c:if>
    <div class="p-4 row">
        <div class="row">
            <div class="col-6 h5 fw-semibold">Địa chỉ nhận hàng</div>
            <div class="col-6 text-end">Thông tin vận chuyển</div>

        </div>
        <div class="col-5 border-end">
            <div class="row h6 fw-semibold">${account.fullName}</div>
            <div class="row">
                ${account.phone}
                <br/>
                ${order.shippingAddress}
            </div>
        </div>
        <div class="col-7">
            <div class="row">
                <div class="col">Ngày tạo đơn hàng:</div>
                <div class="col date">${order.createdAt}</div>
            </div>
            <div class="row">
                <div class="col">Ngày giao:</div>
                <div class="col date">${order.deliveredAt}</div>
            </div>
            <div class="row">
                <div class="col">Phương thức thanh toán:</div>
                <div class="col">
                    <c:choose>
                        <c:when test="${order.method==1}">COD (Tiền mặt)</c:when>
                        <c:when test="${order.method==0}">Chuyển khoản</c:when>
                        <c:otherwise>Phương thức thanh toán không xác định</c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </div>
    <hr/>
    <div class="mt-4 container">
        <hr>
        <!--Danh sach sp trong 1 order-->
        <div class="row py-4 list-products">
            <c:forEach var="orderProduct" items="${order.products}">
                <div id="product_${orderProduct.id}" class="row py-3 ">
                    <img src="${orderProduct.thumbnail}" class="resized-image col-3">
                    <div class="col container">
                        <div class="row title">${orderProduct.title}</div>
                        <div class="row">${orderProduct.quantity}</div>
                    </div>
                    <div class="price col-3 p-4">${orderProduct.price}</div>
                </div>
            </c:forEach>
        </div>
        <hr/>
        <div class="row px-4 py-4 ">
            <div class="col-7 border-end">
                <div class="row">
                    <div class="col"></div>
                    <div class="col-5">Tổng tiền hàng:</div>
                </div>
                <hr/>
                <div class="row">
                    <div class="col"></div>
                    <div class="col-5">Phí vận chuyển:</div>
                </div>
                <hr/>
                <div class="row">
                    <div class="col"></div>
                    <div class="col-5">Giảm giá:</div>
                </div>
                <hr/>
                <div class="row">
                    <div class="col"></div>
                    <div class="col-5">Thành tiền:</div>
                </div>
                <hr/>
            </div>
            <div class="col-5 ps-3">
                <div id="totalPrice_${order.id}" class="row ps-5">${order.totalPrice}</div>
                <hr/>
                <p class="row ps-5">300000.0</p>
                <hr/>
                <p class="row ps-5">Chưa làm</p>
                <hr/>
            </div>
        </div>
        <hr/>
        <c:if test="${order.status==0}">
            <div class="row p-0 my-3">
                <div class="col-3"></div>
                <div class="col-4 border-end">Lý do hủy:</div>
                <div class="col-5">
                    <c:choose>
                        <c:when test="${order.cancelReason == 1}">Tôi muốn đổi hình thức thanh toán</c:when>
                        <c:when test="${order.cancelReason == 2}">Tôi muốn đổi địa chỉ nhận hàng </c:when>
                        <c:when test="${order.cancelReason == 3}">Tôi muốn đổi sản phẩm</c:when>
                        <c:when test="${order.cancelReason == 4}">Tôi không có nhu cầu mua nữa</c:when>
                        <c:when test="${order.cancelReason == 5}">Thời gian giao hàng quá lâu</c:when>
                        <c:when test="${order.cancelReason == 6}">Tôi tìm thấy nội dung phù hợp hơn</c:when>
                        <c:otherwise> Không xác định</c:otherwise>
                    </c:choose>
                </div>
            </div>
            <hr/>
        </c:if>
    </div>
</div>
<script>
    <c:forEach var="orderProduct" items="${order.products}">
    <%--console.log($("div#product_"+ ${orderProduct.id}).children("#orderProductPrice"))--%>
    formatPrice($("div#product_"+ ${orderProduct.id}).children(".price"))
    </c:forEach>
    function formatTotalPrice(){
        let formatPrice;
        formatPrice= formatter.format($("div#totalPrice_"+${order.id}).prop("innerText"))
        $("div#totalPrice_"+${order.id}).text(formatPrice+"")
    }
    formatTotalPrice()
</script>
</body>
</html>
