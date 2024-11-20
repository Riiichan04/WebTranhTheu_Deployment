$("#checkAll").change(function () {
    if($(this).is(':checked')){
        $(".product-checkbox").prop('checked', true);
    }
    else $(".product-checkbox").prop('checked', false);
})


