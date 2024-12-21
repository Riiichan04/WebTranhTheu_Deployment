package com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product;

import java.io.Serializable;

public class ProductPrice implements Serializable {
    private int productId;
    private int width;
    private int height;
    private double price;
    private int available;

    public ProductPrice() {
    }

    public ProductPrice(int productId, int width, int height, double price, int available) {
        this.productId = productId;
        this.width = width;
        this.height = height;
        this.price = price;
        this.available = available;
    }
}
