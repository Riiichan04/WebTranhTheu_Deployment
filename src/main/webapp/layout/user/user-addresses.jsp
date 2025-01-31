<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<jsp:include page="../common.jsp"/>--%>
<html>
<head>
<%--    <title>Địa chỉ người dùng</title>--%>
<%--    <%@include file="../public/library.jsp" %>--%>
    <!-- css property -->
<%--    <link rel="stylesheet" href="../../template/style/user/account-page.css">--%>
    <link rel="stylesheet" href="../../template/style/user/style-forms/user-address.css">
</head>
<body>
<div id="user-address" class="content-details col" >
    <div class="h3 p-3">Sổ địa chỉ</div>
    <hr>
    <div class="container">
        <c:if test="${empty userAddresses}">
            <h4>Chưa có địa chỉ</h4>
        </c:if>
        <div class="row">
            <div class="col-6">
                <div class="row address p-4">
                    <div class="card row">
                        <div class="card-body">
                            <h5 class="card-title">Địa chỉ mặc định</h5>
                            <p class="card-text">${account.getDefaultLocation().location}</p>
                            <button class="change-address" style="width: 50%">Sửa</button>
                        </div>
                    </div>
                    <div class="row sub-change-address">
                        <input class="change-address-input col-9">
                        <button class="col-2 confirm-change-address">Ok</button>
                    </div>
                </div>
            </div>
            <div class="col-6" id="extended-addresses">
                <c:forEach var="address" items="${userAddresses}">
                <div class="row address p-4">
                    <div class="card row">
                        <div class="card-body">
                            <h5 class="card-title">Địa chỉ mở rộng</h5>
                            <p class="card-text">${address.location}</p>
                            <button class="change-address" style="width: 50%">Sửa</button>
                        </div>
                    </div>
                    <div class="row sub-change-address">
                        <input class="change-address-input col-9">
                        <button class="col-2 confirm-change-address">Ok</button>
                    </div>
                </div>
                </c:forEach>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-7"></div>
        <div class="col-5">
            <button class="add-new-address" type="button" style="width: 90%">Thêm địa chỉ</button>
        </div>
    </div>
</div>
<%--<script src="template/script/header.js"></script>--%>
<%--<script src="template/script/account.js"></script>--%>
</body>
</html>
