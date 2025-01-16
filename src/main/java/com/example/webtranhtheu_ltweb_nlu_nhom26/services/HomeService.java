package com.example.webtranhtheu_ltweb_nlu_nhom26.services;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.dao.ProductDAO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.db.JDBIConnector;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.product.ConcreateProductDetail;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.product.DisplayCardProduct;

import java.util.LinkedList;
import java.util.List;

public class HomeService {
    ProductDAO productDAO;

    public HomeService() {
        this.productDAO = JDBIConnector.getInstance().onDemand(ProductDAO.class);
    }

    public List<Product> getMostRatedProduct() {
        List<Integer> listProductId = this.productDAO.getMostRatedProductsId();
        List<Product> listProduct = new LinkedList<>();
        for (int id : listProductId) {
            listProduct.add(new DisplayCardProduct(new ConcreateProductDetail()).getDisplayProductInfo(id));
        }
        return listProduct;
    }

    public List<Product> getHotProduct() {
        List<Integer> listProductId = this.productDAO.getIdOfHotProduct();
        List<Product> listProduct = new LinkedList<>();
        for (int id : listProductId) {
            listProduct.add(new DisplayCardProduct(new ConcreateProductDetail()).getDisplayProductInfo(id));
        }
        return listProduct;
    }
}
