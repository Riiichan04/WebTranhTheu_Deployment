
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<jsp:include page="../common.jsp"/>--%>
<html>
<head>
<%--    <title>Danh sách yêu thích</title>--%>
<%--    <%@include file="../public/library.jsp" %>--%>
<%--    <!-- css property -->--%>
<%--    <link rel="stylesheet" href="../../template/style/user/account-page.css">--%>
</head>
<body>
<div id="user-wishlist" class=" content-details col">
    <div class="h3 p-3">Danh sách yêu thích</div>
    <hr>
    <div class="container p-3">
        <button type="button" class="addAll-btn">Thêm tất cả vào giỏ hàng</button>
        <!--Từng sản phẩm-->
        <c:if test="${empty wishlist}">
            <h4>Chưa có sản phẩm</h4>
        </c:if>
        <div class="row p-4 border shop">
            <c:forEach items="${wishlist}" var="product">
                <div class="row product-item p-2">
                    <!--Hình tỉ lệ 4:1-->
                    <div class="col-3"><img src="<c:url value="${product.product.getThumbnail()}"/>" alt="Artwork"
                                            class="resized-image"
                                            style="width: 148px;height: 97px"></div>
                    <div class="col-4 container">
                        <div class="row product-title">${product.product.title}</div>
                        <div class="row pt-4">${product.product.getMinPrice().price}</div>
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
    </div>
</div>
<%--<script src="template/script/header.js"></script>--%>
<%--<script src="template/script/account.js"></script>--%>
</body>
</html>
