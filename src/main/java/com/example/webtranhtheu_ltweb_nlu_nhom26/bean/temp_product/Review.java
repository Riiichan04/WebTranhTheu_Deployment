package com.example.webtranhtheu_ltweb_nlu_nhom26.bean.temp_product;

import java.io.Serializable;
import java.sql.Timestamp;

public class Review implements Serializable {
    private int accountId;
    private int rating;
    private String content;
    private Timestamp createTime;

    public Review() {
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
