package com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin;


import java.sql.Timestamp;

public class UserDTO {
    private int id;
    private String fullName;
    private String username;
    private int numOrderBought;
    private int gender;
    private Timestamp createdAt;
    private int statusAccount;

    public UserDTO(int id, String fullName, String username, int numOrderBought, int gender, Timestamp createdAt, int statusAccount) {
        this.id = id;
        this.fullName = fullName;
        this.username = username;
        this.numOrderBought = numOrderBought;
        this.gender = gender;
        this.createdAt = createdAt;
        this.statusAccount = statusAccount;
    }

    public UserDTO() {}

    public void setId(int id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setNumOrderBought(int numOrderBought) {
        this.numOrderBought = numOrderBought;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUsername() {
        return username;
    }

    public int getNumOrderBought() {
        return numOrderBought;
    }

    public int getGender() {
        return gender;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setStatusAccount(int statusAccount) {
        this.statusAccount = statusAccount;
    }

    public int getStatusAccount() {
        return statusAccount;
    }
}
