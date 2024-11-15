function changeFormOnPromotion(btn) {
    const formWrapper = document.getElementById('formWrapper');
    switch (btn) {
        case 'addPromotionBtn':
            formWrapper.innerHTML = `<iframe src="promotion-form/add-promotion-form.html" class="w-100 h-100" id="addIframe"></iframe>`;
            break;
        case 'readAndEditUserBtn':
            formWrapper.innerHTML = `<iframe src="promotion-form/read-edit-promotion-form.html" class="w-100 h-100" id="readAndEditIframe"></iframe>`;
            break;
        case 'deleteBtn':
            formWrapper.innerHTML = `<iframe src="promotion-form/delete-popup.html" class="w-100 h-100" id="deleteIframe"></iframe>`;
            break;
    }
}

$('#myTable').DataTable().on('draw', function () {
    $('#addPromotionBtn').click(function () {
        changeFormOnPromotion(this.id);
        $('#formWrapper').removeClass('hidden');

        $('#addIframe').on('load', function () {
            const iframeDoc = $(this).contents();

            // Gán sự kiện vào phần tử bên trong iframe
            iframeDoc.find('#cancelBtn').on('click', function () {
                $('#overlay').addClass('hidden');
                $('#formWrapper').addClass('hidden');
            });

            iframeDoc.find('#overlay').on('click', function () {
                $('#overlay').addClass('hidden');
                $('#formWrapper').addClass('hidden');
            });
        });
    });

    $('.btn-read-edit').click(function () {
        changeFormOnPromotion('readAndEditUserBtn');
        $('#formWrapper').removeClass('hidden');

        $('#readAndEditIframe').on('load', function () {
            const iframeDoc = $(this).contents();

            // Gán sự kiện vào phần tử bên trong iframe
            iframeDoc.find('#cancelBtn').on('click', function () {
                $('#overlay').addClass('hidden');
                $('#formWrapper').addClass('hidden');
            });

            iframeDoc.find('#overlay').on('click', function () {
                $('#overlay').addClass('hidden');
                $('#formWrapper').addClass('hidden');
            });
        });

    });

    $('.btn-delete').click(function () {
        changeFormOnPromotion('deleteBtn');
        $('#formWrapper').removeClass('hidden');

        $('#deleteIframe').on('load', function () {
            const iframeDoc = $(this).contents();

            // Gán sự kiện vào phần tử bên trong iframe
            iframeDoc.find('#cancelBtn').on('click', function () {
                $('#overlay').addClass('hidden');
                $('#formWrapper').addClass('hidden');
            });

            iframeDoc.find('#overlay').on('click', function () {
                $('#overlay').addClass('hidden');
                $('#formWrapper').addClass('hidden');
            });
        });

    });

});
