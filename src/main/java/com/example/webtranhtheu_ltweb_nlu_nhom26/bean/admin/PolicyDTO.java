package com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin;

import java.sql.Timestamp;

public class PolicyDTO {
    private int id;
    private String name;
    private int countProduct;
    private Timestamp createdAt;

    public PolicyDTO(int id, String name, int countProduct, Timestamp createdAt) {
        this.id = id;
        this.name = name;
        this.countProduct = countProduct;
        this.createdAt = createdAt;
    }
    public PolicyDTO() {}
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setCountProduct(int countProduct) {
        this.countProduct = countProduct;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
