function loadPage(page) {
    let content = document.getElementById("content")
    switch (page) {
        case "dashboard":
            content.innerHTML = "<iframe src='../../admin/dashboard.html' class='w-100 vh-100'></iframe>";
            break;
        case "product":
            content.innerHTML = "<iframe src='../../admin/manage-product.html' class='w-100 vh-100'></iframe>";
            break;
        case "user":
            content.innerHTML = "<iframe src='../../admin/manage-user.html' class='w-100 vh-100'></iframe>";
            break;
        case "promotion":
            content.innerHTML = "<iframe src='../../admin/manage-promotion.html' class='w-100 vh-100'></iframe>";
            break;
        case "category":
            content.innerHTML = "<iframe src='../../admin/manage-category.html' class='w-100 vh-100'></iframe>";
            break;
        case "topic":
            content.innerHTML = "<iframe src='../../admin/manage-topic.html' class='w-100 vh-100'></iframe>";
            break;
        case "order":
            content.innerHTML = "<iframe src='../../admin/manage-order.html' class='w-100 vh-100'></iframe>";
            break;
        case "policy":
            content.innerHTML = "<iframe src='../../admin/manage-policy.html' class='w-100 vh-100'></iframe>";
            break;
        case "setting":
            content.innerHTML = "<iframe src='../../admin/setting-user.html' class='w-100 vh-100'></iframe>";
            break;
    }
}
$(".select-nav").click(function () {
    loadPage(this.id);
    console.log(this.id)
    $('.select-nav.active').removeClass('active');
    this.classList.add('active');
});

//khoi tao
loadPage("dashboard");