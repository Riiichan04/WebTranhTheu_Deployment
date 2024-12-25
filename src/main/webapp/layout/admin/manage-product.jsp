<%--
  Created by IntelliJ IDEA.
  User: MINH THU
  Date: 12/23/2024
  Time: 1:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quản lý người dùng</title>
    <%@include file="../public/library.jsp"%>
    <!-- css property -->
    <link rel="stylesheet" href="../../template/style/admin/general-content-admin.css">
    <link rel="stylesheet" href="../../template/style/admin/manage-product.css">
    <link rel="stylesheet" href="../../template/style/admin/display-form-admin.css">
    <!-- datatable -->
    <link href="https://cdn.datatables.net/v/dt/dt-2.1.8/datatables.min.css" rel="stylesheet">
    <script src="https://cdn.datatables.net/v/dt/dt-2.1.8/datatables.min.js"></script>

</head>
<body>
<div class="container-fluid">
    <div class="row mt-3 mb-2">
        <div class="col"><h3 class="style-title">Quản lý sản phẩm</h3></div>
        <div class="col text-end mt-3 me-4">
            <button class="btn-add" id="addProductBtn"><i class="fa-solid fa-plus me-2"></i>Thêm sản phẩm</button>
        </div>
    </div>
    <div class="row">
        <table id="myTable" class="display custom-table w-100">
            <thead>
            <tr class="head-table">
                <th>STT</th>
                <th>Mã sản phẩm</th>
                <th>Tên tranh</th>
                <th>Hình ảnh</th>
                <th>Số lượng tồn kho</th>
                <th>Đánh giá tổng (<span
                        style="color: #e9f1ec">★</span>)/Số lượng</th>
                <th>Tiện ích</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>1</td>
                <td>SP01</td>
                <td>Tranh thêu tay Phố cổ Hà Nội</td>
                <td>
                    <div class="img-container"><img src="https://www.thegioitranhtheu.com/media/catalog/product/cache/1/small_image/9df78eab33525d08d6e5fb8d27136e95/f/i/file_7_35.jpg"></div>
                </td>
                <td>6</td>
                <td>4.5/2</td>
                <td>
                    <button class="btn-read-edit">Xem và Chỉnh Sửa</button>
                    <button class="btn-delete">Tắt</button>
                </td>
            </tr>
            <tr>
                <td>2</td>
                <td>SP01</td>
                <td>Tranh thêu tay Cao cấp Hồ Gươm</td>
                <td>
                    <div class="img-container"><img src="https://www.thegioitranhtheu.com/media/catalog/product/cache/1/small_image/9df78eab33525d08d6e5fb8d27136e95/f/i/file_7_35.jpg"></div>
                </td>
                <td>4</td>
                <td>4.8/2</td>
                <td>
                    <button class="btn-read-edit">Xem và Chỉnh Sửa</button>
                    <button class="btn-delete">Tắt</button>
                </td>
            </tr>
            <tr>
                <td>3</td>
                <td>SP01</td>
                <td>Tranh thêu tay Mã đáo thành công</td>
                <td>
                    <div class="img-container"><img src="https://www.thegioitranhtheu.com/media/catalog/product/cache/1/small_image/9df78eab33525d08d6e5fb8d27136e95/f/i/file_7_35.jpg"></div>
                </td>
                <td>2</td>
                <td>4.9/2</td>
                <td>
                    <button class="btn-read-edit">Xem và Chỉnh Sửa</button>
                    <button class="btn-delete">Tắt</button>
                </td>
            </tr>

            </tbody>
        </table>
    </div>
</div>

<div id="formWrapper" class="hidden mx-auto"></div>

<script src="../../template/script/admin/manage-adminpage.js"></script>
<%--<script src="../../template/script/admin/change-product-form.js"></script>--%>
</body>
</html>
