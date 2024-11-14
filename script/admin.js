function loadPage(page) {
    let content = document.getElementById("content")
    switch (page) {
        case "home":
            content.innerHTML = "<iframe src='content-admin-page/home.html' class='w-100 vh-100'></iframe>";
            break;
        case "product":
            content.innerHTML = "<iframe src='content-admin-page/manage-product.html' class='w-100 vh-100'></iframe>";
            break;
        case "user":
            content.innerHTML = "<iframe src='content-admin-page/manage-user.html' class='w-100 vh-100'></iframe>";
            break;
        case "promotion":
            content.innerHTML = "<iframe src='content-admin-page/manage-promotion.html' class='w-100 vh-100'></iframe>";
            break;
        case "category":
            content.innerHTML = "<iframe src='content-admin-page/manage-category.html' class='w-100 vh-100'></iframe>";
            break;
        case "order":
            content.innerHTML = "<iframe src='content-admin-page/manage-order.html' class='w-100 vh-100'></iframe>";
            break;
        case "policy":
            content.innerHTML = "<iframe src='content-admin-page/manage-policy.html' class='w-100 vh-100'></iframe>";
            break;
        case "setting":
            content.innerHTML = "<iframe src='content-admin-page/setting-user.html' class='w-100 vh-100'></iframe>";
            break;
    }
}
$(".select-nav").click(function () {
    loadPage(this.id);
    $('.select-nav.active').removeClass('active');
    this.classList.add('active');
});

//khoi tao
loadPage("home");