package com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin.orderAdmin;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;

public class OrderDetails {
    private Product product;
    private int amount;
    private int width;
    private int height;
    private double price;

    public OrderDetails() {

    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public int getAmount() {
        return amount;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public double getPrice() {
        return price;
    }
}
