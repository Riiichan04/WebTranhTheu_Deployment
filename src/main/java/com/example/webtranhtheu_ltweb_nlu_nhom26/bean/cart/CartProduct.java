package com.example.webtranhtheu_ltweb_nlu_nhom26.bean.cart;


import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Discount;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Price;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.ProductService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class CartProduct implements Serializable {
    private int id;
    private String title;
    private String thumbnailUrl;
    private List<Price> prices;
    private Discount discount;
    // lấy thông tin cố định của 1 product
    private int quantity; // số lượng đã cho vào giỏ hàng
    public static final int MAX_PER_PRODUCT = 5; // số lượng tối đa có thể thêm 1 loại sản phẩm
    public Price price; // lưu giá tiền đã chọn.
    public double totalPrice; // tính tổng tiền.


    public CartProduct(int id, String title, String thumbnailUrl, List<Price> prices) {
        this.id = id;
        this.title = title;
        this.thumbnailUrl = thumbnailUrl;
        this.prices = new ArrayList<>();
        this.prices.addAll(prices);
        this.totalPrice = getOriginalPrice();
    }

    public CartProduct(int id, String title, String thumbnailUrl, int quantity, Price price) {
        this.id = id;
        this.title = title;
        this.thumbnailUrl = thumbnailUrl;
        this.prices = new ArrayList<>();
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = getOriginalPrice();
    }

    public CartProduct() {
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTotalPrice() {
        if (this.discount == null) return price.getPrice() * quantity;
        else return (price.getPrice() * quantity) * (1 - discount.getValue());
    }

    public double getOriginalPrice() {
        return price.getPrice() * quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
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

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public boolean updateBySize(int width, int height) {
        for (Price price : prices) {
            if (price.getWidth() == width && price.getHeight() == height) {
                this.price = price;
                return true;
            }
        }
        return false;
    }


    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }

    @Override
    public String toString() {
        return "CartProduct{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", totalPrice=" + totalPrice +
                '}';
    }

    public String displayTotalPrice() {
        return ProductService.getDisplayPriceToString(this.getOriginalPrice());
    }

    public String displayDiscountedPriceToString() {
        if (discount == null) return displayTotalPrice();
        else {
            return ProductService.getDisplayPriceToString(this.getTotalPrice());
        }
    }

    public String displayElementPrice() {
        return this.price.getDisplayPriceToString();
    }

    public String displayElementDiscountPrice() {
        if (this.discount == null || this.discount.getId() == 0) return displayElementPrice();
        else return this.price.displayDiscountedPriceToString(this.discount);
    }
}