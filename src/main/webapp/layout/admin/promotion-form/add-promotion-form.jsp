<%--
  Created by IntelliJ IDEA.
  User: MINH THU
  Date: 12/23/2024
  Time: 1:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm giảm giá</title>
    <%@include file="../../public/library.jsp"%>
    <!-- css property -->
    <link rel="stylesheet" href="../../../template/style/admin/style-form/general-form.css">
    <link rel="stylesheet" href="../../../template/style/admin/style-form/style-add-promotion-form.css">

</head>
<body>
<!-- Form container -->
<div id="formContainer">
    <!--enter code -->
    <form class="form-container" id="add-promotion-form">
        <div class="row pt-3">
            <div class="col"><h2 class="style-big-title">Thêm giảm giá</h2></div>
        </div>
        <!-- tiêu đề giảm giá -->
        <div class="row pt-2">
            <div class="col"><span class="style-title">Tiêu đề giảm giá<span class="text-danger"> * </span></span></div>
        </div>
        <div class="row pt-2">
            <div class="col p-0"><input type="text" id="name-promotion" class="w-100 style-input" placeholder="Nhập tiêu đề giảm giá" required>
            </div>
        </div>
        <!-- mô tả -->
        <div class="row pt-3">
            <div class="col"><span class="style-title">Mô tả giảm giá<span class="text-danger"> * </span></span></div>
        </div>
        <div class="row pt-2">
            <div class="col p-0"><textarea id="description" class="w-100 style-area" placeholder="Nhập mô tả giảm giá" required></textarea>
            </div>
        </div>

        <!-- giảm giá -->
        <div class="row pt-3">
            <div class="col"><span class="style-title">Phần trăm giảm giá (%)<span class="text-danger"> * </span></span>
            </div>
        </div>
        <div class="row pt-2">
            <div class="col p-0"><input type="number" id="discount-value" class="w-100 style-input" name="value" placeholder="Nhập phần trăm giảm giá" required>
            </div>
        </div>


        <!-- Ngày bắt đầu, kết thúc giảm giá -->
        <div class="row pt-3">
            <div class="col"><span class="style-title">Ngày bắt đầu giảm giá</span></div>
            <div class="col"><span class="style-title">Ngày kết thúc giảm giá</span></div>
        </div>
        <div class="row pt-2">
            <div class="col p-0 pe-1"><input id="start-discount" type="datetime-local" class="w-100 style-input" id="startDateDiscount"></div>
            <div class="col p-0 ps-1"><input id="end-discount" type="datetime-local" class="w-100 style-input"></div>
        </div>

        <div class="row pt-4 pb-4">
            <div class="col">
                <button id="cancelBtn" class="style-cancel-btn">Hủy</button>
            </div>
            <div class="col">
                <button class="style-button" type="submit">Thêm giảm giá</button>
            </div>
        </div>
    </form>
</div>

</body>
</html>
