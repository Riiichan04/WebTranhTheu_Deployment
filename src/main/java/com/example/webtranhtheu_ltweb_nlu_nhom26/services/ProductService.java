package com.example.webtranhtheu_ltweb_nlu_nhom26.services;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Review;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.product.ConcreateProductDetail;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.product.DisplayCardProduct;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

    public static int countReviews(int id) {
        return new ConcreateProductDetail().countReviews(id);
    }

    public static int countProduct() {
        return new ConcreateProductDetail().countProducts();
    }
    //Lấy đánh giá trung bình của sản phẩm (Sẽ cho vào product)

    public static double getProductRating(int productId) {
        return new ConcreateProductDetail().getProductRating(productId);
    }

    public static List<Product> getOneProductsRow(int offset, int amount) {
        List<Product> products = new ArrayList<>();
        DisplayCardProduct productInfoGetter = new DisplayCardProduct(new ConcreateProductDetail());
        for (int i = offset; i < offset + amount; i++) {
            Product product = productInfoGetter.getDisplayProductInfo(i);
            products.add(product);
        }
        return products;
    }
}
