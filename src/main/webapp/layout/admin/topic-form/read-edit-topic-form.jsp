<%--
  Created by IntelliJ IDEA.
  User: MINH THU
  Date: 12/23/2024
  Time: 1:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Xem và Sửa thông tin chủ đề</title>
    <link rel="icon" href="../../asset/favicon/favicon.ico">
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <!-- FontAwesome -->
    <script src="https://kit.fontawesome.com/2643e782c1.js" crossorigin="anonymous"></script>
    <!-- JQuery -->
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <!-- DataTable -->
    <link href="https://cdn.datatables.net/v/dt/dt-2.1.8/datatables.min.css" rel="stylesheet">
    <script src="https://cdn.datatables.net/v/dt/dt-2.1.8/datatables.min.js"></script>
    <!-- css property -->
    <link rel="stylesheet" href="../../style/index.css">
    <link rel="stylesheet" href="../../style/admin/style-form/general-form.css">
    <link rel="stylesheet" href="../../style/admin/style-form/style-read-edit-category-form.css">

</head>
<body>
<!-- Form container -->
<div id="formContainer">
    <!-- enter code -->
    <form class="form-container">
        <div class="row pt-3">
            <div class="col"><h2 class="style-big-title" id="title">Xem chủ đề</h2></div>
        </div>
        <!-- tên danh mục -->
        <div class="row pt-2">
            <div class="col"><span class="style-title">Tên chủ đề</span></div>
        </div>
        <div class="row pt-2">
            <div class="col p-0"><input type="text" class="w-100 style-input" id="nameTopic" placeholder="Nhập tên chủ đề" value="Tranh thêu phong cảnh" required disabled>
            </div>
        </div>
        <!-- ds sản phẩm thuộc danh mục -->
        <div class="row pt-3">
            <div class="col"><span class="style-title">Sản phẩm thuộc chủ đề</span></div>
        </div>
        <div class="row pt-2">
            <div class="col p-0">
                <table id="myTable" class="display custom-table w-100">
                    <thead>
                    <tr>
                        <th class="text-center">STT</th>
                        <th class="text-center">Mã sản phẩm</th>
                        <th class="text-center">Tên sản phẩm</th>
                        <th class="text-center">Ngày thêm</th>
                        <th class="text-center d-none edit-hidden">Xóa</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>1</td>
                        <td>SP01</td>
                        <td>Tranh thêu sông nước</td>
                        <td>1/2/2024</td>
                        <td class="d-none edit-hidden">
                            <input type="checkbox" style="width: 15px; height: 15px">
                        </td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>SP02</td>
                        <td>Tranh thêu sông nước</td>
                        <td>1/2/2024</td>
                        <td class="d-none edit-hidden">
                            <input type="checkbox" style="width: 15px; height: 15px">
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <!-- thêm sp vào danh mục -->
        <div class="row pt-3 d-none add-product edit-hidden">
            <div class="col"><span class="style-title">Thêm sản phẩm thuộc chủ đề (Chọn nhiều)</span></div>
        </div>
        <div class="row pt-2 d-none add-product edit-hidden">
            <div class="col p-0">
                <select class="style-select-many" id='addProduct' name="products" multiple>
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
        <!-- trạng thái -->
        <div class="row pt-2">
            <div class="col"><span class="style-title">Trạng thái</span></div>
        </div>
        <div class="row pt-2">
            <div class="col p-0">
                <select class="style-select status-topic" required disabled>
                    <option selected>Đang hoạt động</option>
                    <option>Vô hiệu hóa</option>
                </select>
            </div>
        </div>
        <!-- ngày tạo -->
        <div class="row pt-3">
            <div class="col"><span class="style-title">Ngày tạo chủ đề</span></div>
        </div>
        <div class="row pt-2">
            <div class="col p-0"><input type="date" class="w-100 style-input" value="2024-10-30" required disabled></div>
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

    <!-- khi bấm nút chỉnh sửa thì hiện ra 2 select gồm select chứa sản phẩm thuộc chủ đề
 và select còn lại chứa các sản phẩm không thuôc chủ đề đó (có thể thêm sp vào chủ đề) -->

</div>

<script src="../../script/admin/topic-form/read-edit-topic-form.js"></script>
<script src="../../script/admin/js-get-height-form.js"></script>
</body>
</html>
