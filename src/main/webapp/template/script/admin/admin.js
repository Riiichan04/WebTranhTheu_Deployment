// load nội dung các trang
$(".ajax-link").on("click", function (event) {
    event.preventDefault(); // Ngăn tải lại trang
    const url = $(this).attr("href");

    $.ajax({
        url: url,
        type: "GET",
        success: function (data) {
            $("#content").html(data);
        },
        error: function () {
            alert("Có lỗi xảy ra khi tải nội dung.");
        }
    });
});

// cho biết đang ở trang nào
$(".select-nav").click(function () {
    $('.select-nav.active').removeClass('active');
    this.classList.add('active');
});