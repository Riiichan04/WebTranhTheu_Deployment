<%--
  Created by IntelliJ IDEA.
  User: MINH THU
  Date: 12/23/2024
  Time: 1:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm sản phẩm</title>
    <%@include file="../../public/library.jsp"%>
    <!-- css property -->
    <link rel="stylesheet" href="../../../template/style/admin/style-form/general-form.css">
    <link rel="stylesheet" href="../../../template/style/admin/style-form/style-read-edit-product-form.css">
</head>
<body>
<!-- Form container -->
<div id="formContainer">
    <!--enter code -->
    <form class="form-container">
        <div class="row pt-3">
            <div class="col"><h2 class="style-big-title">Thêm sản phẩm</h2></div>
        </div>
        <!-- mã sản phẩm -->
        <div class="row pt-2">
            <div class="col"><span class="style-title">Mã sản phẩm<span class="text-danger"> * </span></span></div>
        </div>
        <div class="row pt-2">
            <div class="col p-0"><input type="text" class="w-100 style-input" placeholder="Nhập mã sản phẩm" required>
            </div>
        </div>
        <!-- tên sản phẩm -->
        <div class="row pt-2">
            <div class="col"><span class="style-title">Tên sản phẩm<span class="text-danger"> * </span></span></div>
        </div>
        <div class="row pt-2">
            <div class="col p-0"><input type="text" class="w-100 style-input" placeholder="Nhập tên sản phẩm" required>
            </div>
        </div>
        <!-- hình ảnh -->
        <div class="row pt-3">
            <div class="col"><span class="style-title">Tải ảnh sản phẩm lên<span class="text-danger"> * </span></span></div>
        </div>
        <div class="row pt-2">
            <div class="col p-0"><input type="file" class="w-100 style-input" multiple required>
            </div>
        </div>
        <!-- mô tả -->
        <div class="row pt-1">
            <div class="col"><span class="style-title">Mô tả</span></div>
        </div>
        <div class="row pt-2">
            <div class="col p-0"><textarea class="w-100 style-area" placeholder="Mô tả sản phẩm"></textarea>
            </div>
        </div>

        <!-- loại tranh: kích thước khác nhau giá khác nhau -->
        <div class="row pt-2">
            <div class="col"><p class="style-title m-0">Loại tranh<span class="text-danger"> * </span><i class="fas fa-plus-circle ms-2 style-add-btn" onclick="addProductPrice()"></i></p></div>
        </div>
        <div class="row pt-2">
            <div class="col">
                <div id="product_price">
                    <div class="row form-group product-price-row mb-2">
                        <div class="row ps-4">
                            <span class="style-label">Loại tranh 1</span>
                        </div>
                        <div class="col pe-0">
                            <!-- giá bán và số lượng -->
                            <div class="row pt-2">
                                <div class="col p-0 pe-1 text-center">
                                    <label class="style-label pb-2">Giá bán (VNĐ)</label>
                                    <input type="number" id="price" class="w-100 style-input"
                                           placeholder="Nhập giá bán sản phẩm" required>
                                </div>
                                <div class="col p-0 ps-1 text-center">
                                    <label class="style-label pb-2">Số lượng</label>
                                    <input type="number" id="quantityProduct" class="w-100 style-input"
                                           placeholder="Nhập số lượng sản phẩm" required>
                                </div>
                            </div>
                            <!-- kích thước -->
                            <div class="row pt-2">
                                <div class="col p-0 pe-1 text-center">
                                    <label class="style-label pb-2">Chiều rộng</label>
                                    <input type="number" class="w-100 style-input" id="widthProduct" placeholder="Chiều rộng (cm)">
                                </div>
                                <div class="col p-0 ps-1 text-center">
                                    <label class="style-label pb-2">Chiều cao</label>
                                    <input type="number" class="w-100 style-input" id="heightProduct" placeholder="Chiều cao (cm)">
                                </div>
                            </div>
                        </div>
                        <div class="col-1">
                            <i class="fa-solid fa-trash icon-del" onclick="removeProductPrice(this)"></i>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- chất liệu -->
        <div class="row pt-3">
            <div class="col"><span class="style-title">Chất liệu<i class="fas fa-plus-circle ms-2 style-add-btn"></i></span></div>
        </div>
        <div class="row pt-2">
            <div class="col p-0">
                <select class="style-select">
                    <option>Vải</option>
                    <option>Chỉ</option>
                    <option>Gỗ</option>
                </select>
            </div>
            <div class="col-1 pe-0">
                <i class="fa-solid fa-trash icon-del"></i>
            </div>
        </div>
        <!-- nhà phân phối -->
        <div class="row pt-3">
            <div class="col"><span class="style-title">Nhà phân phối<span class="text-danger"> * </span></span></div>
        </div>
        <div class="row pt-2">
            <div class="col p-0">
                <select class="style-select" required>
                    <option>Nhà phân phối 1</option>
                    <option>Nhà phân phối 2</option>
                    <option>Nhà phân phối 3</option>
                    <option>Nhà phân phối 4</option>
                    <option>Nhà phân phối 5</option>
                    <option>Nhà phân phối 6</option>
                    <option>Nhà phân phối 7</option>
                    <option>Nhà phân phối 8</option>
                    <option>Nhà phân phối 9</option>
                </select>
            </div>
        </div>
        <!-- chính sách -->
        <div class="row pt-3">
            <div class="col"><span class="style-title">Chính sách</span></div>
        </div>
        <div class="row pt-2">
            <div class="col p-0">
                <select class="style-select">
                    <option>--Chọn chính sách--</option>
                    <option>Chính sách 1</option>
                    <option>Chính sách 2</option>
                    <option>Chính sách 3</option>
                    <option>Chính sách 4</option>
                    <option>Chính sách 5</option>
                    <option>Chính sách 6</option>
                    <option>Chính sách 7</option>
                    <option>Chính sách 8</option>
                </select>
            </div>
        </div>
        <!-- chủ đề -->
        <div class="row pt-3">
            <div class="col"><span class="style-title">Chủ đề (Chọn nhiều)</span></div>
        </div>
        <div class="row pt-2">
            <div class="col p-0">
                <select class="style-select-many" multiple>
                    <option>Chủ để 1</option>
                    <option>Chủ để 2</option>
                    <option>Chủ để 3</option>
                    <option>Chủ để 4</option>
                    <option>Chủ để 5</option>
                    <option>Chủ để 6</option>
                    <option>Chủ để 7</option>
                    <option>Chủ để 8</option>
                </select>
            </div>
        </div>
        <!-- danh mục -->
        <div class="row pt-3">
            <div class="col"><span class="style-title">Danh mục</span></div>
        </div>
        <div class="row pt-2">
            <div class="col p-0">
                <select class="style-select">
                    <option>Danh mục 1</option>
                    <option>Danh mục 1</option>
                    <option>Danh mục 1</option>
                    <option>Danh mục 1</option>
                </select>
            </div>
        </div>
        <!-- trạng thái -->
        <div class="row pt-2">
            <div class="col"><span class="style-title">Trạng thái<span class="text-danger"> * </span></span></div>
        </div>
        <div class="row pt-2">
            <div class="col p-0">
                <select class="style-select" required>
                    <option selected>Đang hoạt động</option>
                    <option>Vô hiệu hóa</option>
                </select>
            </div>
        </div>

        <div class="row pt-4 pb-4">
            <div class="col">
                <button id="cancelBtn" class="style-cancel-btn">Hủy</button>
            </div>
            <div class="col">
                <button class="style-button">Thêm sản phẩm</button>
            </div>
        </div>
    </form>
</div>

<script>
    function addProductPrice() {
        const productRow = document.querySelector('.product-price-row');
        const newRow = productRow.cloneNode(true);
        newRow.querySelectorAll('input').forEach(input => input.value = '');
        document.getElementById('product_price').appendChild(newRow);
    }

    function removeProductPrice(button) {
        const row = button.parentElement.parentElement;
        if (document.querySelectorAll('.product-price-row').length > 1) {
            row.remove();
        } else {
            alert("Phải có ít nhất một loại sản phẩm!");
        }
    }
</script>
</body>
</html>
