<%--
  Created by IntelliJ IDEA.
  User: MINH THU
  Date: 1/11/2025
  Time: 8:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Xác thực tài khoản - Nét Việt</title>
    <%@include file="public/library.jsp"%>
    <link rel="stylesheet" href="../template/style/user/verify.css">

</head>
<body>
<%@include file="public/header.jsp"%>

<div class="container verify-container text-center">
    <form id="verify-form" method="post">
        <h3 class="title mb-4">Chúc mừng bạn đã tạo tài khoản thành công. Xác thực ngay!</h3>
        <input type="number" class="input-verify d-inline" id="verify" name="code" placeholder="Nhập mã xác thực" required>
        <button class="d-inline btn-verify ms-2" type="submit">Xác thực</button>
    </form>
</div>

<div class="overlay d-none success-verify">
    <div class="popup-container text-center">
        <h4 class="title"><i class="fa-solid fa-circle-check me-2"></i>Xác thực thành công</h4>
        <button class="verify-cancel-button">Hủy</button>
        <button class="verify-button" onclick="window.location.href = '/login'">Đăng nhập</button>
    </div>
</div>

<div class="overlay d-none fail-verify">
    <div class="popup-container text-center">
        <h4 class="title"><i class="fa-solid fa-circle-xmark me-2"></i>Xác thực thất bại</h4>
        <button class="verify-cancel-button">Hủy</button>
    </div>
</div>

<%@include file="public/footer.jsp"%>

<script>

    $('.verify-cancel-button').click(function () {
        $('.overlay').addClass('d-none');
    });

    $('.overlay').click(function () {
        $('.overlay').addClass('d-none');
    });

    $('#verify-form').on('submit', function (event) {
        event.preventDefault();

        $.ajax({
            url: "/verify",
            type: "POST",
            data: {
                code: $('#verify').val()
            },
            success: function (response) {
                if(response.success) {
                    $('.success-verify').removeClass('d-none');
                } else {
                    $('.fail-verify').removeClass('d-none');
                }
            },
            error: function () {
                $('.fail-verify').removeClass('d-none');
            }
        });
    });
</script>
</body>
</html>
