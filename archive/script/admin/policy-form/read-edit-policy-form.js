$('#editBtn').click(function () {
    window.scrollTo({ top: 0, behavior: 'smooth' });
    $('#title').text('Chỉnh sửa chính sách')
    $('#containerEditBtn').html(`<button class="style-update-btn" id="editBtn" type="submit">Cập nhật</button>`);
    $('#containerCancelBtn').html(`<button type="button" id="cancelEditBtn" class="style-cancel-btn">Hủy</button>`)
    $('#cancelEditBtn').click(function () {
        location.reload();
    });
    
    $('#namePolicy').prop('disabled', false);

    $('#descriptionPolicy').prop('disabled', false);

    $('#listProduct').prop('disabled', false);
    
    $('#titleProductApplyPolicy').text('Xóa sản phẩm đã áp dụng chính sách (Chọn nhiều)');

    $('.edit-hidden').removeClass('d-none');
});