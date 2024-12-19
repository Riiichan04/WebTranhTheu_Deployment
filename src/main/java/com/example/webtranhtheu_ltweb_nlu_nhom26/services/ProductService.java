package com.example.webtranhtheu_ltweb_nlu_nhom26.services;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.ProductPrice;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.ProductReview;
import com.example.webtranhtheu_ltweb_nlu_nhom26.dao.ProductDAO;

import java.util.Comparator;

public class ProductService {
    public static double getProductRating(Product product) {
        return product.getListReview().stream().mapToInt(ProductReview::getRating).average().orElse(0.0);
    }

    public static Product getProduct(int id) {
        return ProductDAO.getProductById(id);
    }

    public static ProductPrice getProductPrice(int id, int w, int h) {
        Product product = ProductDAO.getProductById(id);
        return product.getListPrice().stream().filter(obj -> obj.getWidth() == w && obj.getHeight() == h).toList().get(0);
    }

    //Hiển thị mặc định
    public static ProductPrice getMinProductPrice(int id) {
        Product product = ProductDAO.getProductById(id);
        return product.getListPrice().stream().min(Comparator.comparing(ProductPrice::getWidth).thenComparing(ProductPrice::getHeight)).orElse(null);
    }
}
