package com.example.webtranhtheu_ltweb_nlu_nhom26.bean;

public class AuthDTO {
    private int id;
    private int statusAccount;
    private int role;

    public AuthDTO() {}

    public AuthDTO(int id, int statusAccount, int role) {
        this.id = id;
        this.statusAccount = statusAccount;
        this.role = role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStatusAccount(int statusAccount) {
        this.statusAccount = statusAccount;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public int getStatusAccount() {
        return statusAccount;
    }

    public int getRole() {
        return role;
    }
}
