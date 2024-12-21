package com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.Material;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.enums.ProductType;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Product implements Serializable {
    private int id;
    private String code;
    private String title;
    private String description;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private ProductType type;
    private Provider provider;
    private ProductPolicy policy;
    private List<ProductPrice> listPrice = new ArrayList<>();
    private List<Material> listMaterial = new ArrayList<>();
    private List<String> listImageUrl = new ArrayList<>();
    private List<ProductReview> listReview = new ArrayList<>();
    private List<ProductDiscount> listDiscount = new ArrayList<>();

    public Product() {
    }

    public Product(int id, String code, String title, String description, Timestamp createdAt, Timestamp updatedAt, ProductType type, Provider provider, ProductPolicy policy, List<ProductPrice> listPrice, List<Material> listMaterial, List<String> listImageUrl, List<ProductReview> listReview, List<ProductDiscount> listDiscount) {
        this.id = id;
        this.code = code;
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.type = type;
        this.provider = provider;
        this.policy = policy;
        this.listPrice = listPrice;
        this.listMaterial = listMaterial;
        this.listImageUrl = listImageUrl;
        this.listReview = listReview;
        this.listDiscount = listDiscount;
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

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
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

    public ProductPolicy getPolicy() {
        return policy;
    }

    public void setPolicy(ProductPolicy policy) {
        this.policy = policy;
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

    public List<ProductDiscount> getListDiscount() {
        return listDiscount;
    }

    public void setListDiscount(List<ProductDiscount> listDiscount) {
        this.listDiscount = listDiscount;
    }
}
