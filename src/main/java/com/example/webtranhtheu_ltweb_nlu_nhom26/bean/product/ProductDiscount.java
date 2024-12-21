package com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product;

import java.io.Serializable;
import java.sql.Timestamp;

public class ProductDiscount implements Serializable {
    private int id;
    private String title;
    private int available;
    private Timestamp startedAt;
    private Timestamp endedAt;

    public ProductDiscount() {
    }

    public ProductDiscount(int id, String title, int available, Timestamp startedAt, Timestamp endedAt) {
        this.id = id;
        this.title = title;
        this.available = available;
        this.startedAt = startedAt;
        this.endedAt = endedAt;
    }
}
