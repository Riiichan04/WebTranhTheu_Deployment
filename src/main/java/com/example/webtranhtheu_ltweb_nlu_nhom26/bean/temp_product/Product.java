package com.example.webtranhtheu_ltweb_nlu_nhom26.bean.temp_product;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.enums.ProductType;

import java.io.Serializable;
import java.util.List;

public class Product implements Serializable {
    private int id;
    private String code;
    private String title;
    private String description;
    private ProductType productType;
    private List<Review> listReviews;
    private List<Price> listPrices;

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public List<Review> getListReviews() {
        return listReviews;
    }

    public void setListReviews(List<Review> listReviews) {
        this.listReviews = listReviews;
    }

    public List<Price> getListPrices() {
        return listPrices;
    }

    public void setListPrices(List<Price> listPrices) {
        this.listPrices = listPrices;
    }
}
