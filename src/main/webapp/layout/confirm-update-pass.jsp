<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Xác nhận đổi mật khẩu - Nét Việt</title>
    <%@include file="public/library.jsp" %>
    <link rel="stylesheet" href="../template/style/user/sign-in.css">
    <link rel="stylesheet" href="../template/style/user/verify.css">
    <script>
        document.addEventListener("DOMContentLoaded", function () {
            const confirmPasswordInput = document.getElementById("pre-password");

            // Disable paste, copy, and cut
            confirmPasswordInput.addEventListener("paste", (e) => e.preventDefault());
            confirmPasswordInput.addEventListener("copy", (e) => e.preventDefault());
            confirmPasswordInput.addEventListener("cut", (e) => e.preventDefault());
        });
    </script>
</head>
<body class="d-flex justify-content-center align-items-center vh-100">

<div class="container px-5">
    <form method="post" id="confirm-update-pass-form">
        <div class="row pt-3">
            <div class="col"><h2 class="style-big-title">Nhập mã xác nhận đổi mật khẩu</h2></div>
        </div>
        <div style="color: red; font-size: 14px" id="error"></div>
        <!-- nhập mã xác nhận -->
        <div class="row pt-3">
            <div class="col"><span class="style-title">Nhập mã xác nhận:<span class="text-danger"> * </span></span>
            </div>
        </div>
        <div class="row pt-2">
            <div class="col-1 text-center p-0">
                <div class="icon-container"><i class="fa-solid fa-lock icon-input"></i></div>
            </div>
            <div class="col-11 p-0"><input type="number" id="code" class="w-100 style-input"
                                           placeholder="Nhập mã xác nhận" required></div>
        </div>
        <!-- nhập mật khẩu -->
        <div class="row pt-3">
            <div class="col"><span class="style-title">Nhập mật khẩu mới:<span class="text-danger"> * </span></span>
            </div>
        </div>
        <div class="row pt-2">
            <div class="col-1 text-center p-0">
                <div class="icon-container"><i class="fa-solid fa-lock icon-input"></i></div>
            </div>
            <div class="col-11 p-0"><input type="password" min="8" class="w-100 style-input" id="password"
                                           placeholder="Ít nhất 8 kí tự, có chứa chữ số, chữ hoa, kí tự đặc biệt"
                                           required></div>
        </div>
        <!-- nhập lại mật khẩu -->
        <div class="row pt-3">
            <div class="col"><span class="style-title">Nhập lại mật khẩu mới:<span class="text-danger"> * </span></span>
            </div>
        </div>
        <div class="row pt-2">
            <div class="col-1 text-center p-0">
                <div class="icon-container"><i class="fa-solid fa-lock icon-input"></i></div>
            </div>
            <div class="col-11 p-0"><input type="password" min="8" id="pre-password" class="w-100 style-input"
                                           placeholder="Nhập lại mật khẩu" required></div>
        </div>

        <div class="row pt-3 pb-3">
            <div class="col text-center">
                <button class="style-button" type="submit" id="submitBtn">Cập nhật</button>
            </div>
        </div>
    </form>
</div>

<div class="overlay d-none success-update-pass">
    <div class="popup-container text-center">
        <h4 class="title"><i class="fa-solid fa-circle-check me-2"></i>Đổi mật khẩu thành công</h4>
        <button class="verify-cancel-button">Hủy</button>
        <button class="verify-button" onclick="window.location.href = '/login'">Đăng nhập</button>
    </div>
</div>

<div class="overlay d-none fail-update-pass">
    <div class="popup-container text-center">
        <h4 class="title"><i class="fa-solid fa-circle-xmark me-2"></i>Đổi mật khẩu thất bại</h4>
        <button class="verify-cancel-button">Hủy</button>
    </div>
</div>

<script>

    $('.verify-cancel-button').click(function () {
        $('.overlay').addClass('d-none');
    });

    $('.overlay').click(function (event) {
        if ($(event.target).closest('.popup-container').length === 0) {
            $('.overlay').addClass('d-none');
        }
    });

    $('#confirm-update-pass-form').on('submit', function (event) {
        event.preventDefault();
        $.ajax({
            url: "/update-pass",
            type: "POST",
            data: {
                code: $('#code').val(),
                password: $('#password').val(),
                confirmPassword: $('#pre-password').val(),
            },
            success: function (response) {
                if (!response.error) {
                    console.log(response.error)
                    if (response.success) {
                        $('.success-update-pass').removeClass('d-none');
                    } else if (!response.success) {
                        console.log("whyyyyyyyyyyyy")
                        $('.fail-update-pass').removeClass('d-none');
                    }
                } else {
                    $("#error").text(response.message);
                }
                $('#submitBtn').prop('disabled', false);
            },
            error: function () {
                $('.fail-update-pass').removeClass('d-none');
                $('#submitBtn').prop('disabled', false);
            }
        });
    });
</script>
</body>
</html>
