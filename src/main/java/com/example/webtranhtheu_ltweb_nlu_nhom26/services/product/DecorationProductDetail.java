package com.example.webtranhtheu_ltweb_nlu_nhom26.services.product;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.dao.ProductDAO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.db.JDBIConnector;

public abstract class DecorationProductDetail implements ProductDetailService {
    ProductDAO productDAO;

    public DecorationProductDetail() {
        this.productDAO = JDBIConnector.getInstance().onDemand(ProductDAO.class);
    }

    @Override
    public Product getProductInfo(int productId) {
        return productDAO.getProductInfo(productId);
    }
}
