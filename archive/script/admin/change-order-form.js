function changeFormOnOrder(btn) {
    $('#formWrapper').css({
        'display': 'flex',
        'justify-content': 'center',
        'align-items': 'center'
    });
    
    const formWrapper = document.getElementById('formWrapper');
    switch (btn) {
        case 'addOrderBtn':
            formWrapper.innerHTML = `<iframe src="order-form/add-order-form.html" class="form-popup" id="addIframe"></iframe>`;
            $('#addIframe').css('height', 'calc(100vh - 40px)');
            break;
        case 'readAndEditUserBtn':
            formWrapper.innerHTML = `<iframe src="order-form/read-edit-order-form.html" class="form-popup" id="readAndEditIframe" height="633px"></iframe>`;
            break;
        case 'deleteBtn':
            formWrapper.innerHTML = `<iframe src="order-form/delete-popup.html" class="form-popup" id="deleteIframe"></iframe>`;
            const del_iframe = document.getElementById('deleteIframe');

            // Lắng nghe sự kiện load để đảm bảo iframe đã tải xong
            del_iframe.addEventListener('load', function () {
                const c = del_iframe.contentWindow;
                if(c.getHeightForm() < screen.height) {
                    $('#deleteIframe').css('height', c.getHeightForm() + 'px');
                } else {
                    $('#deleteIframe').css('height', 'calc(100vh - 40px)');
                }
            });
            break;
    }
}

$('#myTable').DataTable().on('draw', function () {
    $('#addOrderBtn').click(function () {
        changeFormOnOrder(this.id);
        $('#formWrapper').removeClass('hidden');

        $('#addIframe').on('load', function () {
            const iframeDoc = $(this).contents();
            // Gán sự kiện vào phần tử bên trong iframe
            iframeDoc.find('#cancelBtn').on('click', function () {
                hiddenOverlay();
            });
        });
    });

    $('.btn-read-edit').click(function () {
        changeFormOnOrder('readAndEditUserBtn');
        $('#formWrapper').removeClass('hidden');

        $('#readAndEditIframe').on('load', function () {
            const iframeDoc = $(this).contents();

            // Gán sự kiện vào phần tử bên trong iframe
            iframeDoc.find('#cancelBtn').on('click', function () {
                hiddenOverlay();
            });
        });

    });

    $('.btn-delete').click(function () {
        changeFormOnOrder('deleteBtn');
        $('#formWrapper').removeClass('hidden');

        $('#deleteIframe').on('load', function () {
            const iframeDoc = $(this).contents();

            // Gán sự kiện vào phần tử bên trong iframe
            iframeDoc.find('#cancelBtn').on('click', function () {
                hiddenOverlay();
            });
        });

    });

});

$('#formWrapper').click(function () {
    hiddenOverlay();
});

function hiddenOverlay() {
    $('#formWrapper').css({
        'display': 'none',
        'justify-content': 'none',
        'align-items': 'none'
    });
}
