package com.example.webtranhtheu_ltweb_nlu_nhom26.bean.cart;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.Material;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Provider;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.enums.ProductType;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.ProductDiscount;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.ProductPolicy;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.ProductPrice;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.ProductReview;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CartProduct implements Serializable {
    private int id;
    private static final int MAX_PRODUCTS= 5;
    private String productCode;
    private String title;
    private String description;
    private List<Material> materialList=new ArrayList<>();
    private Provider provider;
    private ProductPolicy policy;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private ProductType typeOfProduct;
    private List<ProductPrice> listPrice = new ArrayList<>();
    private List<Material> listMaterial = new ArrayList<>();
    private List<String> listImageUrl = new ArrayList<>();
    private List<ProductReview> listReview = new ArrayList<>();
    private List<ProductDiscount> listDiscount = new ArrayList<>();
    private int quantity;
    public CartProduct() {
    }

    public CartProduct(int id, String productCode, String title, String description, List<Material> materialList, Provider provider, ProductPolicy policy,Timestamp createdAt, Timestamp updatedAt, ProductType typeOfProduct, List<ProductPrice> listPrice, List<Material> listMaterial, List<String> listImageUrl, List<ProductReview> listReview, List<ProductDiscount> listDiscount,int quantity) {
        this.id = id;
        this.productCode = productCode;
        this.title = title;
        this.description = description;
        this.materialList = materialList;
        this.provider = provider;
        this.policy = policy;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.typeOfProduct = typeOfProduct;
        this.listPrice = listPrice;
        this.listMaterial = listMaterial;
        this.listImageUrl = listImageUrl;
        this.listReview = listReview;
        this.listDiscount = listDiscount;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
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

    public List<Material> getMaterialList() {
        return materialList;
    }

    public void setMaterialList(List<Material> materialList) {
        this.materialList = materialList;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    public ProductType getTypeOfProduct() {
        return typeOfProduct;
    }

    public void setTypeOfProduct(ProductType typeOfProduct) {
        this.typeOfProduct = typeOfProduct;
    }
}

