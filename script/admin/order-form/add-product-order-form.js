function addProduct() {
    const productRow = document.querySelector('.product-row');
    const newRow = productRow.cloneNode(true);
    newRow.querySelectorAll('input, select').forEach(input => input.value = '');
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

function reasonCancelOrder() {
    const selectedText = $("#statusOrder option:selected").text();
    if(selectedText === 'Đã hủy') {
        $('.label-reason-cancel-order').removeClass('d-none');
        $('.select-reason-cancel-order').removeClass('d-none');
    } else {
        $('.label-reason-cancel-order').addClass('d-none');
        $('.select-reason-cancel-order').addClass('d-none');
    }
}