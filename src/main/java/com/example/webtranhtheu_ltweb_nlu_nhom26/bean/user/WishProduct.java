package com.example.webtranhtheu_ltweb_nlu_nhom26.bean.user;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;

import java.io.Serializable;
import java.sql.Timestamp;

public class WishProduct implements Serializable {
    private Product product;
    private Timestamp createdAt;

    public WishProduct(Product product, Timestamp createdAt) {
        this.product = product;
        this.createdAt = createdAt;
    }

    public WishProduct() {}

    public Product getProduct() {
        return product;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
