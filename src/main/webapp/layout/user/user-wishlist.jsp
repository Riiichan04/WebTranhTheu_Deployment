<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<jsp:include page="../common.jsp"/>--%>
<html>
<head>
    <%--    <link rel="stylesheet" href="../../template/style/user/account-page.css">--%>
</head>
<body>
<div id="user-wishlist" class=" content-details col">
    <div class="h3 p-3">Danh sách yêu thích</div>
    <hr>
    <c:if test="${empty account.wishProducts}">
        <h4>Chưa có sản phẩm</h4>
    </c:if>
    <c:if test="${not empty account.wishProducts}">
    <div class="container p-3">
        <button type="button" class="addAll-btn">Thêm tất cả vào giỏ hàng</button>
        <!--Từng sản phẩm-->
            <div class="row p-4 border shop">
                <c:forEach items="${account.wishProducts}" var="product">
                    <div id="${product.product.id}" class="row product-item p-2">
                        <!--Hình tỉ lệ 4:1-->
                        <img src="<c:url value="${product.product.getThumbnail()}"/>" alt="Artwork"
                                                class="resized-image col-3">
                        <div class="col-4 container">
                            <div class="row product-title">${product.product.title}</div>
                            <div class="row pt-4" id="minPrice">${product.product.getMinPrice().price}</div>
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
</div>

<%--<script src="template/script/header.js"></script>--%>
<%--<script src="template/script/account.js"></script>--%>
</body>
<script>
    function formatPriceWishlist(productId){
        let card;
        let product_price;
        let priceFormat;
        card= $("div#"+ productId)
        product_price= card.find("#minPrice")
        priceFormat= formatter.format(product_price.prop("innerText"))
        product_price.text(priceFormat+"")
    }
    <c:forEach var="product" items="${account.wishProducts}">
    formatPriceWishlist(${product.product.id})
    </c:forEach>
</script>
</html>
