package com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Price implements Serializable {
    private int productId;  //Id sản phẩm
    private int width;  //Chiều dày của sản phẩm
    private int height; //Chiều cao của sản phẩm
    private double price;   //Giá tiền
    private int available;  //Số lượng tồn kho hiện tại

    public Price() {
    }

    public Price(int productId, int width, int height, double price, int available) {
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

    public String getDisplayPriceToString() {
        double tempPrice = this.price;
        String convertPrice = tempPrice + "";
        String result = "";
        if (tempPrice < 1000) return tempPrice + " VNĐ";
        else {
            int cursor = convertPrice.indexOf('.') != -1 ? convertPrice.indexOf('.') : convertPrice.length();
            String decimalPart = convertPrice.substring(convertPrice.indexOf('.'));
            System.out.println(cursor);
            while ((int) (tempPrice / 1000) > 0) {
                result = "." + convertPrice.substring(cursor-3, cursor) + result;
                cursor -= 3;
                tempPrice /= 1000;
            }
            int headVal = Math.max(cursor - 3, 0);
            result = convertPrice.substring(headVal, cursor) + result;//+ decimalPart;  (Do là VND nên bỏ decimalPart)
            return result + " VNĐ";
        }
    }
}

