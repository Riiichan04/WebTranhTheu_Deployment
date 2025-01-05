package com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin;


import java.sql.Timestamp;

public class UserDTO {
    private int id;
    private String name;
    private String username;
    private String phone;
    private int gender;
    private Timestamp createdAt;
    private int status;

    public UserDTO(int id, String name, String username, String phone, int gender, Timestamp createdAt, int status) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.phone = phone;
        this.gender = gender;
        this.createdAt = createdAt;
        this.status = status;
    }

    public UserDTO() {}

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPhone() {
        return phone;
    }

    public int getGender() {
        return gender;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
