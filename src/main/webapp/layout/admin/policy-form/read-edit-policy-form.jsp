<%--
  Created by IntelliJ IDEA.
  User: MINH THU
  Date: 12/23/2024
  Time: 1:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Xem và Sửa thông tin chính sách</title>
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
</head>
<body>
<!-- Form container -->
<div id="formContainer">
    <!-- enter code -->
    <form class="form-container">
        <div class="row pt-3">
            <div class="col"><h2 class="style-big-title" id="title">Xem chính sách</h2></div>
        </div>
        <!-- tên chính sách -->
        <div class="row pt-3">
            <div class="col"><span class="style-title">Tên chính sách</span></div>
        </div>
        <div class="row pt-2">
            <div class="col p-0"><input type="text" id="namePolicy" class="w-100 style-input" placeholder="Nhập tên chính sách" value="Chính sách chống hàng giả" required disabled>
            </div>
        </div>
        <!-- mô tả -->
        <div class="row pt-3">
            <div class="col"><span class="style-title">Mô tả chính sách</span></div>
        </div>
        <div class="row pt-2">
            <div class="col p-0"><textarea class="w-100 style-area" id="descriptionPolicy" placeholder="Nhập mô tả chính sách" required disabled>Mô tả chính sách này</textarea></div>
        </div>
        <!-- ds sản phẩm áp dụng chính sách -->
        <div class="row pt-2">
            <div class="col"><span class="style-title" id="titleProductApplyPolicy">Sản phẩm áp dụng chính sách</span></div>
        </div>
        <div class="row pt-2">
            <div class="col p-0">
                <select class="style-select-many" id="listProduct" name="products" multiple disabled>
                    <option>Tranh thêu phong cảnh</option>
                    <option>Tranh thêu phong cảnh</option>
                    <option>Tranh thêu phong cảnh</option>
                    <option>Tranh thêu phong cảnh</option>
                    <option>Tranh thêu phong cảnh</option>
                    <option>Tranh thêu phong cảnh</option>
                    <option>Tranh thêu phong cảnh</option>
                    <option>Tranh thêu phong cảnh</option>
                    <option>Tranh thêu phong cảnh</option>
                    <option>Tranh thêu phong cảnh</option>
                    <option>Tranh thêu phong cảnh</option>
                    <option>Tranh thêu phong cảnh</option>
                    <option>Tranh thêu phong cảnh</option>
                    <option>Tranh thêu phong cảnh</option>
                    <option>Tranh thêu phong cảnh</option>
                    <option>Tranh thêu phong cảnh</option>
                </select>
            </div>
        </div>
        <!-- thêm sp áp dụng chính sách -->
        <div class="row pt-2 d-none edit-hidden">
            <div class="col"><span class="style-title">Thêm sản phẩm áp dụng chính sách (Chọn nhiều)</span></div>
        </div>
        <div class="row pt-2 d-none edit-hidden">
            <div class="col p-0">
                <select class="style-select-many" name="products" multiple>
                    <option>Tranh thêu phong cảnh</option>
                    <option>Tranh thêu phong cảnh</option>
                    <option>Tranh thêu phong cảnh</option>
                    <option>Tranh thêu phong cảnh</option>
                    <option>Tranh thêu phong cảnh</option>
                    <option>Tranh thêu phong cảnh</option>
                    <option>Tranh thêu phong cảnh</option>
                    <option>Tranh thêu phong cảnh</option>
                    <option>Tranh thêu phong cảnh</option>
                    <option>Tranh thêu phong cảnh</option>
                    <option>Tranh thêu phong cảnh</option>
                    <option>Tranh thêu phong cảnh</option>
                    <option>Tranh thêu phong cảnh</option>
                    <option>Tranh thêu phong cảnh</option>
                    <option>Tranh thêu phong cảnh</option>
                    <option>Tranh thêu phong cảnh</option>
                </select>
            </div>
        </div>
        <!-- ngày tạo -->
        <div class="row pt-3">
            <div class="col"><span class="style-title">Ngày tạo chính sách</span></div>
        </div>
        <div class="row pt-2">
            <div class="col p-0"><input type="date" class="w-100 style-input" value="2024-10-30" required disabled></div>
        </div>
        <!-- ngày cập nhật -->
        <div class="row pt-3">
            <div class="col"><span class="style-title">Ngày cập nhật chính sách</span></div>
        </div>
        <div class="row pt-2">
            <div class="col p-0"><input type="date" class="w-100 style-input" disabled></div>
        </div>

        <div class="row pt-4 pb-4">
            <div class="col" id="containerCancelBtn">
                <button id="cancelBtn" class="style-cancel-btn">Hủy</button>
            </div>
            <div class="col" id="containerEditBtn">
                <button class="style-button" id="editBtn">Chỉnh sửa</button>
            </div>
        </div>
    </form>

    <!-- khi bấm nút chỉnh sửa thì hiện ra 2 select gồm select chứa sản phẩm áp dụng chính sách
và select còn lại chứa các sản phẩm không áp dụng chính sách đó (có thể thêm sp áp dụng chính sách) -->

</div>

<script src="../../script/admin/policy-form/read-edit-policy-form.js"></script>
<script src="../../script/admin/js-get-height-form.js"></script>
</body>
</html>
