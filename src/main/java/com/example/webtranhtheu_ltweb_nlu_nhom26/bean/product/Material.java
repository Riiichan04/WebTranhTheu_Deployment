package com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product;

import java.io.Serializable;

public class Material implements Serializable {
    private String title;

    public Material(String title) {
        this.title = title;
    }

    public Material() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
