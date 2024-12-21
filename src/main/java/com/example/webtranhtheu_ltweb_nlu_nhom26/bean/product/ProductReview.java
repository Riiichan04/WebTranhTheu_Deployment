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

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
