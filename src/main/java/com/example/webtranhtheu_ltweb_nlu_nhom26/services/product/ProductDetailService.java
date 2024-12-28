package com.example.webtranhtheu_ltweb_nlu_nhom26.services.product;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Price;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;

import java.util.concurrent.atomic.AtomicInteger;

public interface ProductDetailService {
    Product getProductInfo(int productId);
}
