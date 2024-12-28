<%--
  Created by IntelliJ IDEA.
  User: MINH THU
  Date: 12/23/2024
  Time: 1:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Xem và Sửa thông tin khuyến mãi</title>
    <%@include file="../../public/library.jsp"%>
    <!-- css property -->
    <link rel="stylesheet" href="../../../template/style/admin/style-form/general-form.css">

</head>
<body>
<!-- Form container -->
<div id="formContainer">
    <!-- enter code -->
    <form class="form-container">
        <div class="row pt-3">
            <div class="col"><h2 class="style-big-title" id="title">Xem giảm giá</h2></div>
        </div>
        <!-- tiêu đề giảm giá -->
        <div class="row pt-2">
            <div class="col"><span class="style-title">Tiêu đề giảm giá</span></div>
        </div>
        <div class="row pt-2">
            <div class="col p-0"><input type="text" class="w-100 style-input" id="nameDiscount" placeholder="Nhập tiêu đề giảm giá" value="Giảm lễ 30/4" disabled>
            </div>
        </div>
        <!-- mô tả -->
        <div class="row pt-3">
            <div class="col"><span class="style-title">Mô tả giảm giá</span></div>
        </div>
        <div class="row pt-2">
            <div class="col p-0"><textarea class="w-100 style-area" id="description" placeholder="Nhập mô tả giảm giá" required disabled>Mô tả giảm giá này</textarea>
            </div>
        </div>

        <!-- giảm giá -->
        <div class="row pt-3">
            <div class="col"><span class="style-title">Giảm giá</span>
            </div>
        </div>
        <div class="row pt-2">
            <div class="col p-0">
                <table id="myPromotionEditTable" class="display custom-table w-100">
                    <thead>
                    <tr>
                        <th class="text-center">STT</th>
                        <th class="text-center">Mã sản phẩm</th>
                        <th class="text-center">Tên sản phẩm</th>
                        <th class="text-center">Phần trăm giảm (%)</th>
                        <th class="text-center">Số lượng giới hạn</th>
                        <th class="text-center d-none edit-hidden">Xóa</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>1</td>
                        <td>SP01</td>
                        <td>Tranh thêu sông nước</td>
                        <td><input type="number" class="percent-discount" value="10" style="width: 50px" disabled></td>
                        <td><input type="number" class="amount-limit" value="3" style="width: 50px" disabled></td>
                        <td class="d-none edit-hidden">
                            <input type="checkbox" style="width: 15px; height: 15px">
                        </td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>SP01</td>
                        <td>Tranh thêu sông nước</td>
                        <td><input type="number" class="percent-discount" value="10" style="width: 50px" disabled></td>
                        <td><input type="number" class="amount-limit" value="3" style="width: 50px" disabled></td>
                        <td class="d-none edit-hidden">
                            <input type="checkbox" style="width: 15px; height: 15px">
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>

        <!-- giảm giá từng sp -->
        <div class="row pt-3 d-none edit-hidden">
            <div class="col"><span class="style-title">Thêm sản phẩm giảm giá<i class="fas fa-plus-circle ms-2 style-add-btn" onclick="addProduct()"></i></span></div>
        </div>
        <div class="row pt-2 d-none edit-hidden">
            <div class="col p-0">
                <!-- Sản phẩm -->
                <div id="discounts">
                </div>
            </div>
        </div>

        <!-- Ngày bắt đầu -->
        <div class="row pt-3">
            <div class="col"><span class="style-title">Ngày bắt đầu giảm giá</span></div>
        </div>
        <div class="row pt-2">
            <div class="col p-0"><input type="datetime-local" class="w-100 style-input" id="startDateDiscount" value="2024-04-30T23:59" disabled></div>
        </div>
        <!-- kết thúc -->
        <div class="row pt-3">
            <div class="col"><span class="style-title">Ngày kết thúc giảm giá</span></div>
        </div>
        <div class="row pt-2">
            <div class="col p-0"><input type="datetime-local" class="w-100 style-input" id="endDateDiscount" value="2024-04-30T23:59" disabled></div>
        </div>
        <!-- Trạng thái -->
        <div class="row pt-3">
            <div class="col"><span class="style-title">Trạng thái</span></div>
        </div>
        <div class="row pt-2">
            <div class="col p-0">
                <select class="style-select" required disabled>
                    <option>Chưa kết thúc</option>
                    <option selected>Đã kết thúc</option>
                </select>
            </div>
        </div>
        <!-- ngày tạo -->
        <div class="row pt-3">
            <div class="col"><span class="style-title">Ngày tạo giảm giá</span>
            </div>
        </div>
        <div class="row pt-2">
            <div class="col p-0"><input type="datetime-local" class="w-100 style-input" value="2024-04-30T00:00" required disabled></div>
        </div>

        <div class="row pt-4 pb-4">
            <div class="col" id="containerCancelBtn">
                <button id="cancelBtn" class="style-cancel-btn">Hủy</button>
            </div>
            <div class="col" id="containerEditBtn">
                <button class="style-button" type="button" id="editBtn">Chỉnh sửa</button>
            </div>
        </div>
    </form>
</div>

<script src="../../../template/script/admin/promotion-form/read-edit-promotion-form.js"></script>
</body>
</html>
