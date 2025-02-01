

// Xem từng mục đơn hàng
$(".order-item").click(function () {
    $(".order-item").removeClass("on");
    $(this).addClass("on");
    //Get content each item
    var orders = $(this).data('target');
    $(".order-details").hide()
    return $("#" + orders).show();
})


//Nút hủy hàng
$(".cancel-btn").click(function () {
    $(".content-details").css("display", "none")
    $("#user-cancel-order").css("display", "block")
})

// Chi tiết hủy hàng.

