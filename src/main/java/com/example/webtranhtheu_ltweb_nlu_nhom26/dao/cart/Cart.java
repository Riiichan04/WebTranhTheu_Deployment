package com.example.webtranhtheu_ltweb_nlu_nhom26.dao.cart;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.User;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.cart.CartProduct;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Cart implements Serializable {
    private int id;
    private static final int MAX_PRODUCTS = 10;
    private String createdAt;
    private String updatedAt;
    private User user;
    private Map<Integer, CartProduct> listProducts = new HashMap<>();

    public boolean add(Product product) {
        if (listProducts.containsKey(product.getId())) {
            return update(product.getId(), listProducts.get(product.getId()).getQuantity() + 1);
        }
        listProducts.put(product.getId(), convert(product));
        return true;
    }

    public boolean update(int productId, int quantity) {
        if (listProducts.containsKey(productId)) {
            CartProduct cartProduct = listProducts.get(productId);
            cartProduct.setQuantity(quantity);
            listProducts.put(cartProduct.getId(), cartProduct);
            return true;
        }
        return false;
    }

    public boolean remove(int productId) {
        return listProducts.remove(productId) != null;
    }

    public List<CartProduct> getListProducts() {
        return new ArrayList<>(listProducts.values());
    }

    public int getTotalQuantity() {
        AtomicInteger totalQuantity = new AtomicInteger(0);
        listProducts.values().forEach(product -> totalQuantity.addAndGet(product.getQuantity()));
        return totalQuantity.get();
    }

    public Double getTotalPrice() {
        //TODO
        Double totalPrice = 0.0;
        return totalPrice;
    }
    public CartProduct getProduct(int productId) {
        return listProducts.get(productId);
    }
    private CartProduct convert(Product product) {
        CartProduct cartProduct = new CartProduct();
        cartProduct.setId(product.getId());
        cartProduct.setProductCode(product.getCode());
        cartProduct.setTitle(product.getTitle());
        cartProduct.setDescription(product.getDescription());
        cartProduct.setListMaterial(product.getListMaterial());
        cartProduct.setProvider(product.getProvider());
        cartProduct.setPolicy(product.getPolicy());
        cartProduct.setCreatedAt(product.getCreatedAt());
        cartProduct.setUpdatedAt(product.getUpdatedAt());
        cartProduct.setTypeOfProduct(product.getType());
        cartProduct.setListPrice(product.getListPrice());
        cartProduct.setMaterialList(product.getListMaterial());
        cartProduct.setListImageUrl(product.getListImageUrl());
        cartProduct.setListReview(product.getListReview());
        cartProduct.setListDiscount(product.getListDiscount());
        cartProduct.setQuantity(1);
        return cartProduct;
    }
}
