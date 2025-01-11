package com.example.webtranhtheu_ltweb_nlu_nhom26.bean;

import java.sql.Timestamp;

public class User {
    private int id;
    private String avatarUrl;
    private String username;
    private String fullName;
    private String password;
    private String email;
    private String phone;
    private int gender;
    private String description;
    private int statusAccount;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private int role;

    public User() {}

    public User(String username, String fullName, String password, String email, Timestamp createdAt, Timestamp updatedAt, int role, int statusAccount) {
        this.username = username;
        this.fullName = fullName;
        this.password = password;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.role = role;
        this.statusAccount = statusAccount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatusAccount(int statusAccount) {
        this.statusAccount = statusAccount;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getUsername() {
        return username;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getGender() {
        return gender;
    }

    public String getDescription() {
        return description;
    }

    public int getStatusAccount() {
        return statusAccount;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public int getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
