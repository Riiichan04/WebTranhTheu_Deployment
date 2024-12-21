package com.example.webtranhtheu_ltweb_nlu_nhom26.bean.cart;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.User;

import java.io.Serializable;
import java.util.Map;

public class Cart implements Serializable {
    private int id;
    private User user;
    private static final int MAX_PRODUCTS = 10;
    private String createdAt;
    private String updatedAt;
    private Map<Integer,CartProduct> listProducts;

}
