package com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin;

import java.sql.Timestamp;

public class PolicyDTO {
    private int id;
    private String title;
    private int countProduct;
    private Timestamp createdAt;

    public PolicyDTO(int id, String title, int countProduct, Timestamp createdAt) {
        this.id = id;
        this.title = title;
        this.countProduct = countProduct;
        this.createdAt = createdAt;
    }
    public PolicyDTO() {}
    
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getCountProduct() {
        return countProduct;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCountProduct(int countProduct) {
        this.countProduct = countProduct;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
