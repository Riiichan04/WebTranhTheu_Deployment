<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../common.jsp"/>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thông tin người dùng </title>
    <%@include file="../public/library.jsp" %>
    <!-- css property -->
    <link rel="stylesheet" href="../../template/style/user/account-page.css">
    <link rel="stylesheet" href="../../template/style/user/style-forms/user-info.css">
</head>
<body>
<div id="user-info" class="content-details col">
    <div class="h3 p-3">Thông tin tài khoản</div>
    <hr>
    <div class="input-info container">
        <div class="user-inputs">
            <div class="row p-3">Họ và Tên:</div>
            <input class="row ms-1" id="fullname" type="text" placeholder="Họ" value="${account.fullName}">
            <div class="row">
                <div class="col-12 p-3">Địa chỉ email:</div>
                <div class="col-8"><input type="email" placeholder="Email" style="width: 100%" value="${account.email}">
                </div>
            </div>
        </div>
        <!-- Thay đổi mật khẩu -->
        <div class="change-pass container">
            <div class="row">
                <div class="col px-1 py-4">
                    <button id="change-password"><span>Đổi mật khẩu</span></button>
                    <!-- show ra đổi MK như nào-->
                    <div id="sub-change-pass" class=" container d-none">
                        <div class="row">
                            <div class="col p-2">Mật khẩu cũ:</div>
                            <div class="col"><input type="password" placeholder="Nhập..."></div>
                        </div>
                        <div class="row">
                            <div class="col p-2">Mật khẩu mới:</div>
                            <div class="col"><input type="password" placeholder="Nhập..."></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Nút lưu-->
        <div class=" save-info container">
            <div class="row">
                <div class="col-8"></div>
                <div class="col-4">
                    <button id="save-info" type="reset" style="width:80%"><span>Lưu</span></button>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="template/script/header.js"></script>
<script src="template/script/account.js"></script>
</body>
</html>
