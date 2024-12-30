package com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product;

import java.io.Serializable;

public class Topic implements Serializable {
    private int id; //Id của topic
    private String title;    //Tên của topic
    private int active; //Trạng thái của topic

    public Topic() {
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

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
