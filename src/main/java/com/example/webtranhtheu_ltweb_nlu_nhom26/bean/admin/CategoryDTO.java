package com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin;

import java.sql.Timestamp;

public class CategoryDTO {
    private int id;
    private String title;
    private int quantity;
    private int numProductBought;
    private Timestamp createdAt;
    private int active;

    public CategoryDTO(int id, String name, int quantity, int numProductBought, Timestamp createdAt, int active) {
        this.id = id;
        this.title = name;
        this.quantity = quantity;
        this.numProductBought = numProductBought;
        this.createdAt = createdAt;
        this.active = active;
    }

    public CategoryDTO() {}

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

    public void setTitle(String name) {
        this.title = name;
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

    public void setActive(int active) {
        this.active = active;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", quantity=" + quantity +
                ", numProductBought=" + numProductBought +
                ", createdAt=" + createdAt +
                ", status=" + active +
                '}';
    }
}
