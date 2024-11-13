$(document).ready(function(){
    //Each properties show
    $(".list-group-item").click(function (){
        $(".list-group-item").removeClass("active");
        $(this).addClass("active");
        //Get content each item
        var contents= $(this).data('target');
        $(".content-details").hide()
        return $("#"+ contents).show();
    })
    // Change password
    $("#change_password").click(function () {
         return $(".sub_change_pass").css("display", "block");
    })
    //Change name
    $("#save_info").click(function(){
        var fname= $("#fname").val();
        var lname=$("#lname").val();
        return $("#fullname").text(fname+" "+lname);
    })
    //Thêm địa chỉ mới

    //Thay đổi lịch sử xem sản phẩm
    $('.add-to_cart').click(function() {
        // Find and remove the product item
        $(this).closest('.product-item').remove();

        // Check if there are any remaining products in the same shop
        var shop = $(this).closest('.shop');
        if (shop.find('.product-item').length === 0) {
            // Remove the shop if no products remain
            shop.remove();
        }
    })
    //Thêm hết vào giỏ hàng.
    $(".addAll").click(function (){
        $('.shop').each(function (){
            $(this).find('.product-item').remove();
            $(this).remove();
        })
    })
    // xoa san pham
    $('.delete_btn').click(function() {
        // Find and remove the product item
        $(this).closest('.product-item').remove();

        // Check if there are any remaining products in the same shop
        var shop = $(this).closest('.shop');
        if (shop.find('.product-item').length === 0) {
            // Remove the shop if no products remain
            shop.remove();
        }
    })
})