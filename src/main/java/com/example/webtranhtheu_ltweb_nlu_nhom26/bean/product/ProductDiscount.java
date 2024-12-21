package com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class ProductDiscount implements Serializable {
    private int id;
    private String title;
    private int available;
    private Timestamp startedAt;
    private Timestamp endedAt;

    public ProductDiscount() {
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

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
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
}
