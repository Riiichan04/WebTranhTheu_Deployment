package com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product;

import java.io.Serializable;
import java.sql.Timestamp;

public class Discount implements Serializable {
    private int id;
    private String title;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp startedAt;
    private Timestamp endedAt;
    private double amount;
    public Discount() {
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

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Timestamp getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(Timestamp startedAt) {
        this.startedAt = startedAt;
    }

    public Timestamp getEndedAt() {
        return endedAt;
    }

    public void setEndedAt(Timestamp endedAt) {
        this.endedAt = endedAt;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
