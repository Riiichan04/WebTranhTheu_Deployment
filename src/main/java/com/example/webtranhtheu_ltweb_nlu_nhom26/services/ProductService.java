package com.example.webtranhtheu_ltweb_nlu_nhom26.services;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.ProductReview;

public class ProductService {
    public double getProductRating(Product product) {
        return product.getListReview().stream().mapToInt(ProductReview::getRating).average().orElse(0.0);
    }
}
