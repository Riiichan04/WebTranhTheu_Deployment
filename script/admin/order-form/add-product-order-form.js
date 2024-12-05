function addProduct() {
    const productRow = document.querySelector('.product-row');
    const newRow = productRow.cloneNode(true);
    newRow.querySelectorAll('input').forEach(input => input.value = '');
    newRow.querySelectorAll('select').forEach(select => select.disabled = false);
    document.getElementById('products').appendChild(newRow);
}

function removeProduct(button) {
    const row = button.parentElement.parentElement;
    if (document.querySelectorAll('.product-row').length > 1) {
        row.remove();
    } else {
        alert("Phải có ít nhất một sản phẩm!");
    }
}

$('#statusOrder').click(function () {
    const selectedText = $("#statusOrder option:selected").text();
    console.log("here")
    if(selectedText === 'Đã hủy') {
        $('.label-reason-cancel-order').removeClass('d-none');
        $('.select-reason-cancel-order').removeClass('d-none');
    } else {
        $('.label-reason-cancel-order').addClass('d-none');
        $('.select-reason-cancel-order').addClass('d-none');
    }
});

$('#editBtn').click(function () {
    window.scrollTo({ top: 0, behavior: 'smooth' });
    $('#title').text('Chỉnh sửa đơn hàng')
    $('#containerEditBtn').html(`<button class="style-update-btn" id="editBtn" type="submit">Cập nhật</button>`);
    $('#containerCancelBtn').html(`<button type="button" id="cancelEditBtn" class="style-cancel-btn">Hủy</button>`)
    $('#cancelEditBtn').click(function () {
        location.reload();
    });
    
    $('.amount-product-input').prop('disabled', false);
    
    $('#dateDelivery').prop('disabled', false);
    
    $('#statusOrder').prop('disabled', false);
    
    $('#reasonCancelOrder').prop('disabled', false);

    $('.payment-select').prop('disabled', false);
    
    $('.edit-hidden').removeClass('d-none');
});