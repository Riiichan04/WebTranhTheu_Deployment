<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Xem và Sửa thông tin danh mục</title>
    <%@include file="../../public/library.jsp"%>
    <!-- css property -->
    <link rel="stylesheet" href="../../../template/style/admin/style-form/general-form.css">
    <link rel="stylesheet" href="../../../template/style/admin/style-form/style-read-edit-category-form.css">

</head>
<body>
<!-- Form container -->
<div id="formContainer">
    <!-- enter code -->
    <form class="form-container" id="read-edit-category-form">
        <div class="row pt-3">
            <div class="col"><h2 class="style-big-title" id="title">Xem vật liệu</h2></div>
        </div>
        <!-- tên danh mục -->
        <div class="row pt-2">
            <div class="col"><span class="style-title">Tên vật liệu</span></div>
        </div>
        <div class="row pt-2">
            <div class="col p-0"><input type="text" class="w-100 style-input" id="name-material" placeholder="Nhập tên vật liệu" value= "<c:out value="${material.getTitle()}"/>" required disabled>
            </div>
        </div>

        <!-- ngày tạo -->
        <div class="row pt-3">
            <div class="col"><span class="style-title">Ngày tạo vật liệu</span></div>
        </div>
        <div class="row pt-2">
            <div class="col p-0"><input type="date" class="w-100 style-input" value="${createAt}" required disabled></div>
        </div>
        <!-- ngày chỉnh sửa -->
        <div class="row pt-3">
            <div class="col"><span class="style-title">Ngày cập nhật vật liệu</span></div>
        </div>
        <div class="row pt-2">
            <div class="col p-0"><input type="date" class="w-100 style-input" value="${updateAt}" required disabled></div>
        </div>

        <div class="row pt-4 pb-4">
            <div class="col read">
                <button type="button" id="cancelBtn" class="style-cancel-btn">Hủy</button>
            </div>
            <div class="col read">
                <button type="button" class="style-button" id="editBtn">Chỉnh sửa</button>
            </div>
            <div class="col d-none edit-hidden">
                <button type="button" id="cancelEditBtn" class="style-cancel-btn">Hủy</button>
            </div>
            <div class="col d-none edit-hidden">
                <button class="style-update-btn" name="materialId" value="<c:out value="${material.getId()}"/>" type="submit" id="submitBtn">Cập nhật</button>
            </div>

        </div>
    </form>

</div>

</body>
</html>
