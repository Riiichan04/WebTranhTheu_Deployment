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
    $("#change-password").click(function () {
        return $(".sub-change-pass").css("display", "block");
    })

    //Change name
    $("#save-info").click(function () {
        var fname = $("#fname").val();
        var lname = $("#lname").val();
        return $("#nickname").text(fname + " " + lname);
    })
    //Thêm địa chỉ mới
    $(".add-new-address").click(function (){
        $(this).parents("#user-address").css("display","none");
        $("#user-address-add").css("display","block");

    })
    $(".add-address").click(function (){
        // add card into user's address
        const parent =$(this).parents("#user-address-add")
        const new_address= parent.find(".change_address_input").val()
        $("#extended-addresses").append(' <div class="row p-4">\n' +
            '                                <div class="card">\n' +
            '                                    <div class="card-body">\n' +
            '                                        <h5 class="card-title">Địa chỉ mở rộng</h5>\n' +
            '                                        <p class="card-text">'+ new_address +'</p>\n' +
            '                                    </div>\n' +
            '                                </div>\n' +
            '                            </div>')
        $("#user-address-add").css("display","none")
        $("#user-address").css("display","block")

    })

    // Sửa địa chỉ mới
    // coi lại


    //Thay đổi lịch sử xem sản phẩm
    $('.add-to-cart').click(function () {
        $(this).parents(".shop");
        if ($(this).parents(".shop").find(".product-item").length <= 1) {
            $(this).parents(".shop").remove();
        } else {
            $(this).closest('.product-item').remove();
        }
    })


    //Thêm hết vào giỏ hàng.
    $(".addAll-btn").click(function () {
        $('.shop').each(function () {
            $(this).find('.product-item').remove();
            $(this).remove();
        })
    })


    // xoa san pham
    $('.delete-btn').click(function () {
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
    $(".change-img").click(function (){
        $(".change_avatar").show();
    })
    //Change fullname
    $(".change-name").click(function(){
        $(".change-detail").show();
        $(".edit_name").click(function (){
            let fullname= $(".fullname_edit").val();
            $("#fullname").val(fullname);
            $(".change-detail").hide();
        })
    })
    // Support user
    $(".question").click(function(){
        console.log($(this).children(".answer").length)
        $(this).children(".answer").css("display","block");
    })
    //Log out
    $(".logout-btn").click(function (){
        $("#logout_alert").css("display","block");
    })
    $("#noBtn").click(function (){
        $("#logout_alert").css("display","none");
        $(".list-group-item").removeClass("active");
        $(".empty-prop").show();
    })
})