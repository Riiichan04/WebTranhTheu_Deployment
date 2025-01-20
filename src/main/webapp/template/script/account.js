    //Each properties show
    $(".list-group-item").click(function () {
        $(".list-group-item").removeClass("active");
        $(this).addClass("active");
    })
    $(".list-group-item").on("click", function (event){
        event.preventDefault();
        const url = $(this).attr("href")
        $('#content').empty();
        $.ajax({
            url: url,
            type: "GET",
            success: function (data) {
                $("#content").html(data); // Cập nhật nội dung vào phần #content
            },
            error: function () {
                alert("Lỗi");
            }
        });
    })
    // Change password
    $("#change-password").click(function () {
        $("#sub-change-pass").removeClass("d-none");
    })

    //Change name
    // $("#save-info").click(function () {
    //     const fname = $("#fname").val();
    //     const lname = $("#lname").val();
    //     return $("#nickname").text(fname + " " + lname);
    // })
    //Thêm địa chỉ mới
    $(".add-new-address").click(function () {
        $(this).parents("#user-address").css("display", "none");
        $("#user-address-add").css("display", "block");
    })
    $(".add-address").click(function () {
        // add card into user's address
        const parent = $(this).parents("#user-address-add")
        const new_address = parent.find(".change_address_input").val()
        $("#extended-addresses").append('<div class="row address p-4">\n' +
            '                            <div class="card row">\n' +
            '                                <div class="card-body">\n' +
            '                                    <h5 class="card-title">Địa chỉ mở rộng</h5>\n' +
            '                                    <p class="card-text">' + new_address + '</p>\n' +
            '                                    <button class="change-address" style="width: 50%">Sửa</button>\n' +
            '                                </div>\n' +
            '                            </div>\n' +
            '                            <div class="row sub-change-address">\n' +
            '                                <input class="change-address-input col-9">\n' +
            '                                <button class="col-2 confirm-change-address">Ok</button>\n' +
            '                            </div>\n' +
            '                        </div>')
        $(this).parents("#user-address-add").find(".change_address_input").val("")
        $("#user-address-add").css("display", "none")
        $("#user-address").css("display", "block")

    })

    // Sửa địa chỉ mới
    $(".change-address").click(function () {
        $(".sub-change-address").css("display", "none")
        const parent = $(this).parents(".address")
        const card_content = parent.find(".card").find(".card-text")
        console.log(card_content.text())
        const change_field = parent.find(".sub-change-address")
        const field = change_field.find(".change-address-input")
        field.val(card_content.text())
        change_field.css("display", "block")
    })
    // Sửa
    $(".confirm-change-address").click(function () {
        const parent = $(this).parents(".sub-change-address")
        const fixed_address = parent.find(".change-address-input").val()
        const card_text = $(this).parents(".address").find(".card").find(".card-text")
        card_text.text(fixed_address)
        $(this).parents(".sub-change-address").css("display", "none")
    })

    //Thay đổi lịch sử xem sản phẩm
    $('.add-to-cart').click(function () {
        const cartBadge = $("#cart-badge")
        let cartValue = parseInt(cartBadge.prop("innerText"))
        if ($(this).parents(".shop").find(".product-item").length <= 1) {
            cartValue++
            console.log(cartValue)
            cartBadge.text(cartValue)
            cartBadge.css("display", "flex");
            $(this).parents(".shop").remove();
        } else {
            cartValue++
            console.log(cartValue)
            cartBadge.text(cartValue)
            cartBadge.css("display", "flex");
            $(this).closest('.product-item').remove();
        }
        
    })


    //Thêm hết vào giỏ hàng.
    $(".addAll-btn").click(function () {
        const shop = $(this).parents(".container").children(".shop");
        const cartBadge = $("#cart-badge")
        let cartValue = parseInt(cartBadge.prop("innerText"))
        shop.each(function () {
            console.log(parseInt(shop.find('.product-item').length))
            if (parseInt(shop.find('.product-item').length) <= 1) {
                cartValue += parseInt(shop.find('.product-item').length)
                // console.log(cartValue)
                $(this).remove();
            } else {
                cartValue += parseInt(shop.find('.product-item').length)
                shop.find('.product-item').remove();
                $(this).remove();
            }
        })
        cartBadge.text(cartValue)
        cartBadge.css("display", "flex");
        $(this).css("display","none")
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
    $(".cancel-btn").click(function () {
        $(".content-details").css("display", "none")
        $("#user-cancel-order").css("display", "block")
    })

    // Chi tiết hủy hàng.


    // Change avatar
    $(".change-img").click(function () {
        $(".change_avatar").show();
    })
    //Change fullname
    $(".change-name").click(function () {

        $(".change-detail").show();
        $(".edit_name").click(function () {
            let fullname = $(".fullname_edit").val();
            $("#fullname").val(fullname);
            $(".change-detail").hide();
        })
    })
    // Support user
    $(".question").click(function () {
        console.log($(this).children(".answer").length)
        $(this).children(".answer").css("display", "block");
    })
    //Log out
    $(".logout-btn").click(function () {
        $("#logout_alert").css("display", "block");
        window.location = index.html
    })
    $("#noBtn").click(function () {
        $("#logout_alert").css("display", "none");
        $(".list-group-item").removeClass("active");
        $(".empty-prop").show();
    })
    // Turned back detail
    $(".turnback_details").click(function () {
        $(".content-details").css("display", "none")
        $("#order-detail-info").css("display", "block")
    })
    $(".backpage").click(function () {
        $(".content-details").css("display", "none")
        $("#user-ordered-list").css("display", "block")
    })

    // feedback details
    $(".feedback-details").click(function () {
        $(".content-details").css("display", "none")
        $("#user-feedback-info").css("display", "block")
    })
    $(".backpage-feedback").click(function () {
        $(".content-details").css("display", "none")
        $("#user-feedback-histories").css("display", "block")
    })