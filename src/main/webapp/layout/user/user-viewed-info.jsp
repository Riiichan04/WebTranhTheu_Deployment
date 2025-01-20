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
    <div class="container p-3">
        <button type="button" class="addAll-btn">Thêm tất cả vào giỏ hàng</button>
        <!--Từng sản phẩm-->
        <div class="row p-4 mt-4 border shop">
            <div class="row title border-bottom px-4">tên sốp</div>
            <div class="row product-item p-2">
                <!--Hình tỉ lệ 4:1-->
                <div class="col-3"><img src="" alt="Artwork"
                                        class="resized-image">
                </div>
                <div class="col-4 container">
                    <div class="row product_title">Tranh thêu thám tử lừng danh Conan</div>
                    <div class="row pt-4">15.000.000đ</div>
                </div>
                <div class="col-2">
                    <button class="add-to-cart"><i class="bi bi-cart-plus"></i></button>
                </div>
                <div class="col-2">
                    <button class="delete-btn"><i class="bi bi-trash"></i></button>
                </div>
            </div>
        </div>
        <div class="row p-4 mt-4 border shop">
            <div class="row title border-bottom px-4">tên sốp</div>
            <div class="row product-item p-2">
                <!--Hình tỉ lệ 4:1-->
                <div class="col-3"><img src="" alt="Artwork"
                                        class="resized-image">
                </div>
                <div class="col-4 container">
                    <div class="row product-title">Tranh thêu thám tử lừng danh Conan</div>
                    <div class="row pt-4">15.000.000đ</div>
                </div>
                <div class="col-2">
                    <button class="add-to-cart"><i class="bi bi-cart-plus"></i></button>
                </div>
                <div class="col-2">
                    <button class="delete-btn"><i class="bi bi-trash"></i></button>
                </div>
            </div>
            <div class="row product-item p-2">
                <!--Hình tỉ lệ 4:1-->
                <div class="col-3"><img src="" alt="Artwork"
                                        class="resized-image">
                </div>
                <div class="col-4 container">
                    <div class="row product_title">Tranh thêu thám tử lừng danh Conan</div>
                    <div class="row pt-4">15.000.000đ</div>
                </div>
                <div class="col-2">
                    <button class="add-to-cart"><i class="bi bi-cart-plus"></i></button>
                </div>
                <div class="col-2">
                    <button class="delete-btn"><i class="bi bi-trash"></i></button>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="template/script/header.js"></script>
<script src="template/script/account.js"></script>
</body>
</html>
