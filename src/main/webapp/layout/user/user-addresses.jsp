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
        <c:if test="${empty account.location}">
            <h4>Chưa có địa chỉ</h4>
        </c:if>
        <div class="row">
            <div class="col-6">
                <div class="row address ps-4">
                    <div class="card row">
                        <div class="card-body">
                            <h5 class="card-title">Địa chỉ mặc định</h5>
                            <p class="card-text">${account.getDefaultLocation().location}</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-6" id="extended-addresses">
                <c:forEach var="address" items="${account.location}">
                <div class="row address ps-4" data-id="${address.id}">
                    <div class="card row">
                        <div class="card-body">
                            <h5 class="card-title">Địa chỉ</h5>
                            <p class="card-text">${address.location}</p>
                            <button id="change-address" style="width: 50%" onclick="showSubChange(this.id)">Sửa</button>
                        </div>
                    </div>
                    <div id="sub-change-address" class="row ms-1 my-2 d-none">
                        <input id="change-address-input" class="col-9 me-2" value="${address.location}">
                        <button id="confirm-change-address" class="col-2" onclick="updateAddress(this.id)">Ok</button>
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
<script>
    function showSubChange(buttonId){
        let element= $("#"+ buttonId)
        // console.log(element)
        let parent;
        let changeField;
        let subChange= $("sub-change-address")
        subChange.addClass("d-none")
        parent= element.parents(".address")
        console.log(parent)
        changeField= parent.children("#sub-change-address")
        console.log(changeField)
        changeField.removeClass("d-none")
    }
    function updateAddress(buttonId){
        let element= $("#"+ buttonId)
        console.log(element)
        let parent;
        let fixedAddress;
        let card_text;
        let id;
        parent= element.parents("#sub-change-address")
        console.log(parent)
        card_text= parent.children(".cart-text")
        id= parent.parents(".address").attr("data-id")
        fixedAddress= parent.children("#change-address-input").val()
        $.ajax({
            url: "/user/user-addresses/update-address",
            type:"POST",
            data:{
                "addressId": id,
                "fixedAddress": fixedAddress
            },
            dataType: "json",
            success: function (){
                card_text.val(fixedAddress)
                parent.addClass("d-none")
            },
            error: function (){

            }
        })
    }

</script>
</body>
</html>
