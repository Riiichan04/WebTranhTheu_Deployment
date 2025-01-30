package com.example.webtranhtheu_ltweb_nlu_nhom26.bean.user;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;

import java.io.Serializable;
import java.util.LinkedList;

public class ViewedHistory implements Serializable {
    public static int MAX_PRODUCTS= 10;
    private static ViewedHistory instance;
    private LinkedList<Product> viewedProducts;
    public ViewedHistory() {
        this.viewedProducts = new LinkedList<>();
    }
    public static ViewedHistory getInstance() {
        if (instance == null) {
            instance = new ViewedHistory();
        }
        return instance;
    }
    public boolean addProduct(Product product) {
        if(!this.viewedProducts.contains(product)) {
            if(this.viewedProducts.size() < MAX_PRODUCTS) {
                viewedProducts.addFirst(product);
            }
            else{
                viewedProducts.removeLast();
                viewedProducts.addFirst(product);
                return true;
            }
        }
        else{
            if (this.viewedProducts.size() >= MAX_PRODUCTS) {
                this.viewedProducts.removeLast();
            }
            this.viewedProducts.remove(product);
            this.viewedProducts.addFirst(product);
            return true;
        }
        return false;
    }
    public boolean removeProduct(Product product) {
        if(this.viewedProducts.contains(product)) {
            this.viewedProducts.remove(product);
            return true;
        }
        return false;
    }

    public LinkedList<Product> getViewedProducts() {
        return viewedProducts;
    }

    public void setViewedProducts(LinkedList<Product> viewedProducts) {
        this.viewedProducts = viewedProducts;
    }
}
