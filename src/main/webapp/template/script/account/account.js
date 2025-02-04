
//Each properties show
$(".list-group-item").click(function () {
    $(".list-group-item").removeClass("active");
    $(this).addClass("active");
})
$(".list-group-item").on("click", function (event) {
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


// Sửa địa chỉ mới
// $("#change-address").click(function () {
    // $("#sub-change-address").css("display", "none")
    // const parent = $(this).parents(".address")
    // const card_content = parent.find(".card").find(".card-text")
    // console.log(card_content.text())
    // const change_field = parent.find("#sub-change-address")
    // const field = change_field.find(".change-address-input")
    // field.val(card_content.text())
    // change_field.css("display", "block")

// })

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


