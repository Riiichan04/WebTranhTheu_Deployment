$('#editBtn').click(function () {
    $('#title').text('Chỉnh sửa giảm giá');
    $('.read').addClass('d-none');
    $('#nameDiscount').prop('disabled', false);
    $('#description').prop('disabled', false);
    $('#percentDiscount').prop('disabled', false);
    $('#startDateDiscount').prop('disabled', false);
    $('#endDateDiscount').prop('disabled', false);

    $('.edit-hidden').removeClass('d-none');
});

$('#cancelEditBtn').click(function () {
    $('#read-edit-promotion-form')[0].reset();
    $('#title').text('Xem giảm giá');
    $('.read').removeClass('d-none');
    $('#nameDiscount').prop('disabled', true);
    $('#description').prop('disabled', true);
    $('#percentDiscount').prop('disabled', true);
    $('#startDateDiscount').prop('disabled', true);
    $('#endDateDiscount').prop('disabled', true);

    $('.edit-hidden').addClass('d-none');
});