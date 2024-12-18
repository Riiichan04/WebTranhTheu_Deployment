function addProduct() {
    if (document.querySelectorAll('.discount-row').length < 1) {
        const discountRow = document.createElement('div');
        discountRow.className = "form-group discount-row row mb-2";
        discountRow.innerHTML = `<div class="col pe-0">
                            <label class="style-label">Mã sản phẩm<span class="text-danger"> * </span></label>
                            <input type="text" class="style-input" placeholder="Nhập mã sản phẩm" required>
                        </div>
                        <div class="col pe-0">
                            <label class="style-label">Phần trăm giảm (%)<span class="text-danger"> * </span></label>
                            <input type="number" class="w-100 style-input" min="1" max="100" placeholder="Nhập % giảm" required>
                        </div>
                        <div class="col">
                            <label class="style-label">Số lượng giới hạn</label>
                            <input type="number" class="w-100 style-input" min="1" placeholder="Nhập số lượng">
                        </div>
                        <div class="col-1 p-0 mt-3">
                            <i class="fa-solid fa-trash icon-del" onclick="removeProduct(this)"></i>
                        </div>`;
        document.getElementById('discounts').appendChild(discountRow);
    } else {
        const discountRow = document.querySelector('.discount-row');
        const newRow = discountRow.cloneNode(true);
        newRow.querySelectorAll('input').forEach(input => input.value = '');
        document.getElementById('discounts').appendChild(newRow);
    }
}

function removeProduct(button) {
    const row = button.parentElement.parentElement;
    row.remove();
}

$(document).ready(function () {
    $('#myTable').DataTable({
        destroy: true,
        scrollY: "200px"
    }); // Khởi tạo DataTable
    $('.dt-search label').text("Tìm kiếm: ");
    $('.dt-search label').css("margin-right", "10px");
    $('.dt-length label').text("Số lượng hiển thị mỗi trang");
    $('.dt-length label').css("margin-left", "10px");
    $('.dt-info').css("display", "none");
    $('.dt-search input').css("width", "300px");
    $('table.dataTable th.dt-type-numeric').css("text-align", "center");
});

$('#editBtn').click(function () {
    window.scrollTo({top: 0, behavior: 'smooth'});
    $('#title').text('Chỉnh sửa giảm giá')
    $('#containerEditBtn').html(`<button class="style-update-btn" id="editBtn" type="submit">Cập nhật</button>`);
    $('#containerCancelBtn').html(`<button type="button" id="cancelEditBtn" class="style-cancel-btn">Hủy</button>`)
    $('#cancelEditBtn').click(function () {
        location.reload();
    });

    $('#nameDiscount').prop('disabled', false);

    $('#description').prop('disabled', false);

    $('.percent-discount').prop('disabled', false);

    $('.amount-limit').prop('disabled', false);

    $('#startDateDiscount').prop('disabled', false);

    $('#endDateDiscount').prop('disabled', false);

    $('.edit-hidden').removeClass('d-none');
});