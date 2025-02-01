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