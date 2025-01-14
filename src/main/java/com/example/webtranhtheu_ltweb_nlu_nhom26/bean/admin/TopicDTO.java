package com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin;

import java.sql.Timestamp;

public class TopicDTO {
    private int id;
    private String title;
    private int quantity;
    private int numProductBought;
    private Timestamp createdAt;
    private int active;

    public TopicDTO(int id, String title, int quantity, int numProductBought, Timestamp createdAt, int active) {
        this.id = id;
        this.title = title;
        this.quantity = quantity;
        this.numProductBought = numProductBought;
        this.createdAt = createdAt;
        this.active = active;
    }

    public TopicDTO() {}

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getNumProductBought() {
        return numProductBought;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public int getActive() {
        return active;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setNumProductBought(int numProductBought) {
        this.numProductBought = numProductBought;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
