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

    //
})