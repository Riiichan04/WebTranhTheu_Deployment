package com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin;

import java.sql.Timestamp;

public class OrderDTO {
    private int id;
    private String name;
    private String username;
    private double totalPrice;
    private Timestamp createdAt;
    private int orderStatus;
    private int paymentStatus;
    public OrderDTO() {}

    public OrderDTO(int id, String name, String username, double totalPrice, Timestamp createdAt, int orderStatus, int paymentStatus) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.totalPrice = totalPrice;
        this.createdAt = createdAt;
        this.orderStatus = orderStatus;
        this.paymentStatus = paymentStatus;
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

    public double getTotalPrice() {
        return totalPrice;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public int getPaymentStatus() {
        return paymentStatus;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setPaymentStatus(int paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
