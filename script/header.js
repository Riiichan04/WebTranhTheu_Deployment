$(".product-item").click(function(){
    window.location = "../page/product.html"
})

$("#header-favorite").click(function(){
    $("#favorite-popup").removeClass("d-none");
})

$(".header-popup__close-btn").click(function(){
    $(this).parent().parent().addClass("d-none")
})