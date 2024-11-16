function addProduct() {
    const productRow = document.querySelector('.product-row');
    const newRow = productRow.cloneNode(true);
    newRow.querySelectorAll('input, select').forEach(input => input.value = '');
    document.getElementById('products').appendChild(newRow);

    if($('#formContainer').height() < $('.form-container').height()) {
        $('#formContainer').removeClass('vh-100');
    }
}

function removeProduct(button) {
    const row = button.parentElement.parentElement;
    if (document.querySelectorAll('.product-row').length > 1) {
        row.remove();
    } else {
        alert("Phải có ít nhất một sản phẩm!");
    }
}