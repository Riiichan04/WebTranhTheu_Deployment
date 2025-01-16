package com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin;

import java.sql.Timestamp;

public class DiscountDTO {
    private int id;
    private String title;
    private double value;
    private Timestamp startedAt;
    private Timestamp endedAt;

    public DiscountDTO() {}


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public void setStartedAt(Timestamp startedAt) {
        this.startedAt = startedAt;
    }

    public void setEndedAt(Timestamp endedAt) {
        this.endedAt = endedAt;
    }

    public Timestamp getStartedAt() {
        return startedAt;
    }

    public Timestamp getEndedAt() {
        return endedAt;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
