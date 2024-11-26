$(document).ready(function () {
    //Each properties show
    $(".list-group-item").click(function () {
        $(".list-group-item").removeClass("active");
        $(this).addClass("active");
        //Get content each item
        var contents = $(this).data('target');
        $(".content-details").hide()
        return $("#" + contents).show();
    })

    // Change password
    $("#change_password").click(function () {
        return $(".sub_change_pass").css("display", "block");
    })

    //Change name
    $("#save_info").click(function () {
        var fname = $("#fname").val();
        var lname = $("#lname").val();
        return $("#nickname").text(fname + " " + lname);
    })
    //Thêm địa chỉ mới

    // Sửa địa chỉ mới

    //Thay đổi lịch sử xem sản phẩm
    $('.add-to_cart').click(function () {
        $(this).parents(".shop");
        if ($(this).parents(".shop").find(".product-item").length <= 1) {
            $(this).parents(".shop").remove();
        } else {
            $(this).closest('.product-item').remove();
        }
    })


    //Thêm hết vào giỏ hàng.
    $(".addAll").click(function () {
        $('.shop').each(function () {
            $(this).find('.product-item').remove();
            $(this).remove();
        })
    })


    // xoa san pham
    $('.delete_btn').click(function () {
        $(this).parents(".shop");
        if ($(this).parents(".shop").find(".product-item").length <= 1) {
            $(this).parents(".shop").remove();
        } else {
            $(this).closest('.product-item').remove();
        }
    })


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

    // Chi tiết đơn hàng.


    // Chi tiết đánh giá.


    // Change avatar
    $(".change_img").click(function (){
        $(".change_avatar").show();
    })
    //Change fullname
    $(".change_name").click(function(){
        $(".change-detail").show();
        $(".edit_name").click(function (){
            let fullname= $(".fullname_edit").val();
            $("#fullname").val(fullname);
            $(".change-detail").hide();
        })
    })
    // Support user (not run)
    $(".question").click(function(){
        console.log($(this).closest(".answer"))
        $(this).closest(".answer").css("display","block");
    })

})