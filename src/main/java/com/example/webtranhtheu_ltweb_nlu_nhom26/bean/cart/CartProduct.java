package com.example.webtranhtheu_ltweb_nlu_nhom26.bean.cart;


import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Price;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class CartProduct implements Serializable {
    private int productId; // lấy thông tin cố định của 1 product
    private List<Price> prices;
    private int quantity; // số lượng đã cho vào giỏ hàng
    public static final int MAX_PER_PRODUCT = 5; // số lượng tối đa có thể thêm 1 loại sản phẩm
    public Price price; // lưu giá tiền đã chọn.
    public double totalPrice; // tính tổng tiền.


    public CartProduct(int productId, int quantity, Price price) {
        this.productId = productId;
        this.prices= new ArrayList<>();
        this.quantity = quantity;
        this.price = price;
        this.totalPrice= getTotalPrice();
    }

    public CartProduct() {


    }

    public double getTotalPrice() {
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


    public boolean updateBySize(int width, int height) {
        for(Price price : prices) {
            if(price.getWidth() == width && price.getHeight() == height) {
                this.price = price;
                return true;
            }
        }
        return false;
    }
}