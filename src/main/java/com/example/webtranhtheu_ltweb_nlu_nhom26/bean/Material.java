package com.example.webtranhtheu_ltweb_nlu_nhom26.bean;

import java.io.Serializable;

public class Material implements Serializable {
    private String name;

    public Material(String name) {
        this.name = name;
    }

    public Material() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
