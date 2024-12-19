package com.example.webtranhtheu_ltweb_nlu_nhom26.bean;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.enums.ProductType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Product implements Serializable {
    private int id;
    private String code;
    private String title;
    private String description;
    private ProductType type;
    private Provider provider;
    private List<ProductPolicy> policies = new ArrayList<>(); //Còn sửa sau
    private List<ProductPrice> listPrice = new ArrayList<>();
    private List<Material> listMaterial = new ArrayList<>();
    private List<String> listImageUrl = new ArrayList<>();
    private List<ProductReview> listReview = new ArrayList<>();
    //Discount?

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public List<ProductPolicy> getPolicies() {
        return policies;
    }

    public void setPolicies(List<ProductPolicy> policies) {
        this.policies = policies;
    }

    public List<ProductPrice> getListPrice() {
        return listPrice;
    }

    public void setListPrice(List<ProductPrice> listPrice) {
        this.listPrice = listPrice;
    }

    public List<Material> getListMaterial() {
        return listMaterial;
    }

    public void setListMaterial(List<Material> listMaterial) {
        this.listMaterial = listMaterial;
    }

    public List<String> getListImageUrl() {
        return listImageUrl;
    }

    public void setListImageUrl(List<String> listImageUrl) {
        this.listImageUrl = listImageUrl;
    }

    public List<ProductReview> getListReview() {
        return listReview;
    }

    public void setListReview(List<ProductReview> listReview) {
        this.listReview = listReview;
    }
}
