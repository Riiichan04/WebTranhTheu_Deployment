<%--
  Created by IntelliJ IDEA.
  User: MINH THU
  Date: 12/23/2024
  Time: 1:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cài đặt người dùng</title>
    <%@include file="../public/library.jsp"%>
    <!-- css property -->
    <link rel="stylesheet" href="../../template/style/admin/general-content-admin.css">
    <link rel="stylesheet" href="../../template/style/admin/setting-user.css">

</head>
<body>
<div class="container-fluid">
    <div class="row mt-3">
        <div class="col">
            <h3 class="style-title">Cài đặt người dùng</h3>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <div class="img-container mx-auto">
                <img src="../../template/asset/image/avt-admin.png" class="img">
                <i class="fa-solid fa-pen-to-square icon-edit-avt"></i>
            </div>
        </div>
    </div>
    <div class="row px-5">
        <div class="col style-label align-content-center"><i
                class="fa-solid fa-circle-info d-inline pe-2"></i>Thông tin cá nhân
        </div>
        <div class="col text-end">
            <button class="btn-edit" id="btn-info-user"><i class="fa-solid fa-pen me-2"></i>Chỉnh sửa
            </button>
        </div>
    </div>
    <form style="padding-left: 150px; padding-right: 150px" id="info-admin-form">
        <div class="row pb-5">
            <div class="col">
                <div class="row mt-2">
                    <div class="mb-3">Tên đăng nhập</div>
                    <div><input type="text" value="admin-01" class="w-100 style-input" id="username" disabled></div>
                </div>
                <div class="row mt-4">
                    <div class="mb-3">Mật khẩu:</div>
                    <div><input type="password" value="fcmhmgjhhynm" class="w-100 style-input"
                                id="password" disabled></div>
                </div>
                <div class="row mt-4">
                    <div class="mb-3">Họ và tên</div>
                    <div><input type="text" value="Nguyễn Phương Thảo" class="w-100 style-input"
                                id="name" disabled></div>
                </div>
            </div>
            <div class="col">
                <div class="row mt-2">
                    <div class="mb-3">Email</div>
                    <div><input type="text" value="phuongthao123@gmail.com" class="w-100 style-input"
                                id="email" disabled>
                    </div>
                </div>
                <div class="row mt-4">
                    <div class="mb-3">Số điện thoại</div>
                    <div><input type="text" value="0123456789" class="w-100 style-input" id="phone"
                                disabled></div>
                </div>
                <div class="row mt-4">
                    <div class="mb-3">Giới tính</div>
                    <div>
                        Nam<input type="radio" name="gender" value="Nam" class="ms-1 me-3" id="gender-man" disabled>
                        Nữ<input type="radio" name="gender" value="Nữ" class="ms-1" id="gender-woman" disabled
                                 checked>
                    </div>
                </div>
            </div>
        </div>
        <div class="row mb-2 update-hidden d-none">
            <div class="col-2"></div>
            <div class="col">
                <button class="w-100 me-1 style-button" id="btn-close" type="button">Hủy</button>
            </div>
            <div class="col">
                <button class="w-100 ms-1 style-button" id="btn-update" type="submit">Cập nhật</button>
            </div>
            <div class="col-2"></div>
        </div>
    </form>
</div>
<script>
    $('#btn-info-user').click(function () {
        document.getElementById('password').disabled = false;
        document.getElementById('name').disabled = false;
        document.getElementById('email').disabled = false;
        document.getElementById('phone').disabled = false;
        document.getElementById('gender-man').disabled = false;
        document.getElementById('gender-woman').disabled = false;
        document.getElementById('btn-info-user').disabled = true;
        $('#btn-info-user').css({
            "opacity": "0.7"
        })
        $('.update-hidden').removeClass('d-none');
    });

    $('#info-admin-form').on('submit', function (event) {
            event.preventDefault(); // Ngăn chặn reload trang

            // Gửi dữ liệu qua AJAX
            $.ajax({
                url: '/admin/update-info-admin', // Endpoint API thêm sản phẩm
                type: 'POST',
                data: {
                    password: $('#password').val(),
                    name: $('#name').val(),
                    email: $('#email').val(),
                    phone: $('#phone').val(),
                    gender: $('input[name="gender"]:checked').val(),
                },
                success: function (response) {
                    alert('Cập nhập thông tin thành công!');
                    location.reload();
                },
                error: function (error) {
                    alert('Lỗi khi cập nhật thông tin!');
                }
            });
    });
</script>
</body>
</html>
