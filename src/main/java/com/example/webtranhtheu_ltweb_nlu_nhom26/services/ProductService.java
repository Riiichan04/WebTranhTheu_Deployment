package com.example.webtranhtheu_ltweb_nlu_nhom26.services;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Review;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.product.ConcreateProductDetail;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.product.DisplayCardProduct;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    //Lấy đánh giá trung bình của sản phẩm (Sẽ cho vào product)
    public static double getProductRating(Product product) {
        return product.getListReviews().stream().mapToInt(Review::getRating).average().orElse(0.0);
    }

    public static List<Product> getOneProductsRow(int offset, int amount) {
        //FIXME: Thêm phần nhận biết đã lấy hết sản phẩm chưa
        //FIXME: Xử lý phần lấy giá nếu lấy thế này
        List<Product> products = new ArrayList<>();
        DisplayCardProduct productInfoGetter = new DisplayCardProduct(new ConcreateProductDetail());
        for (int i = offset; i < amount; i++) {
            Product product = productInfoGetter.getDisplayProductInfo(i);
            //TODO: Thêm phần xử lý trường hợp lấy ra bằng null (do lấy hết product hoặc do status = 0)
            products.add(product);
        }
        return products;
    }
}
