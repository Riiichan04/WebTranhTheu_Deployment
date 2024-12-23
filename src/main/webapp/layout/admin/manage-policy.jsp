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
    <title>Quản lý chính sách</title>
    <link rel="icon" href="../asset/favicon/favicon.ico">
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <!-- FontAwesome -->
    <script src="https://kit.fontawesome.com/2643e782c1.js" crossorigin="anonymous"></script>
    <!-- JQuery -->
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <!-- css property -->
    <link rel="stylesheet" href="../style/index.css">
    <link rel="stylesheet" href="../style/admin/general-content-admin.css">
    <link rel="stylesheet" href="../style/admin/display-form-admin.css">
    <!-- datatable -->
    <link href="https://cdn.datatables.net/v/dt/dt-2.1.8/datatables.min.css" rel="stylesheet">
    <script src="https://cdn.datatables.net/v/dt/dt-2.1.8/datatables.min.js"></script>
    <script src="../script/admin/manage-adminpage.js"></script>

</head>
<body>
<div class="container-fluid">
    <div class="row mt-3 mb-2">
        <div class="col"><h3 class="style-title">Quản lý chính sách</h3></div>
        <div class="col text-end mt-3 me-4">
            <button class="btn-add" id="addPolicyBtn"><i class="fa-solid fa-plus me-2"></i>Thêm chính sách</button>
        </div>
    </div>
    <div class="row">
        <table id="myTable" class="display custom-table w-100">
            <thead>
            <tr class="head-table">
                <th>STT</th>
                <th>Tên chính sách</th>
                <th>Số lượng sản phẩm áp dụng</th>
                <th>Ngày tạo</th>
                <th>Tiện ích</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>1</td>
                <td>Chống hàng kém chất lượng</td>
                <td>123</td>
                <td>13/12/2021</td>
                <td>
                    <button class="btn-read-edit">Xem và Chỉnh Sửa</button>
                    <button class="btn-delete">Xóa</button>
                </td>
            </tr>
            <tr>
                <td>2</td>
                <td>Chính sách bồi thường</td>
                <td>123</td>
                <td>13/12/2021</td>
                <td>
                    <button class="btn-read-edit">Xem và Chỉnh Sửa</button>
                    <button class="btn-delete" data-policy = 'Chính sách 1'>Xóa</button>
                </td>
            </tr>
            <tr>
                <td>3</td>
                <td>Chính sách hoàn hàng</td>
                <td>123</td>
                <td>13/12/2021</td>
                <td>
                    <button class="btn-read-edit">Xem và Chỉnh Sửa</button>
                    <button class="btn-delete">Xóa</button>
                </td>
            </tr>

            </tbody>
        </table>
    </div>
</div>

<div id="formWrapper" class="hidden mx-auto"></div>

<script src="../script/admin/change-policy-form.js"></script>
</body>
</html>
