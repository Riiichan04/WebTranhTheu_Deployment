package com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product;

import java.io.Serializable;

public class Topic implements Serializable {
    private int id; //Id của topic
    private String name;    //Tên của topic
    private int active; //Trạng thái của topic

    public Topic() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
