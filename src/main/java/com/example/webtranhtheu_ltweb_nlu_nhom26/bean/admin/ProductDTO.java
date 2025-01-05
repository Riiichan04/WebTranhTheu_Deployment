package com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin;

public class ProductDTO {
    private int id;
    private String code;
    private String name;
    private String urlImg;
    private int quantity;
    private double totalStar;
    private int countEvaluate;
    private int status;

    public ProductDTO(int id, String code, String name, String urlImg, int quantity, double totalStar, int countEvaluate, int status) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.urlImg = urlImg;
        this.quantity = quantity;
        this.totalStar = totalStar;
        this.countEvaluate = countEvaluate;
        this.status = status;
    }

    public ProductDTO() {}

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public double getTotalStar() {
        return totalStar;
    }

    public int getCountEvaluate() {
        return countEvaluate;
    }

    public int getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public void setTotalStar(double totalStar) {
        this.totalStar = totalStar;
    }

    public void setCountEvaluate(int countEvaluate) {
        this.countEvaluate = countEvaluate;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}
