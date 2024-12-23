<%--
  Created by IntelliJ IDEA.
  User: MINH THU
  Date: 12/23/2024
  Time: 1:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Xem và Sửa thông tin đơn hàng</title>
    <link rel="icon" href="../../asset/favicon/favicon.ico">
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <!-- FontAwesome -->
    <script src="https://kit.fontawesome.com/2643e782c1.js" crossorigin="anonymous"></script>
    <!-- JQuery -->
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <!-- css property -->
    <link rel="stylesheet" href="../../style/index.css">
    <link rel="stylesheet" href="../../style/admin/style-form/general-form.css">
    <link rel="stylesheet" href="../../style/admin/style-form/style-add-order-form.css">

</head>
<body>
<!-- Form container -->
<div id="formContainer">
    <!-- enter code -->
    <form class="form-container">
        <div class="row pt-3">
            <div class="col"><h2 class="style-big-title" id="title">Xem đơn hàng</h2></div>
        </div>
        <!-- tên đăng nhập của người dùng -->
        <div class="row pt-2">
            <div class="col"><span class="style-title">Tên đăng nhập người dùng</span></div>
        </div>
        <div class="row pt-2">
            <div class="col p-0"><input type="text" class="w-100 style-input" placeholder="Nhập tên đăng nhập người dùng" value="tho123" required disabled>
            </div>
        </div>
        <!-- sản phẩm mua -->
        <div class="row pt-3">
            <div class="col"><span class="style-title">Sản phẩm mua<i class="fas fa-plus-circle ms-2 style-add-btn d-none edit-hidden" onclick="addProduct()"></i></span></div>
        </div>
        <div class="row pt-2">
            <div class="col p-0">
                <!-- Sản phẩm -->
                <div id="products">
                    <div class="form-group product-row row mb-2">
                        <div class="col-6 pe-0">
                            <select class="w-100 style-select product-select" required disabled>
                                <option value="" disabled selected>Chọn sản phẩm</option>
                                <option value="product1">Sản phẩm 1</option>
                                <option value="product2">Sản phẩm 2</option>
                                <option value="product3">Sản phẩm 3</option>
                            </select>
                        </div>
                        <div class="col pe-0">
                            <input type="number" class="w-100 style-input amount-product-input" min="1" placeholder="Nhập số lượng" required disabled>
                        </div>
                        <div class="col-1 p-0 d-none edit-hidden">
                            <i class="fa-solid fa-trash icon-del" onclick="removeProduct(this)"></i>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Địa chỉ giao hàng -->
        <div class="row pt-3">
            <div class="col"><span class="style-title">Địa chỉ giao hàng</span>
            </div>
        </div>
        <div class="row pt-2">
            <div class="col p-0">
                <div class="row">
                    <div class="col"><select class="style-select" disabled>
                        <option selected>Việt Nam</option>
                    </select></div>
                    <div class="col">
                        <select class="style-select location" disabled>
                            <option disabled>--Chọn thành phố--</option>
                            <option>Tp. Hồ Chí Minh</option>
                            <option>Tp 2</option>
                            <option>Tp 3</option>
                            <option>Tp 4</option>
                            <option>Tp 5</option>
                            <option>Tp 6</option>
                            <option>Tp 7</option>
                        </select>
                    </div>
                </div>
                <div class="row pt-2">
                    <div class="col">
                        <select class="style-select location" disabled>
                            <option disabled>--Chọn quận/huyện--</option>
                            <option selected>Tp. Thủ Đức</option>
                            <option>Quận Bình Thạnh</option>
                            <option>Quận 1</option>
                            <option>Quận 3</option>
                            <option>Quận 4</option>
                        </select>
                    </div>
                    <div class="col">
                        <select class="style-select location" disabled>
                            <option disabled>--Chọn xã/phường--</option>
                            <option selected>Phường Linh Trung</option>
                            <option>Phường 2</option>
                            <option>Phường 3</option>
                            <option>Phường 4</option>
                            <option>Phường 5</option>
                            <option>Phường 6</option>
                            <option>Phường 7</option>
                        </select>
                    </div>
                </div>
                <div class="row pt-2" style="padding-left: 12px; padding-right: 12px">
                    <input type="text" class="style-input location" placeholder="Nhập tên đường, tòa nhà, số nhà,..."
                           value="Khu phố 6" disabled>
                </div>
            </div>
        </div>
        <!-- ngày tạo -->
        <div class="row pt-3">
            <div class="col"><span class="style-title">Ngày tạo đơn hàng</span>
            </div>
        </div>
        <div class="row pt-2">
            <div class="col p-0"><input type="date" class="w-100 style-input" value="2024-10-01" required disabled></div>
        </div>
        <!-- ngày giao hàng -->
        <div class="row pt-3">
            <div class="col"><span class="style-title">Ngày giao hàng</span>
            </div>
        </div>
        <div class="row pt-2">
            <div class="col p-0"><input type="date" id="dateDelivery" class="w-100 style-input" value="2024-10-02" disabled></div>
        </div>
        <!-- trạng thái đơn hàng -->
        <div class="row pt-3">
            <div class="col"><span class="style-title">Trạng thái đơn hàng</span>
            </div>
        </div>
        <div class="row pt-2">
            <div class="col p-0">
                <select class="style-select" id="statusOrder" required disabled>
                    <option>Đang xử lý</option>
                    <option>Đang giao</option>
                    <option>Đã hoàn thành</option>
                    <option selected>Đã hủy</option>
                </select>
            </div>
        </div>
        <!-- lí do hủy (nếu trạng thái là hủy) -->
        <div class="row pt-3 label-reason-cancel-order">
            <div class="col"><span class="style-title">Lí do hủy</span>
            </div>
        </div>
        <div class="row pt-2 select-reason-cancel-order">
            <div class="col p-0">
                <select class="style-select" id="reasonCancelOrder" required disabled>
                    <option>Lí do 1</option>
                    <option selected>Lí do 2</option>
                    <option>Lí do 3</option>
                    <option>Lí do 4</option>
                    <option>Lí do 5</option>
                    <option>Lí do 6</option>
                    <option>Lí do 7</option>
                    <option>Lí do 8</option>
                </select>
            </div>
        </div>
        <!-- trạng thái thanh toán -->
        <div class="row pt-3">
            <div class="col"><span class="style-title">Trạng thái thanh toán</span>
            </div>
        </div>
        <div class="row pt-2">
            <div class="col p-0">
                <select class="style-select payment-select" required disabled>
                    <option>Chưa thanh toán</option>
                    <option>Đã thanh toán</option>
                </select>
            </div>
        </div>

        <div class="row pt-4 pb-4">
            <div class="col" id="containerCancelBtn">
                <button type="button" id="cancelBtn" class="style-cancel-btn">Hủy</button>
            </div>
            <div class="col" id="containerEditBtn">
                <button type="button" class="style-button" id="editBtn">Chỉnh sửa</button>
            </div>
        </div>
    </form>
</div>

<script src="../../script/admin/order-form/add-product-order-form.js"></script>
<script src="../../script/admin/js-get-height-form.js"></script>
</body>
</html>
