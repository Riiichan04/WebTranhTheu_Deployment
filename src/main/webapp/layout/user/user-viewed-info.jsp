<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common.jsp"/>
<html>
<head>
    <title>Lịch sử xem</title>
    <%@include file="../public/library.jsp" %>
    <!-- css property -->
    <link rel="stylesheet" href="../../template/style/user/account-page.css">
    <link rel="stylesheet" href="../../template/style/user/style-forms/viewed-info.css">
</head>
<body>
<div id="user-viewed-info" class="content-details col">
    <div class="h3 p-3">Lịch sử sản phẩm đã xem</div>
    <hr>
    <c:if test="${empty viewedHistory.viewedProducts}">
        <div class="h3 main-color opacity-50 d-flex justify-content-center align-items-center fw-semibold text-center">
            Bạn chưa xem sản phẩm nào
        </div>
    </c:if>
    <c:if test="${not empty viewedHistory.viewedProducts}">
        <div class="container p-3">
            <button type="button" class="addAll-btn">Thêm tất cả vào giỏ hàng</button>
            <!--Từng sản phẩm-->
            <c:forEach var="product" items="${viewedHistory.viewedProducts}">
                <div id="${product.id}" class="row product-item p-2" data-id="${product.id}" data-width="${product.getMinPrice().width}" data-height="${product.getMinPrice().height}">
                    <!--Hình tỉ lệ 4:1-->
                    <img src="<c:url value="${product.getThumbnail()}"/>" alt="Artwork"
                                            class="resized-image col-3">
                    <div class="col-4 container">
                        <div class="row product_title">${product.title}</div>
                        <div class="row pt-4" id="minPrice">${product.getMinPrice().price}</div>
                    </div>
                    <div class="col-2">
                        <button class="add-to-cart"><i class="bi bi-cart-plus"></i></button>
                    </div>
                    <div class="col-2">
                        <button class="delete-btn"><i class="bi bi-trash"></i></button>
                    </div>
                </div>
            </c:forEach>
        </div>
    </c:if>
</div>
<script src="template/script/header.js"></script>
<script src="template/script/account.js"></script>
<script>
    function formatPrice(productId){
        let card;
        let product_price;
        let priceFormat;
        card= $("div#"+ productId)
        product_price= card.find("#minPrice")
        priceFormat= formatterPrice.format(product_price.prop("innerText"))
        product_price.text(priceFormat+"")
    }
    <c:forEach var="product" items="${viewedHistory.viewedProducts}">
    formatPrice(${product.id})
    </c:forEach>
</script>
</body>
</html>
