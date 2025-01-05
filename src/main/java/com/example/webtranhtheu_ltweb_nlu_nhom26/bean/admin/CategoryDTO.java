package com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin;

import java.sql.Timestamp;

public class CategoryDTO {
    private int id;
    private String name;
    private int quantity;
    private int numProductBought;
    private Timestamp createAt;
    private int status;

    public CategoryDTO(int id, String name, int quantity, int numProductBought, Timestamp createAt, int status) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.numProductBought = numProductBought;
        this.createAt = createAt;
        this.status = status;
    }

    public CategoryDTO() {}

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

    public Timestamp getCreateAt() {
        return createAt;
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

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
