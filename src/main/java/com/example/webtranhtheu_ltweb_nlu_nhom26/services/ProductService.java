package com.example.webtranhtheu_ltweb_nlu_nhom26.services;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Review;
import com.example.webtranhtheu_ltweb_nlu_nhom26.dao.ProductDAO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.db.JDBIConnector;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

public class ProductService {
    private static ProductService instance;
    private static ProductDAO productDAO;
    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }
    public static ProductService getInstance() {
        if (instance == null) {
            Jdbi jdbi= JDBIConnector.getInstance();
            jdbi.installPlugin(new SqlObjectPlugin());
            productDAO = jdbi.onDemand(ProductDAO.class);
            instance = new ProductService(productDAO);
            return instance;
        }
        return instance;
    }
    //Lấy đánh giá trung bình của sản phẩm (Sẽ cho vào product)
    public static double getProductRating(Product product) {
        return product.getListReviews().stream().mapToInt(Review::getRating).average().orElse(0.0);
    }

    public Product getProduct(int productId) {
        //TODO
        return null;
    }
}
