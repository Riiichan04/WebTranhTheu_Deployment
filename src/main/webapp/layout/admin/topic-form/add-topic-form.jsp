<%--
  Created by IntelliJ IDEA.
  User: MINH THU
  Date: 12/23/2024
  Time: 1:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm danh mục</title>
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
    <!--enter code -->
    <form class="form-container">
        <div class="row pt-3">
            <div class="col"><h2 class="style-big-title">Thêm chủ đề</h2></div>
        </div>
        <!-- tên danh mục -->
        <div class="row pt-2">
            <div class="col"><span class="style-title">Tên chủ đề<span class="text-danger"> * </span></span></div>
        </div>
        <div class="row pt-2">
            <div class="col p-0"><input type="text" class="w-100 style-input" placeholder="Nhập tên chủ đề" required>
            </div>
        </div>
        <!-- trạng thái -->
        <div class="row pt-2">
            <div class="col"><span class="style-title">Trạng thái<span class="text-danger"> * </span></span></div>
        </div>
        <div class="row pt-2">
            <div class="col p-0">
                <select class="style-select" required>
                    <option selected>Đang hoạt động</option>
                    <option>Vô hiệu hóa</option>
                </select>
            </div>
        </div>

        <div class="row pt-4 pb-4">
            <div class="col">
                <button id="cancelBtn" class="style-cancel-btn">Hủy</button>
            </div>
            <div class="col">
                <button class="style-button">Thêm chủ đề</button>
            </div>
        </div>
    </form>
</div>

<script src="../../script/admin/js-get-height-form.js"></script>
</body>
</html>
