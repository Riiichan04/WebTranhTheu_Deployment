package com.example.webtranhtheu_ltweb_nlu_nhom26.services;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.ProductReview;
import com.example.webtranhtheu_ltweb_nlu_nhom26.dao.ProductDAO;

public class ProductService {
    public static double getProductRating(Product product) {
        return product.getListReview().stream().mapToInt(ProductReview::getRating).average().orElse(0.0);
    }
    public static Product getProduct(int id) {
        return ProductDAO.getProductById(id);
    }
}
