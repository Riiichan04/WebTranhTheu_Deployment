package com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin;

public class ProductDTO {
    private int id;
    private String code;
    private String title;
    private String imgUrl;
    private int available;
    private double totalStar;
    private int countEvaluate;
    private int status;

    public ProductDTO(int id, String code, String title, String imgUrl, int available, double totalStar, int countEvaluate, int status) {
        this.id = id;
        this.code = code;
        this.title = title;
        this.imgUrl = imgUrl;
        this.available = available;
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

    public String getTitle() {
        return title;
    }

    public String getImgUrl() {
        return imgUrl;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getAvailable() {
        return available;
    }
}
