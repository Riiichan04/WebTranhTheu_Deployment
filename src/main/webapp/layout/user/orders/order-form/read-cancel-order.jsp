<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
<!--Cancel order-->
<div id="user-cancel-order" class=" content-details col">
    <div class="row"><i class="backpage pt-4 bi bi-chevron-left">Trở lại</i></div>
    <div class="h3 fw-semibold p-4">Hủy đơn hàng</div>
    <hr/>
    <div class="card mt-4 container">
        <div class="row info-date">
            <div id="datetime" class="row mb-4">
                <div class="col-6"></div>
                <div class="col-3">
                    <div class="col">Ngày tạo: </div>
                    <div class="col date">${order.createdAt}</div>
                </div>
                <div class="col-3">
                    <div class="col">Ngày dự kiến giao: </div>
                    <div class="col date">${order.deliveredAt}</div></div>
            </div>
            <div class="row">
                <div class="row">${account.fullName}</div>
                <div class="row">${account.phone}</div>
                <div class="row">${order.shippingAddress}</div>
            </div>
        </div>
        <!--Danh sach sp trong 1 order-->
        <div class="row py-4 list-products">
                <c:forEach var="orderProduct" items="${order.products}">
                    <div id="product_${orderProduct.id}" class="row py-3">
                        <img src="${orderProduct.thumbnail}" class="resized-image col-3">
                        <div class="col container">
                            <div class="row title">${orderProduct.title}</div>
                            <div class="row">${orderProduct.quantity}</div>
                        </div>
                        <div class="price col-3 p-4">${orderProduct.price}</div>
                    </div>
                </c:forEach>
        </div>
    </div>
    <div class="reason">
        <div class="h5 mt-5">Lý do hủy đơn hàng?</div>
        <hr/>
        <div class="row"><p class="col-9">Tôi muốn đổi hình thức thanh toán.</p><input type="radio"
                                                                                       name="cancelReason"
                                                                                       value="1"
                                                                                       class="col-2 m-2"></div>
        <div class="row"><p class="col-9">Tôi muốn đổi địa chỉ nhận hàng.</p><input type="radio"
                                                                                    name="cancelReason"
                                                                                    value="2"
                                                                                    class="col-2 m-2"></div>
        <div class="row"><p class="col-9">Tôi muốn đổi sản phẩm.</p><input type="radio" name="cancelReason" value="3"
                                                                       class="col-2 m-2"></div>
        <div class="row"><p class="col-9">Tôi không có nhu cầu mua nữa.</p><input type="radio" name="cancelReason"
                                                                                  value="4"
                                                                                  class="col-2 m-2"></div>
        <div class="row"><p class="col-9">Thời gian giao hàng quá lâu.</p><input type="radio" name="cancelReason"
                                                                                 value="5"
                                                                                 class="col-2 m-2"></div>
        <div class="row"><p class="col-9">Tôi tìm thấy nội dung phù hợp hơn.</p><input type="radio"
                                                                                       name="cancelReason"
                                                                                       value="6"
                                                                                       class="col-2 m-2"></div>
    </div>
    <div class="row submit-cancel m-4">
        <div class="col-8"></div>
        <button class="col-4 submit-cancel-reason" onclick="cancelOrder(${order.id})">Gửi</button>
    </div>
</div>
<script>
    <c:forEach var="orderProduct" items="${order.products}">
    <%--console.log($("div#product_"+ ${orderProduct.id}).children("#orderProductPrice"))--%>
    formatPrice($("div#product_"+ ${orderProduct.id}).children(".price"))
    </c:forEach>
    $(".date").each(function (){
        formatDate($(this))
    })
    $(".bi-chevron-left").click(function () {
        $("#cancel-form").addClass("d-none")
        $("#user-ordered-list").removeClass("d-none")
    })
    function cancelOrder(orderId){
        let cancelReason= $("input[name='cancelReason']:checked").val()
        if(!cancelReason){
            alert("Chọn lý do hủy đơn")
        }
        $.ajax({
            url:"/confirm-cancel-order",
            type:"POST",
            data: {
                "orderId": orderId,
                "cancelReason": cancelReason
            },
            success: function (){
                $("#cancel-form").addClass("d-none")
                $("#user-ordered-list").removeClass("d-none")
                showMessageUpdate("Hủy đơn thành công")
            },
            error: function(xhr, status, error) {
                console.log("Lỗi:", status, error);
            }
        })
    }

</script>
</body>
</html>
