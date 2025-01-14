package com.example.webtranhtheu_ltweb_nlu_nhom26.services;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Review;

import java.util.List;

public class ProductService {
    public static int countReviews(Product product) {
        return product.getListReviews().size();
    }

    //Lấy đánh giá trung bình của sản phẩm (Sẽ cho vào product)
    public static double getProductRating(Product product) {
        return product.getListReviews().stream().mapToInt(Review::getRating).average().orElse(0.0);
    }
}
