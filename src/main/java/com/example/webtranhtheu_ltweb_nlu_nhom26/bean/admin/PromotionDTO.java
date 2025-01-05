package com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin;

import java.sql.Timestamp;

public class PromotionDTO {
    private int id;
    private String name;
    private Timestamp startTime;
    private Timestamp endTime;
    private int countProduct;
    private int status;

    public PromotionDTO() {}

    public PromotionDTO(int id, String name, Timestamp startTime, Timestamp endTime, int countProduct, int status) {
        this.id = id;
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.countProduct = countProduct;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public int getCountProduct() {
        return countProduct;
    }

    public int getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public void setCountProduct(int countProduct) {
        this.countProduct = countProduct;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
