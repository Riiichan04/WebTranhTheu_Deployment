package com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product;

import java.io.Serializable;
import java.sql.Timestamp;

public class ProductReview implements Serializable {
    private int accountId;
    private int rating;
    private String content;
    private Timestamp createTime;

    public ProductReview() {
    }

    public ProductReview(int accountId, int rating, String content, Timestamp createTime) {
        this.accountId = accountId;
        this.rating = rating;
        this.content = content;
        this.createTime = createTime;
    }
}
