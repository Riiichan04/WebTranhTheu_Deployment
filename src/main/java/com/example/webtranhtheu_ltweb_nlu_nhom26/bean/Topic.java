package com.example.webtranhtheu_ltweb_nlu_nhom26.bean;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.ProductTopic;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Topic implements Serializable {
    Map<ProductTopic, List<Product>> listProduct;

    public Topic() {
    }

    public Map<ProductTopic, List<Product>> getListProduct() {
        return listProduct;
    }

    public void setListProduct(Map<ProductTopic, List<Product>> listProduct) {
        this.listProduct = listProduct;
    }
}
