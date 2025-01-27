package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.admin.product;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Provider;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.ProductService;
import com.example.webtranhtheu_ltweb_nlu_nhom26.util.CloudinaryConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UpdateProductController", value = "/admin/product-management/update-product")
@MultipartConfig
public class UpdateProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("productId");
        String productCode = request.getParameter("product-code");
        String productName = request.getParameter("name-product");
        String productDescription = request.getParameter("description");
        String[] delImg = request.getParameterValues("del-img-product") == null ? new String[0] : request.getParameterValues("del-img-product");

        List<String> addImg = new ArrayList<>();
        for (Part part : request.getParts()) {
            String contentDisp = part.getHeader("content-disposition");
            String contentType = part.getContentType();
            if (contentDisp != null && contentDisp.contains("filename") && contentType != null && contentType.startsWith("image/")) {
                addImg.add(CloudinaryConfig.getUrl(part));
            }
        }
        String[] listProductPrice = request.getParameterValues("listProductPrice[]") == null ? new String[0] : request.getParameterValues("listProductPrice[]");
        String[] priceProductPrice = request.getParameterValues("price-product-price") == null ? new String[0] : request.getParameterValues("price-product-price");
        String[] availableProductPrice = request.getParameterValues("available-product-price") == null ? new String[0] : request.getParameterValues("available-product-price");
        String[] widthProductPrice = request.getParameterValues("width-product-price") == null ? new String[0] : request.getParameterValues("width-product-price");
        String[] heightProductPrice = request.getParameterValues("height-product-price") == null ? new String[0] : request.getParameterValues("height-product-price");
        String[] delProductPrice = request.getParameterValues("delProductPrice[]") == null ? new String[0] : request.getParameterValues("delProductPrice[]");

        String[] addPriceProductPrice = request.getParameterValues("add-price-product-price") == null ? new String[0] : request.getParameterValues("add-price-product-price");
        String[] addAvailableProductPrice = request.getParameterValues("add-available-product-price") == null ? new String[0] : request.getParameterValues("add-available-product-price");
        String[] addWidthProductPrice = request.getParameterValues("add-width-product-price") == null ? new String[0] : request.getParameterValues("add-width-product-price");
        String[] addHeightProductPrice = request.getParameterValues("add-height-product-price") == null ? new String[0] : request.getParameterValues("add-height-product-price");

        String[] materials = request.getParameterValues("material-product") == null ? new String[0] : request.getParameterValues("material-product");

        String provider = request.getParameter("provider");
        String[] delReview = request.getParameterValues("del-review-product") == null ? new String[0] : request.getParameterValues("del-review-product");
        String type = request.getParameter("type");
        String status = request.getParameter("status");
        Provider pro = new Provider();
        pro.setId(Integer.parseInt(provider));
        Product p = new Product(Integer.parseInt(productId), productCode, productName, productDescription, pro, Integer.parseInt(status), Integer.parseInt(type));

        ProductService productService = new ProductService();
        productService.updateProduct(p, delImg, addImg, materials);
        productService.deleteProductReview(delReview);
        productService.updateProductPrice(listProductPrice, priceProductPrice, availableProductPrice, widthProductPrice, heightProductPrice, delProductPrice);
        productService.addProductPrice(Integer.parseInt(productId), addPriceProductPrice, addAvailableProductPrice, addWidthProductPrice, addHeightProductPrice);
    }
}