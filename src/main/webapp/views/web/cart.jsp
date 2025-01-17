<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../../layout/common.jsp"/>
<html>
<head>
    <title>Cart</title>
    <link rel="stylesheet" href="../../template/style/user/cart.css">
    <jsp:include page="../../layout/public/library.jsp"/>
</head>
<body>
<jsp:include page="../../layout/public/header.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-8 cart">
            <div class="h3 pt-4 text-center">Giỏ hàng</div>
            <div class="row cart-title px-4">
                <div class="col-3 form-check">
                    <input class="form-check-input" type="checkbox" id="checkAll">
                    <label class="form-check-label" for="checkAll">
                        Chọn tất cả
                    </label>
                </div>
                <div class="col-3 text-center">Sản phẩm</div>
                <div class="col-3 text-center">Số lượng</div>
                <div class="col-2">Giá tiền</div>
            </div>
            <hr/>
            <c:if test="${empty cart.products}">
                <h4>Chưa có sản phẩm</h4>
            </c:if>
            <div class="cart-item-list">
                <c:forEach items="${cart.products}" var="entry">
                <div class=" row py-3 cart-item">
                    <div class="col-1 text-center">
                        <div class="row pb-4"></div>
                        <div class="row ps-4">
                            <div class="form-check">
                                <input class="product-checkbox form-check-input" type="checkbox">
                            </div>
                        </div>
                    </div>
                    <img class="col-2" src="<c:url value="${entry.value.getThumbnail()}"/>">
                    <div class="col-3 ps-5 pe-0">
                        <div class="row">${entry.value.getTitle()}</div>
                        <div class="row pb-2"></div>
                        <div class="row">
                            <div class="col-5">${entry.value.price.width} X </div>
                            <div class="col-5">${entry.value.price.height}</div>
                        </div>
                    </div>
                    <div class="col-3 text-center">
                        <div class="row pb-4"></div>
                        <div class="row">
                            <div class="row">
                                <div class="col-4 text-center">
                                    <button class="rounded" id="product-detail__remove-amount" onclick="updateSubByQuantity(${entry.value.product.id},${entry.value.price.width},${entry.value.price.height})" >
                                        <i class="fa-solid fa-minus"></i>
                                    </button>
                                </div>
                                <div class="col-4 text-center" id="quantity_${entry.value.product.id}_${entry.value.price.width}_${entry.value.price.height}">
                                    ${entry.value.quantity}
                                </div>
                                <div class="col-4 text-center">
                                    <button class="rounded product-detail__add-amount" onclick="updatePlusByQuantity(${entry.value.product.id},${entry.value.price.width},${entry.value.price.height})">
                                        <i class="fa-solid fa-plus"></i>
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col p-0">
                        <div class="row pb-4 "></div>
                        <div class="row ps-3 product-detail__price">${entry.value.price.price}</div>
                    </div>
                    <div class="col-1 p-0">
                        <div class="row pb-4"></div>
                        <i class="bi bi-trash"></i>
                    </div>
                </div>
                </c:forEach>
            </div>
        </div>
        <div class="col-1"></div>
        <div class="col-3 ms-0 discount_pay">
            <div class="row discount_area p-3 py-4">
                <div class="row">
                    <div class="col-8 h5">
                        <i class="bi bi-ticket-perforated me-1"></i>
                        <span>Khuyến mãi</span>
                    </div>
                    <div class="col"></div>
                    <div class="col-2 row">
                        <i class="bi bi-arrow-right-short discount-more h4 my-0"></i>
                    </div>
                </div>
                <hr>
                <div class="discounts-list">
                    <div class="row ps-3 py-2 discount-item">
                        <div class="row discount-title h6">Mã giảm giá 10K - Áp dụng cho toàn sàn</div>
                        <div class="row p-0">
                            <div class=" col-8 discount-description">Đơn từ 10.000.000.</div>
                            <div class="col-4 discount-detail">Chi tiết</div>
                        </div>
                        <div class="row mt-2">
                            <button class="apply_discount">Áp dụng</button>
                        </div>
                    </div>
                    <div class="row ps-3 py-2 discount-item">
                        <div class="row discount-title h6">Mã giảm giá 10K - Áp dụng cho toàn sàn</div>
                        <div class="row p-0">
                            <div class=" col-8 discount-description">Đơn từ 10.000.000.</div>
                            <div class="col-4 discount-detail">Chi tiết</div>
                        </div>
                        <div class="row mt-2">
                            <button class="apply_discount">Áp dụng</button>
                        </div>
                    </div>
                    <div class="row ps-3 py-2 discount-item">
                        <div class="row discount-title h6">Mã giảm giá 10K - Áp dụng cho toàn sàn</div>
                        <div class="row p-0">
                            <div class=" col-8 discount-description">Đơn từ 10.000.000.</div>
                            <div class="col-4 discount-detail">Chi tiết</div>
                        </div>
                        <div class="row mt-2">
                            <button class="apply_discount">Áp dụng</button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row py-2"></div>
            <div class="row pay_area p-3">
                <div class="row pt-2">
                    <!--                    <div class="col-2 ps-4"></div>-->
                    <div class="col-10 h5"><i class="bi bi-cash-stack me-2"></i><span>Thành tiền</span></div>
                </div>
                <hr>
                <div class="row">
                    <div class="col-8 h6">Tổng số tiền (đã tính VAT):</div>
                    <div class="col-4" id="total-price" >${cart.getTotalPrice()}</div>
                </div>
                <div class="row ps-5 py-4 ">
                    <button class="payable rounded"><a href="../page/purchase.html" style="text-decoration: none;color: var(--web-background-color)">Thanh toán</a></button>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../../layout/public/footer.jsp"/>
<script src="../../template/script/header.js"></script>
<script src="../../template/script/cart.js"></script>
<script src="template/script/header.js"></script>

<script>
    const formatter_1= new Intl.NumberFormat('vi-VN', {
        style: 'currency',
        currency: 'VND',
    });
    function updatePlusByQuantity(q,w,h){
        console.log(q+'_'+w+'_'+h)
        productCode=q+'_'+w+'_'+h
        let quantityInput = $("div#quantity_" + productCode);
        let newQuantity= Number.parseInt(quantityInput.text(),10) + 1
        console.log(newQuantity)
        $.ajax({
            url:"/update-product?productCode=" + productCode + "&quantity=" + newQuantity,
            type:"GET",
            success:function(){
                console.log(newQuantity)
                quantityInput.text(newQuantity)
            } ,
            error:function (){

            }
        })
    }
    function updateSubByQuantity(q,w,h){
        console.log(q+'_'+w+'_'+h)
        productCode=q+'_'+w+'_'+h
        let quantityInput = $("div#quantity_" + productCode);
        let newQuantity= Number.parseInt(quantityInput.text(),10) - 1
        if(newQuantity<2){
            $("#product-detail__remove-amount").attr("disabled",true)
        }
        else{
            $("#product-detail__remove-amount").attr("disabled",false)
        }
        console.log(newQuantity)
        $.ajax({
            url:"/update-product?productCode=" + productCode + "&quantity=" + newQuantity,
            type:"GET",
            success:function(){
                console.log(newQuantity)
                quantityInput.text(newQuantity)
            } ,
            error:function (){

            }
        })
    }
    function format(){
        let totalPrice= ${cart.getTotalPrice()};
        $("#total-price").text(formatter_1.format(totalPrice + ""))
    }
</script>
</body>
</html>
