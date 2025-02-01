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