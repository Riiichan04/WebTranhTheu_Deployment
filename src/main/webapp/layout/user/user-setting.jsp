<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<jsp:include page="../common.jsp"/>--%>
<html>
<head>
    <title>Cài đặt</title>
<%--    <%@include file="../public/library.jsp" %>--%>
<%--    <!-- css property -->--%>
<%--    <link rel="stylesheet" href="../../template/style/user/account-page.css">--%>
    <link rel="stylesheet" href="../../template/style/user/style-forms/user-setting.css">
</head>
<body>
<div id="user_setting" class=" content-details col">
    <div class="h3 pt-3 ps-3">Cài đặt</div>
    <hr>
    <div class="container py-3">
        <div class="row avatar">
            <div class="col-3 py-5 ps-3">Ảnh đại diện:</div>
            <div class="col-3"><img src="../asset/image/user_img.png" style="width: 100px;height: 100px;"></div>
            <div class="col-3 pt-5">
                <button type="button" class="change-img">Thay đổi</button>
                <div class="change_avatar mt-1 ms-3 container border" style="display: none">
                    <div class="row ps-2 border-bottom">Lấy từ thiết bị</div>
                    <div class="row ps-2">Link url</div>
                </div>
            </div>
        </div>
        <div class="row fullname">
            <div class="col-2 py-5 ps-3">Tên:</div>
            <div class="col-4 pt-5"><input id="fullname" type="text" value="Nguyễn Bích Loan"></div>
            <div class="col-5 pt-5">
                <button type="reset" class="change-name"> Thay đổi</button>
                <div class="row change-detail ps-4 pt-3" style="display: none">
                    <p class="col-4">Tên mới:</p>
                    <input class="fullname_edit col-5" placeholder="Enter new name...">
                    <button class="col-2 edit_name">Change</button>
                </div>
            </div>
        </div>
        <div class="row feedback-form">
            <form class="poll-form">
                <div class="row ps-3">Thăm dò ý kiến:</div>
                <div class="container border">
                    <div class="row p-2">
                        <div class="col-8">Bạn thấy tranh thêu có đẹp không?</div>
                        <div class="col-2"><input type="radio" name="question1" value="Có"> Có</div>
                        <div class="col-2"><input type="radio" name="question1" value="Không"> Không</div>
                    </div>
                    <div class="row p-2">
                        <div class="col-8">Tranh thêu có giúp ngôi nhà bạn trở nên đẹp hơn không?</div>
                        <div class="col-2"><input type="radio" name="question2" value="Có"> Có</div>
                        <div class="col-2"><input type="radio" name="question2" value="Không"> Không</div>
                    </div>
                    <div class="row p-4">
                        <div class="col-8"></div>
                        <div class="col-4">
                            <button type="submit" class="submit-btn" style="width: 100%">Gửi đánh giá</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
        <div class="row">
            <div class="col-9"></div>
            <div class="col-3 pt-3">
                <button type="button" class="delete-account">Xóa tài khoản</button>
            </div>
        </div>
    </div>
</div>
<%--<script src="template/script/header.js"></script>--%>
<%--<script src="template/script/account.js"></script>--%>
</body>
</html>
