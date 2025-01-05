package com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin;

import java.sql.Timestamp;

public class TopicDTO {
    private int id;
    private String name;
    private int quantity;
    private int numProductBought;
    private Timestamp createdAt;
    private int status;

    public TopicDTO(int id, String name, int quantity, int numProductBought, Timestamp createdAt, int status) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.numProductBought = numProductBought;
        this.createdAt = createdAt;
        this.status = status;
    }

    public TopicDTO() {}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
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

    public int getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setNumProductBought(int numProductBought) {
        this.numProductBought = numProductBought;
    }

    public void setCreateAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
