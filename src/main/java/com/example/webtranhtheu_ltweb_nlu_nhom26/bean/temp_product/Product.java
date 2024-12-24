package com.example.webtranhtheu_ltweb_nlu_nhom26.bean.temp_product;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.enums.ProductType;

import java.io.Serializable;
import java.util.List;

public class Product implements Serializable {
    private int id;
    private String code;
    private String title;
    private String description;
    private ProductType productType;
    List<Review> listReviews;
    List<Price> listPrices;
}
