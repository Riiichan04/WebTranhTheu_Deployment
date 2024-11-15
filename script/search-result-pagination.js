// Tạo dữ liệu sản phẩm mẫu
const products = Array.from({length: 1000}, (_, i) => ({
    url: 'https://www.thegioitranhtheu.com/media/catalog/product/cache/1/small_image/9df78eab33525d08d6e5fb8d27136e95/f/i/file_7_35.jpg',
    name: `Tranh thêu sông nước`,
    star: ['&#9733;', '&#9733;', '&#9733;', '&#9733;', '&#9733;'],
    price: '8.000.000 VNĐ'
}));

const productsPerPage = 20;
const totalPages = Math.ceil(products.length / productsPerPage);

function displayProducts(page) {
    const productList = document.getElementById("productList");
    productList.innerHTML = ""; //xoa san pham cu
    const start = (page - 1) * productsPerPage;
    const end = start + productsPerPage;
    const pageProducts = products.slice(start, end);

    // tao cac san pham trong cau truc html
    let countProductPerRow = 0;
    let rowProduct = document.createElement("div");
    rowProduct.className = "row pe-0";
    pageProducts.forEach(product => {
        if (countProductPerRow === 5) {
            productList.appendChild(rowProduct);
            countProductPerRow = 0;
            rowProduct = document.createElement("div");
            rowProduct.className = "row pe-0";
        }
        const productItem = document.createElement('div');
        if (countProductPerRow === 4) {
            productItem.className = 'col product-item mb-3 pe-0';
        } else productItem.className = 'col product-item mb-3 pe-1';
        productItem.innerHTML = `<div class="card card-container w-100">
                        <img src="${product.url}"
                             class="card-img-top" alt="Product Image">
                        <div class="card-body">
                             <h5 class="card-title">${product.name}</h5>

                            <!-- Star Ratings -->                                           
                             <div class="col d-flex justify-content-center comment-rating">
                            <div class="col-2 product-info__star-container   px-0">
                                <i class="fa-solid fa-star product-info__star" style="color: #4d6a55;"></i>
                                <div class="product-info__star-mask"></div>
                                <i class="fa-regular fa-star product-info__star-outline" style="color: #4d6a55;"></i>
                            </div>
                            <div class="col-2 product-info__star-container   px-0">
                                <i class="fa-solid fa-star product-info__star" style="color: #4d6a55;"></i>
                                <div class="product-info__star-mask"></div>
                                <i class="fa-regular fa-star product-info__star-outline" style="color: #4d6a55;"></i>
                            </div>
                            <div class="col-2 product-info__star-container   px-0">
                                <i class="fa-solid fa-star product-info__star" style="color: #4d6a55;"></i>
                                <div class="product-info__star-mask"></div>
                                <i class="fa-regular fa-star product-info__star-outline" style="color: #4d6a55;"></i>
                            </div>
                            <div class="col-2 product-info__star-container   px-0">
                                <i class="fa-solid fa-star product-info__star sample_half" style="color: #4d6a55;"></i>
                                <div class="product-info__star-mask"></div>
                                <i class="fa-regular fa-star product-info__star-outline" style="color: #4d6a55;"></i>
                            </div>
                            <div class="col-2 product-info__star-container   px-0">
                                <i class="fa-solid fa-star product-info__star" style="color: #4d6a55;"></i>
                                <div class="product-info__star-mask" style="width: 100%"></div>
                                <i class="fa-regular fa-star product-info__star-outline" style="color: #4d6a55;"></i>
                            </div>
                        </div>
                        
                             <p class="card-text">
                                 ${product.price}
                             </p>
                        </div>
                    </div>`;
        rowProduct.appendChild(productItem);
        countProductPerRow++;
    });
}

function setupPagination(currentPage, totalPages) {
    let paginationHTML = '';
    
    //Nút Previous
    if (currentPage > 1) {
        paginationHTML += `<li class="btn-pagination"><a href="#" onclick="changePage(${currentPage - 1});">Trước</a></li>`
    } else {
        paginationHTML += `<li class="disabled btn-pagination"><span>Trước</span></li>`;
    }

    // Trang đầu tiên và dấu ...
    if (currentPage > 3) {
        paginationHTML += `<li class="btn-pagination"><a href="#" onclick="changePage(1)">1</a></li>`;
        paginationHTML += `<li class="btn-pagination" style="background-color: var(--label-color)"><span>...</span></li>`;
    }

    // Cac trang gan trang hien tai
    for (let i = Math.max(1, currentPage - 2); i <= Math.min(currentPage + 2, totalPages); i++) {
        if (i === currentPage) {
            paginationHTML += `<li class="btn-current-pagination"><span class="active">${i}</span></li>`;
        } else {
            paginationHTML += `<li class="btn-pagination"><a href="#" onclick="changePage(${i})">${i}</a></li>`;
        }
    }

    // Dau ... va trang cuoi cung
    if (currentPage < totalPages - 2) {
        paginationHTML += `<li class="btn-pagination" style="background-color: var(--label-color)"><span>...</span></li>`;
        paginationHTML += `<li class="btn-pagination"><a href="#" onclick="changePage(${totalPages})">${totalPages}</a></li>`;
    }

    //Nut next
    if (currentPage < totalPages) {
        paginationHTML += `<li class="btn-pagination"><a href="#" onclick="changePage(${currentPage + 1})">Sau</a></li>`;
    } else {
        paginationHTML += `<li class="disabled btn-pagination"><span>Next</span></li>`;
    }

    document.getElementById('pagination').innerHTML = paginationHTML;
}

function changePage(page) {
    setupPagination(page, totalPages);
    displayProducts(page);
}

// khoi dong trang
setupPagination(1, totalPages);
displayProducts(1);