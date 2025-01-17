package com.example.webtranhtheu_ltweb_nlu_nhom26.services.product;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Price;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.dao.ProductDAO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.db.JDBIConnector;

import java.util.Comparator;

public class DisplayCardProduct extends DecorationProductDetail {
    ProductDetailService wrapper;
    ProductDAO productDAO;

    public DisplayCardProduct(ProductDetailService wrapper) {
        this.wrapper = wrapper;
        this.productDAO = JDBIConnector.getInstance().onDemand(ProductDAO.class);
    }

    public Product getDisplayProductInfo(int productId) {
        Product product = super.getProductInfo(productId);
        product.getListPrices().addAll(this.productDAO.getProductPrices(productId).stream().sorted(Comparator.comparingDouble(Price::getPrice)).toList());
        product.getListImageUrls().add(this.productDAO.getThumbnail(productId));
        return product;
    }
}
