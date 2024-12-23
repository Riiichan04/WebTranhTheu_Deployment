<%--
  Created by IntelliJ IDEA.
  User: MINH THU
  Date: 12/23/2024
  Time: 1:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Xóa đơn hàng</title>
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
    <link rel="stylesheet" href="../../style/admin/style-form/style-delete-form.css">

</head>
<body>
<!-- Form container -->
<div id="formContainer">
    <!-- Modal xác nhận -->
    <div id="confirmModal">
        <div class="modal-content py-4">
            <h5 class="style-title"><i class="fa-solid fa-circle-question me-2"></i>Xóa đơn hàng</h5>
            <hr>
            <h6 class="style-text">Bạn chắc chắn muốn xóa <span class="style-name-element">Mã đơn hàng</span>?</h6>
            <hr>
            <div class="text-end">
                <button class="btn-no d-inline" id="cancelBtn">Không</button>
                <button class="btn-yes d-inline" id="confirmYes">Có</button>
            </div>
        </div>
    </div>
</div>

<script src="../../script/admin/js-get-height-form.js"></script>
</body>
</html>
