function changeFormOnPolicy(btn) {
    const formWrapper = document.getElementById('formWrapper');
    switch (btn) {
        case 'addPolicyBtn':
            formWrapper.innerHTML = `<iframe src="policy-form/add-policy-form.html" class="w-100 h-100" id="addIframe"></iframe>`;
            break;
        case 'readAndEditUserBtn':
            formWrapper.innerHTML = `<iframe src="policy-form/read-edit-policy-form.html" class="w-100 h-100" id="readAndEditIframe"></iframe>`;
            break;
        case 'deleteBtn':
            formWrapper.innerHTML = `<iframe src="policy-form/delete-popup.html" class="w-100 h-100" id="deleteIframe"></iframe>`;
            break;
    }
}

$(document).ready(function () {
    $('#addPolicyBtn').click(function () {
        changeFormOnPolicy(this.id);
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
        changeFormOnPolicy('readAndEditUserBtn');
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
        changeFormOnPolicy('deleteBtn');
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
