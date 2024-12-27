package com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product;

import java.io.Serializable;
import java.sql.Timestamp;

public class Policy implements Serializable {
    private String title;
    private String description;
//    private Timestamp createAt;
//    private Timestamp updateAt;

    public Policy() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //    public Timestamp getCreateAt() {
//        return createAt;
//    }
//
//    public void setCreateAt(Timestamp createAt) {
//        this.createAt = createAt;
//    }
//
//    public Timestamp getUpdateAt() {
//        return updateAt;
//    }
//
//    public void setUpdateAt(Timestamp updateAt) {
//        this.updateAt = updateAt;
//    }
}
