package com.example.webtranhtheu_ltweb_nlu_nhom26.services.product;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.dao.ProductDAO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.db.JDBIConnector;

public class ConcreateProductDetail implements ProductDetailService {
    ProductDAO productDAO;

    public ConcreateProductDetail() {
        this.productDAO = JDBIConnector.getInstance().onDemand(ProductDAO.class);
    }

    //Dùng để hiển thị thông tin product dưới dạng card
    @Override
    public Product getProductInfo(int productId) {
        return productDAO.getProductInfo(productId);
    }
}
