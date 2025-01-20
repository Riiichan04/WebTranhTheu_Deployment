<%--
  Created by IntelliJ IDEA.
  User: loan
  Date: 20/01/2025
  Time: 12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đơn bị hủy</title>
</head>
<body>
<div id="user-cancel-order" class=" content-details col" style="display: none">
  <div class="h3 p-4">Hủy đơn hàng</div>
  <hr/>
  <div class="card mt-4 container">
    <!--NSX-->
    <div class="row shop-info">
      <div class="col-1"><i class="bi bi-shop-window"></i></div>
      <div class="col">provider</div>
    </div>
    <hr>
    <!--Danh sach sp trong 1 order-->
    <div class="row py-4 list-products">
      <div class="container">
        <!-- Sản phẩm 1-->
        <div class="row py-3">
          <div class="col-3"><img src="../asset/image/product_image.png" class="resized-image">
          </div>
          <div class="col container">
            <div class="row title">Tranh thêu thám tử lừng danh Conan</div>
            <div class="row">x1</div>
          </div>
          <div class="col-3 p-4">15.000.000 đ</div>
        </div>
        <!--Sản phẩm 2-->
        <div class="row py-3 ">
          <div class="col-3"><img src="../asset/image/product_image.png" class="resized-image">
          </div>
          <div class="col container">
            <div class="row title">Tranh thêu thám tử lừng danh Conan</div>
            <div class="row">x1</div>
          </div>
          <div class="col-3 p-4">15.000.000 đ</div>
        </div>
      </div>
    </div>
  </div>
  <div class="reason">
    <div class="h5 mt-5">Lý do hủy đơn hàng?</div>
    <hr/>
    <div class="row"><p class="col-9">Tôi muốn đổi hình thức thanh toán.</p><input type="radio"
                                                                                   name="question1"
                                                                                   class="col-2 m-2"></div>
    <div class="row"><p class="col-9">Tôi muốn đổi địa chỉ nhận hàng.</p><input type="radio"
                                                                                name="question1"
                                                                                class="col-2 m-2"></div>
    <div class="row"><p class="col-9">Tôi muốn sản phẩm.</p><input type="radio" name="question1"
                                                                   class="col-2 m-2"></div>
    <div class="row"><p class="col-9">Tôi không có nhu cầu mua nữa.</p><input type="radio" name="question1"
                                                                              class="col-2 m-2"></div>
    <div class="row"><p class="col-9">Thời gian giao hàng quá lâu.</p><input type="radio" name="question1"
                                                                             class="col-2 m-2"></div>
    <div class="row"><p class="col-9">Tôi tìm thấy nội dung phù hợp hơn.</p><input type="radio"
                                                                                   name="question1"
                                                                                   class="col-2 m-2"></div>
  </div>
  <div class="row submit-cancel m-4">
    <div class="col-8"></div>
    <button class="col-4 submit-cancel-reason">Gửi</button>
  </div>
</div>
</body>
</html>
