$(".category-element").click(function () {
    console.log("AA")
    $(".category-element").removeClass("category-active");
    $(this).addClass("category-active");
})