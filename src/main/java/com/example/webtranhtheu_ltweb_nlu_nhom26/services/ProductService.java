package com.example.webtranhtheu_ltweb_nlu_nhom26.services;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Review;
import com.example.webtranhtheu_ltweb_nlu_nhom26.dao.temp_dao.CardProductDAO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.dao.temp_dao.ConcreateProductDAO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.dao.temp_dao.FullProductDAO;

import java.util.Comparator;

public class ProductService {
    //Lấy đánh giá trung bình của sản phẩm (Sẽ cho vào product)
    public static double getProductRating(Product product) {
        return product.getListReviews().stream().mapToInt(Review::getRating).average().orElse(0.0);
    }

    public static Product getFullProductInfo(int productId) {
        return new FullProductDAO(new ConcreateProductDAO()).getFullProductInfo(productId);
    }

    public static Product getDisplayProductInfo(int productId) {
        return new CardProductDAO(new ConcreateProductDAO()).getDisplayProductInfo(productId);
    }
}
