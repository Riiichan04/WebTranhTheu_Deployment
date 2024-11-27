function addProduct() {
    const discountRow = document.querySelector('.discount-row');
    const newRow = discountRow.cloneNode(true);
    newRow.querySelectorAll('input').forEach(input => input.value = '');
    document.getElementById('discounts').appendChild(newRow);
}

function removeProduct(button) {
    const row = button.parentElement.parentElement;
    if (document.querySelectorAll('.discount-row').length > 1) {
        row.remove();
    } else {
        alert("Phải có ít nhất một sản phẩm!");
    }
}

function showDiscount(choose) {
    switch (choose) {
        case 'chooseGlobal':
            $('.chooseGlobal').removeClass('d-none');
            $('.chooseIndividual').addClass('d-none');
            break;
        case 'chooseIndividual':
            $('.chooseIndividual').removeClass('d-none');
            $('.chooseGlobal').addClass('d-none');
            break;
    }
}