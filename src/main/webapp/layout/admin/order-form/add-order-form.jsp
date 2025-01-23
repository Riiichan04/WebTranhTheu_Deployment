<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm đơn hàng</title>
    <%@include file="../../public/library.jsp"%>
    <!-- css property -->
    <link rel="stylesheet" href="../../../template/style/admin/style-form/general-form.css">
    <link rel="stylesheet" href="../../../template/style/admin/style-form/style-add-order-form.css">

</head>
<body>
<!-- Form container -->
<div id="formContainer">
    <!--enter code -->
    <form class="form-container">
        <div class="row pt-3">
            <div class="col"><h2 class="style-big-title">Thêm đơn hàng</h2></div>
        </div>
        <!-- tên đăng nhập của người dùng -->
        <div class="row pt-2">
            <div class="col"><span class="style-title">Tên đăng nhập người dùng<span class="text-danger"> * </span></span></div>
        </div>
        <div class="row pt-2">
            <div class="col p-0"><input type="text" class="w-100 style-input" placeholder="Nhập tên đăng nhập người dùng" required>
            </div>
        </div>
        <!-- sản phẩm mua -->
        <div class="row pt-3">
            <div class="col"><span class="style-title">Sản phẩm mua<span class="text-danger"> * </span><i class="fas fa-plus-circle ms-2 style-add-btn" onclick="addProduct()"></i></span></div>
        </div>
        <div class="row pt-2">
            <div class="col p-0">
                <!-- Sản phẩm -->
                <div id="products">
                    <div class="form-group product-row row mb-2">
                        <div class="col-6 pe-0">
                            <select class="w-100 style-select product-select" required>
                                <c:forEach items="${listProducts}" var="p">
                                <option value="${p.getId()}">${p.getCode()} - ${p.getTitle()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-5 pe-0">
                            <input type="number" class="w-100 style-input amount-product-input" min="1" placeholder="Nhập số lượng" required>
                        </div>
                        <div class="col-1 p-0">
                            <i class="fa-solid fa-trash icon-del" onclick="removeProduct(this)"></i>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- mã giảm giá -->
        <div class="row pt-3">
            <div class="col"><span class="style-title">Mã giảm giá<span class="text-danger"> * </span></span></div>
        </div>
        <div class="row pt-2">
            <div class="col p-0">
                <select class="w-100 style-select product-select" required>
                    <option value="" selected>---Chọn mã giảm giá---</option>
                    <c:forEach items="${discountValid}" var="d">
                    <option value="${d.getId()}">${d.getTitle()}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <!-- Địa chỉ giao hàng -->
        <div class="row pt-3">
            <div class="col"><span class="style-title">Địa chỉ giao hàng<span class="text-danger"> * </span></span>
            </div>
        </div>
        <div class="row pt-2">
            <div class="col p-0"><input type="text" class="w-100 style-input" placeholder="Nhập địa chỉ giao hàng" required></div>
        </div>

        <!-- ngày giao hàng -->
        <div class="row pt-3">
            <div class="col"><span class="style-title">Ngày giao hàng</span>
            </div>
        </div>
        <div class="row pt-2">
            <div class="col p-0"><input type="date" class="w-100 style-input"></div>
        </div>
        <!-- trạng thái đơn hàng -->
        <div class="row pt-3">
            <div class="col"><span class="style-title">Trạng thái đơn hàng<span class="text-danger"> * </span></span>
            </div>
        </div>
        <div class="row pt-2">
            <div class="col p-0">
                <select class="style-select" id="statusOrder" onclick="reasonCancelOrder()" required>
                    <option value="1">Chờ xác nhận</option>
                    <option value="2">Chờ lấy hàng</option>
                    <option value="3">Chờ giao hàng</option>
                    <option value="4">Đã giao</option>
                    <option value="5">Đã nhận hàng</option>
                    <option value="6">Đơn yêu cầu hoàn trả</option>
                </select>
            </div>
        </div>
        <!-- Lí do hủy (nếu trạng thái đơn hàng là hủy) -->
        <div class="row pt-3 d-none label-reason-cancel-order">
            <div class="col"><span class="style-title">Lí do hủy<span class="text-danger"> * </span></span>
            </div>
        </div>
        <div class="row pt-2 d-none select-reason-cancel-order">
            <div class="col p-0">
                <select class="style-select" required>
                    <option value="1">Lí do 1</option>
                    <option value="2">Lí do 2</option>
                    <option value="3">Lí do 3</option>
                    <option value="4">Lí do 4</option>
                    <option value="5">Lí do 5</option>
                    <option value="6">Lí do 6</option>
                    <option value="7">Lí do 7</option>
                    <option value="8">Lí do 8</option>
                </select>
            </div>
        </div>
        <!-- trạng thái thanh toán -->
        <div class="row pt-3">
            <div class="col"><span class="style-title">Trạng thái thanh toán<span class="text-danger"> * </span></span>
            </div>
        </div>
        <div class="row pt-2">
            <div class="col p-0">
                <select class="style-select" required>
                    <option value="0">Chưa thanh toán</option>
                    <option value="1">Đã thanh toán</option>
                </select>
            </div>
        </div>

        <div class="row pt-4 pb-4">
            <div class="col">
                <button id="cancelBtn" class="style-cancel-btn">Hủy</button>
            </div>
            <div class="col">
                <button class="style-button">Thêm đơn hàng</button>
            </div>
        </div>
    </form>
</div>

<script src="../../../template/script/admin/order-form/add-product-order-form.js"></script>
</body>
</html>
