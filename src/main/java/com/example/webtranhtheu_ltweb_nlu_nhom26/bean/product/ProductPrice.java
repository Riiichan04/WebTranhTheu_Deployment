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

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }
}
