package com.example.webtranhtheu_ltweb_nlu_nhom26.bean;

import java.io.Serializable;

public class Provider implements Serializable {
    private int prodiverId;
    private String prodiverName;
    private String address; //Còn sửa sau

    public Provider(int prodiverId, String prodiverName, String address) {
        this.prodiverId = prodiverId;
        this.prodiverName = prodiverName;
        this.address = address;
    }

    public Provider() {
    }

    public int getProdiverId() {
        return prodiverId;
    }

    public void setProdiverId(int prodiverId) {
        this.prodiverId = prodiverId;
    }

    public String getProdiverName() {
        return prodiverName;
    }

    public void setProdiverName(String prodiverName) {
        this.prodiverName = prodiverName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
