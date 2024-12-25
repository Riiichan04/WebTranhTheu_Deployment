<%--
  Created by IntelliJ IDEA.
  User: MINH THU
  Date: 12/23/2024
  Time: 1:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quản lý danh mục</title>
    <%@include file="../public/library.jsp"%>
    <!-- css property -->
    <link rel="stylesheet" href="../../template/style/admin/general-content-admin.css">
    <link rel="stylesheet" href="../../template/style/admin/display-form-admin.css">
    <!-- datatable -->
    <link href="https://cdn.datatables.net/v/dt/dt-2.1.8/datatables.min.css" rel="stylesheet">
    <script src="https://cdn.datatables.net/v/dt/dt-2.1.8/datatables.min.js"></script>

</head>
<body>
<div class="container-fluid">
    <div class="row mt-3 mb-2">
        <div class="col"><h3 class="style-title">Quản lý danh mục</h3></div>
        <div class="col text-end mt-3 me-4">
            <button class="btn-add" id="addCategoryBtn"><i class="fa-solid fa-plus me-2"></i>Thêm danh mục</button>
        </div>
    </div>
    <div class="row">
        <table id="myTable" class="display custom-table w-100">
            <thead>
            <tr class="head-table">
                <th>STT</th>
                <th>Tên danh mục</th>
                <th>Số lượng sản phẩm trong danh mục</th>
                <th>Số lượng sản phẩm đã bán</th>
                <th>Ngày tạo</th>
                <th>Tiện ích</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>1</td>
                <td>Tranh thêu phong cảnh</td>
                <td>1000</td>
                <td>1000</td>
                <td>12/12/2020</td>
                <td>
                    <button class="btn-read-edit">Xem và Chỉnh Sửa</button>
                    <button class="btn-delete">Tắt</button>
                </td>
            </tr>
            <tr>
                <td>2</td>
                <td>Tranh thêu tài lộc</td>
                <td>600</td>
                <td>1000</td>
                <td>12/12/2020</td>
                <td>
                    <button class="btn-read-edit">Xem và Chỉnh Sửa</button>
                    <button class="btn-delete">Tắt</button>
                </td>
            </tr>
            <tr>
                <td>3</td>
                <td>Tranh thêu phong thủy</td>
                <td>231</td>
                <td>1000</td>
                <td>12/12/2020</td>
                <td>
                    <button class="btn-read-edit">Xem và Chỉnh Sửa</button>
                    <button class="btn-delete">Tắt</button>
                </td>
            </tr>

            </tbody>
        </table>
    </div>
</div>

<div id="formWrapper" class="hidden"></div>

<script src="../../template/script/admin/manage-adminpage.js"></script>
<script src="../../template/script/admin/change-category-form.js"></script>
</body>
</html>
