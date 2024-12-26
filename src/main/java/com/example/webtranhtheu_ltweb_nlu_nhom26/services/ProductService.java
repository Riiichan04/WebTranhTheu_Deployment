package com.example.webtranhtheu_ltweb_nlu_nhom26.services;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Review;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.product.DisplayCardProduct;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.product.ConcreateProductDetail;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.product.DisplayFullProduct;

public class ProductService {
    //Lấy đánh giá trung bình của sản phẩm (Sẽ cho vào product)
    public static double getProductRating(Product product) {
        return product.getListReviews().stream().mapToInt(Review::getRating).average().orElse(0.0);
    }

    public static Product getFullProductInfo(int productId) {
        return new DisplayFullProduct(new ConcreateProductDetail()).getFullProductInfo(productId);
    }

    public static Product getDisplayProductInfo(int productId) {
        return new DisplayCardProduct(new ConcreateProductDetail()).getDisplayProductInfo(productId);
    }
}
