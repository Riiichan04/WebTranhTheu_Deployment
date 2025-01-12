<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quên mật khẩu - Nét Việt</title>
    <%@include file="public/library.jsp"%>
    <link rel="stylesheet" href="../template/style/user/sign-in.css">

</head>
<body class="d-flex justify-content-center align-items-center vh-100">
<div class="container px-5">
    <form method="post">
        <div class="row pt-3">
            <div class="col"><h2 class="style-big-title">Quên mật khẩu</h2></div>
        </div>
        <div style="color: red; font-size: 14px">${error}</div>
        <!-- nhập email -->
        <div class="row pt-3">
            <div class="col"><span class="style-title">Email:<span class="text-danger"> * </span></span></div>
        </div>
        <div class="row pt-2">
            <div class="col-1 text-center p-0">
                <div class="icon-container"><i class="fa-solid fa-lock icon-input"></i></div>
            </div>
            <div class="col-11 p-0"><input type="email" name="email" class="w-100 style-input" placeholder="Nhập email" required></div>
        </div>
        <!-- nhập tên đăng nhập -->
        <div class="row pt-3">
            <div class="col"><span class="style-title">Tên đăng nhập:<span class="text-danger"> * </span></span></div>
        </div>
        <div class="row pt-2">
            <div class="col-1 text-center p-0">
                <div class="icon-container"><i class="fa-solid fa-lock icon-input"></i></div>
            </div>
            <div class="col-11 p-0"><input type="text" name="username" class="w-100 style-input" placeholder="Nhập tên đăng nhập" required></div>
        </div>

        <div class="row pt-3">
            <div class="col text-center">
                <button class="style-button" type="submit">Đổi mật khẩu</button>
            </div>
        </div>
        <div class="row mt-4_5 pb-4">
            <div class="col text-center">
                <span>Bạn đã có tài khoản?</span>
                <a href="/login">Đăng nhập ngay!</a>
            </div>
        </div>
    </form>
</div>
</body>
</html>
