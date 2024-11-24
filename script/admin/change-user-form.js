function changeFormOnUser(btn) {
    $('#formWrapper').css({
        'display': 'flex',
        'justify-content': 'center',
        'align-items': 'center'
    });
    
    const formWrapper = document.getElementById('formWrapper');
    switch (btn) {
        case 'addUserBtn':
            formWrapper.innerHTML = `<iframe src="user-form/add-user-form.html" class="form-popup" id="addIframe"></iframe>`;
            const add_iframe = document.getElementById('addIframe');

            // Lắng nghe sự kiện load để đảm bảo iframe đã tải xong
            add_iframe.addEventListener('load', function () {
                const c = add_iframe.contentWindow;
                if(c.getHeightForm() < screen.height) {
                    $('#addIframe').css('height', (c.getHeightForm()+2) + 'px');
                } else {
                    $('#addIframe').addClass('h-100');
                }
            });
            break;
        case 'readAndEditUserBtn':
            formWrapper.innerHTML = `<iframe src="user-form/read-edit-user-form.html" class="form-popup" id="readAndEditIframe" style="width: 600px"></iframe>`;
            const re_iframe = document.getElementById('readAndEditIframe');

            // Lắng nghe sự kiện load để đảm bảo iframe đã tải xong
            re_iframe.addEventListener('load', function () {
                const c = re_iframe.contentWindow;
                if(c.getHeightForm() < screen.height) {
                    $('#readAndEditIframe').css('height', c.getHeightForm() + 'px');
                } else {
                    $('#readAndEditIframe').addClass('h-100');
                }
            });
            break;
        case 'deleteBtn':
            formWrapper.innerHTML = `<iframe src="user-form/delete-popup.html" class="form-popup" id="deleteIframe"></iframe>`;
            const del_iframe = document.getElementById('deleteIframe');

            // Lắng nghe sự kiện load để đảm bảo iframe đã tải xong
            del_iframe.addEventListener('load', function () {
                const c = del_iframe.contentWindow;
                if(c.getHeightForm() < screen.height) {
                    $('#deleteIframe').css('height', c.getHeightForm() + 'px');
                } else {
                    $('#deleteIframe').addClass('h-100');
                }
            });
            break;
    }
}

$('#myTable').DataTable().on('draw', function () {
    $('#addUserBtn').click(function () {
        changeFormOnUser(this.id);
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
        changeFormOnUser('readAndEditUserBtn');
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
        changeFormOnUser('deleteBtn');
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
