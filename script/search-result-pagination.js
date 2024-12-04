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
        productItem.onclick = () => window.location = "../page/product.html"
        if (countProductPerRow === 4) {
            productItem.className = 'cursor-pointer col product-item mb-3 pe-0';
        } else productItem.className = 'cursor-pointer col product-item mb-3 pe-1';
        productItem.innerHTML = `<div class="card card-container w-100">
                        <img src="${product.url}"
                             class="card-img-top" alt="Product Image">
                        <div class="card-body">
                             <h6 class="card-title text-start pb-2">${product.name}</h6>

                            <!-- Star Ratings -->                                           
                            <div class="col d-flex justify-content-start comment-rating">
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
                                <p class="card-text text-center fw-semibold h5 mt-2"
                                   style="color: var(--sub-cta-button)">
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
    paginationHTML += `<nav aria-label="Page navigation example">
  <ul class="pagination">
    <li class="page-item ${currentPage === 1 ? 'disabled' : ''}">
      <a class="page-link" href="#" aria-label="Previous" onclick="changePage(${currentPage} - 1)"> 
        <span aria-hidden="true">&laquo;</span>
        <span class="sr-only">Previous</span>
      </a>
    </li>
    <li class="page-item"><a class="page-link" href="#">${currentPage}</a></li>
    <li class="page-item ${currentPage === totalPages ? 'disabled' : ''}">
      <a class="page-link" href="#" aria-label="Next" onclick="changePage(${currentPage} + 1)">
        <span aria-hidden="true">&raquo;</span>
        <span class="sr-only">Next</span>
      </a>
    </li>
  </ul>
</nav>`
    document.getElementById('pagination').innerHTML = paginationHTML;
}

function changePage(page) {
    setupPagination(page, totalPages);
    displayProducts(page);
}

// khoi dong trang
setupPagination(1, totalPages);
displayProducts(1);