package com.example.webtranhtheu_ltweb_nlu_nhom26.dao.temp_dao;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;

public abstract class DecorationProductDAO {
    ProductDAO wrapper;

    public DecorationProductDAO(ProductDAO wrapper) {
        this.wrapper = wrapper;
    }

    public Product getProductInfo(int productId) {
        return wrapper.getProductInfo(productId);
    }
}
