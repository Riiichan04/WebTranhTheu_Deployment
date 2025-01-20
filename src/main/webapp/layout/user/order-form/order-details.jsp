<%--
  Created by IntelliJ IDEA.
  User: loan
  Date: 20/01/2025
  Time: 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chi tiết đơn hàng</title>
</head>
<body>
<div id="order-detail-info" class=" content-details col" style="display: none">
  <div class="row"><i class="backpage pt-4 bi bi-chevron-left">Trở lại</i></div>
  <div class="row">
    <div class="col-7 h3 px-4 pt-2 pb-2 ">Chi tiết đơn hàng</div>
    <div class="col-3 p">Mã đơn: 24091778WTHEHEHE</div>
    <div class="col-2 p"><br/>Hoàn thành</div>
  </div>
  <hr/>
  <div class=" my-4 row align-items-center timeline-container">
    <div class="col timeline-step">
      <div class="timeline-circle">
        <i class="bi bi-receipt"></i>
      </div>
      <div class="timeline-text">Đơn Hàng Đã Đặt</div>
      <div class="timeline-date">12:16 <br/> 17/09/2024</div>
    </div>
    <div class="col timeline-connector"></div>
    <div class="col timeline-step">
      <div class="timeline-circle">
        <i class="bi bi-cash-stack"></i>
      </div>
      <div class="timeline-text">Đã Xác Nhận Thông Tin</div>
      <div class="timeline-date">12:46 <br/> 17/09/2024</div>
    </div>
    <div class="col timeline-connector"></div>
    <div class="col timeline-step">
      <div class="timeline-circle">
        <i class="bi bi-truck"></i>
      </div>
      <div class="timeline-text">Đã Giao Cho ĐVVC</div>
      <div class="timeline-date">18:04 <br/> 17/09/2024</div>
    </div>
    <div class="col timeline-connector"></div>
    <div class="col timeline-step">
      <div class="timeline-circle">
        <i class="bi bi-box-seam"></i>
      </div>
      <div class="timeline-text">Đã Nhận Được Hàng</div>
      <div class="timeline-date">08:04 <br/> 24/09/2024</div>
    </div>
    <div class="col timeline-connector"></div>
    <div class="col timeline-step">
      <div class="timeline-circle">
        <i class="bi bi-star-fill"></i>
      </div>
      <div class="timeline-text">Đơn Hàng Đã Hoàn Thành</div>
      <div class="timeline-date">23:59 <br/> 24/09/2024</div>
    </div>
  </div>
  <hr/>
  <div class="m-2 row rebuy-area">
    <div class="col-8">Cảm ơn quý khách đã tham gia mua sắm!</div>
    <button class="col-4 rebuy_btn">Mua lại</button>
  </div>
  <hr/>
  <div class="p-4 row">
    <div class="row">
      <div class="col-10 h5">Địa chỉ nhận hàng</div>
      <div class="col-2 text-end">Ninja Van</div>

    </div>
    <div class="col-5 border-end">
      <div class="row h6">Bích Loan</div>
      <div class="row">
        +(84)357676762
        <br/>
        Khu phố 6, phường Linh Trung, Thành phố Thủ Đức, TP HCM
      </div>
    </div>
    <div class="col-7">
      <div class="timeline container ">
        <!-- Reusable Timeline Item -->
        <div class="timeline-item">
          <div class="timeline-icon completed">
            <i class="bi bi-check-lg"></i>
          </div>
          <div class="timeline-content">
            <div class="timeline-time">16:35 20-09-2024</div>
            <div class="timeline-title text-success">Đã giao</div>
            <div class="timeline-description">
              Giao hàng thành công<br>
              Người nhận hàng: <strong>Bích Loan</strong> - <a href="#" class="timeline-link">Xem
              hình ảnh giao hàng</a>
            </div>
          </div>
        </div>

        <div class="timeline-item">
          <div class="timeline-icon">
            <i class="bi bi-truck"></i>
          </div>
          <div class="timeline-content">
            <div class="timeline-time">16:35 20-09-2024</div>
            <div class="timeline-title">Đang vận chuyển</div>
            <div class="timeline-description">
              Đơn hàng sẽ sớm được giao, vui lòng chú ý điện thoại
            </div>
          </div>
        </div>

        <div class="timeline-item">
          <div class="timeline-icon">
            <i class="bi bi-clock"></i>
          </div>
          <div class="timeline-content">
            <div class="timeline-time">09:06 20-09-2024</div>
            <div class="timeline-title">Đang vận chuyển</div>
            <div class="timeline-description">
              Đơn hàng đã đến trạm giao hàng tại khu vực của bạn và sẽ được giao trong vòng 24 giờ
              tiếp theo.
            </div>
          </div>
        </div>

        <div class="timeline-item">
          <div class="timeline-icon">
            <i class="bi bi-box"></i>
          </div>
          <div class="timeline-content">
            <div class="timeline-time">12:07 19-09-2024</div>
            <div class="timeline-title">Rời khỏi phân loại</div>
            <div class="timeline-description">
              Đơn hàng đã đến kho phân loại tại TP. Hồ Chí Minh.
            </div>
          </div>
        </div>

        <div class="text-center mt-3">
          <a href="#" class="timeline-link">Xem thêm</a>
        </div>
      </div>
    </div>
  </div>
  <hr/>
  <div class="mt-4 container">
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
    <hr/>
    <div class="row px-4 py-4 ">
      <div class="col-7 border-end">
        <div class="row">
          <div class="col"></div>
          <div class="col-5">Tổng tiền hàng:</div>
        </div>
        <hr/>
        <div class="row">
          <div class="col"></div>
          <div class="col-5">Phí vận chuyển:</div>
        </div>
        <hr/>
        <div class="row">
          <div class="col"></div>
          <div class="col-5">Giảm giá:</div>
        </div>
        <hr/>
        <div class="row">
          <div class="col"></div>
          <div class="col-5">Thành tiền:</div>
        </div>
        <hr/>
      </div>
      <div class="col-5 ps-3">
        <p class="row ps-5 ">30.000.000đ</p>
        <hr/>
        <p class="row ps-5">32.000đ</p>
        <hr/>
        <p class="row ps-5">- 32.000đ</p>
        <hr/>
        <p class="row ps-5">30.000.000đ</p>
        <hr/>
      </div>
    </div>
    <hr/>
    <div class="row p-0 my-3">
      <div class="col-3"></div>
      <div class="col-4 border-end">Phương thức thanh toán</div>
      <div class="col-5">Thanh toán khi nhận hàng</div>
    </div>
    <div class="row p-0 my-3">
      <div class="col-3"></div>
      <div class="col-4 border-end">Lý do hủy:</div>
      <div class="col-5">Không muốn mua hàng nữa.</div>
    </div>
  </div>
</div>
</body>
</html>
