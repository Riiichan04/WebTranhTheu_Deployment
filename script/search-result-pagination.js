// Tạo dữ liệu sản phẩm mẫu
const products = Array.from({ length: 50 }, (_, i) => ({
    url: 'https://www.thegioitranhtheu.com/media/catalog/product/cache/1/small_image/9df78eab33525d08d6e5fb8d27136e95/f/i/file_7_35.jpg',
    name: `Tranh thêu sông nước`,
    star: ['&#9733;', '&#9733;', '&#9733;', '&#9733;', '&#9733;'],
    price: '8.000.000 VNĐ'
}));

const productsPerPage = 20;
let currentPage = 1;
function displayProducts(page) {
    const productList = document.getElementById("productList");
    productList.innerHTML = ""; //xoa san pham cu
    const start = (page - 1)*productsPerPage;
    const end = start + productsPerPage;
    const  pageProducts = products.slice(start, end);

    // tao cac san pham trong cau truc html

    pageProducts.forEach(product => {
        const productItem = document.createElement('div');
        productItem.className = 'col-3 product-item mb-3';
        productItem.innerHTML = `<div class="card card-container w-100">
                        <img src="${product.url}"
                             class="card-img-top" alt="Product Image">
                        <div class="card-body">
                            <h5 class="card-title">${product.name}</h5>

                            <!-- Star Ratings -->
                            <div class="mb-2">
                                <span class="text-warning">${product.star[0]}</span>
                                <span class="text-warning">${product.star[1]}</span>
                                <span class="text-warning">${product.star[2]}</span>
                                <span class="text-warning">${product.star[3]}</span>
                                <span class="text-muted">${product.star[4]}</span> <!-- Đánh giá sao -->
                            </div>

                            <p class="card-text font-weight-bold text-danger" style="font-weight: 500">
                            Giá: ${product.price}
                            </p>
                        </div>
                    </div>`;
        productList.appendChild(productItem);
    });
}

function setupPagination() {
    const pagination = document.getElementById('pagination');
    const totalPages = Math.ceil(products.length / productsPerPage);

    pagination.innerHTML = "";

    for(let i = 1; i <= totalPages; i++) {
        const  pageItem = document.createElement("li");
        const  pageLink = document.createElement("a");
        pageLink.textContent = i;
        pageLink.addEventListener("click", (event) => {
            event.preventDefault();
            currentPage = i;
            displayProducts(currentPage);
            setupPagination();
        });

        pageItem.appendChild(pageLink);
        pagination.appendChild(pageItem);
    }
}

// khoi dong trang
displayProducts(currentPage);
setupPagination();