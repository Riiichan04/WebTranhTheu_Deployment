package com.example.webtranhtheu_ltweb_nlu_nhom26.bean.cart;


import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Discount;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Price;

import java.io.Serializable;
import java.util.List;


public class CartProduct implements Serializable {
    private int productId; // lấy thông tin cố định của 1 product
    private int quantity; // số lượng đã cho vào giỏ hàng
    public static final int MAX_PER_PRODUCT = 5; // số lượng tối đa có thể thêm 1 loại sản phẩm
    public Price price; // lưu giá tiền đã chọn.
    public double totalPrice; // tính tổng tiền.
    public double finalPrice; // giá trị cuối cùng.


    public CartProduct(int productId, int quantity, Price price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice= getPrices();
    }

    public CartProduct() {


    }

    public double getPrices() {
        return price.getPrice() * quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public boolean updateBySize(Price price) {
        if(price==null) return false;
        this.price = price;
        return true;
    }
}