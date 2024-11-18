function addAddress() {
    if (document.querySelectorAll('.address-row').length < 1) {
        const addressRow = document.createElement('div');
        addressRow.className = 'row form-group address-row mb-2';
        addressRow.innerHTML = `<div class="row ps-5 pb-2">
                            <span class="style-label">Địa chỉ 1</span>
                        </div>
                        <div class="col">
                            <div class="row">
                                <div class="col"><select class="style-select" disabled>
                                    <option selected>Việt Nam</option>
                                </select></div>
                                <div class="col">
                                    <select class="style-select">
                                        <option disabled selected>Chọn thành phố</option>
                                        <option>Tp. Hồ Chí Minh</option>
                                        <option>Tp 2</option>
                                        <option>Tp 3</option>
                                        <option>Tp 4</option>
                                        <option>Tp 5</option>
                                        <option>Tp 6</option>
                                        <option>Tp 7</option>
                                    </select>
                                </div>
                            </div>
                            <div class="row pt-2">
                                <div class="col">
                                    <select class="style-select">
                                        <option disabled selected>Chọn quận/huyện</option>
                                        <option>Tp. Thủ Đức</option>
                                        <option>Quận Bình Thạnh</option>
                                        <option>Quận 1</option>
                                        <option>Quận 3</option>
                                        <option>Quận 4</option>
                                    </select>
                                </div>
                                <div class="col">
                                    <select class="style-select">
                                        <option disabled selected>Chọn xã/phường</option>
                                        <option>Phường Linh Trung</option>
                                        <option>Phường 2</option>
                                        <option>Phường 3</option>
                                        <option>Phường 4</option>
                                        <option>Phường 5</option>
                                        <option>Phường 6</option>
                                        <option>Phường 7</option>
                                    </select>
                                </div>
                            </div>
                            <div class="row pt-2" style="padding-left: 12px; padding-right: 12px">
                                <input type="text" class="style-input" placeholder="Nhập tên đường, tòa nhà, số nhà,...">
                            </div>
                        </div>
                        <div class="col-1">
                            <i class="fa-solid fa-trash icon-del" onclick="removeAddress(this)"></i>
                        </div>`;
        document.getElementById('addresses').appendChild(addressRow);
    } else {
        const addressRow = document.querySelector('.address-row');
        const newRow = addressRow.cloneNode(true);
        newRow.querySelectorAll('input').forEach(input => input.value = '');
        document.getElementById('addresses').appendChild(newRow);
    }
}

function removeAddress(button) {
    button.parentElement.parentElement.remove();
}

// Chọn các phần tử
const fileInput = document.getElementById("fileInput");
const avatarImage = document.getElementById("avatarImage");
const editAvatar = document.getElementById("editAvatar");

// Bắt sự kiện khi nhấn vào icon chỉnh sửa
editAvatar.addEventListener("click", () => {
    fileInput.click(); // Kích hoạt input file
});

// Xử lý khi người dùng chọn file
fileInput.addEventListener("change", () => {
    const file = fileInput.files[0];
    if (file) {
        const reader = new FileReader();
        reader.onload = (e) => {
            avatarImage.src = e.target.result; // Đổi ảnh avatar
        };
        reader.readAsDataURL(file);
    }
});

$(document).ready(function () {
    $('#myTable').DataTable( {
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
    window.scrollTo({ top: 0, behavior: 'smooth' });
    $('#title').text('Chỉnh sửa thông tin người dùng')
    $('#containerEditBtn').html(`<button class="style-update-btn" id="editBtn" type="submit">Cập nhật</button>`);
    $('#containerCancelBtn').html(`<button type="button" id="cancelEditBtn" class="style-cancel-btn">Hủy</button>`)
    $('#cancelEditBtn').click(function () {
        location.reload();
    });

    $('#password').prop('disabled', false);

    $('#name').prop('disabled', false);

    $('#email').prop('disabled', false);

    $('#phone').prop('disabled', false);

    $('.gender').prop('disabled', false);

    $('#description').prop('disabled', false);
    
    $('.location').prop('disabled', false);
    
    $('#titleFavourProduct').text('Xóa sản phẩm yêu thích (Chọn nhiều)');
    
    $('#favourProduct').prop('disabled', false);

    $('.quantity-product').prop('disabled', false);
    
    $('.edit-hidden').removeClass('d-none');
});