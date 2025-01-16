package com.example.webtranhtheu_ltweb_nlu_nhom26.services;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin.ProductDTO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.*;
import com.example.webtranhtheu_ltweb_nlu_nhom26.dao.ProductDAO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.db.JDBIConnector;

import java.util.List;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.product.ConcreateProductDetail;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.product.DisplayCardProduct;

import java.util.ArrayList;

public class ProductService {

    //Cần lấy phần discount ra class này

    public static int countReviews(int id) {
        return new ConcreateProductDetail().countReviews(id);
    }

    public static int countProduct() {
        return new ConcreateProductDetail().countProducts();
    }

    //Lấy đánh giá trung bình của sản phẩm (Sẽ cho vào product)
    public static double getProductRating(int productId) {
        return new ConcreateProductDetail().getProductRating(productId);
    }

    ProductDAO productDAO;

    public ProductService() {
        productDAO = JDBIConnector.getInstance().onDemand(ProductDAO.class);
    }

    public List<Product> getAllListProductsCodeAndTitle() {
        return productDAO.getProductsCodeAndTitle();
    }

    public static List<Product> getOneProductsRow(int offset, int amount) {
        List<Product> products = new ArrayList<>();
        DisplayCardProduct productInfoGetter = new DisplayCardProduct(new ConcreateProductDetail());
        for (int i = offset; i < offset + amount; i++) {
            Product product = productInfoGetter.getDisplayProductInfo(i);
            products.add(product);
        }
        return products;
    }

    public List<ProductDTO> listProductsDTO() {
        return productDAO.getProductsDTO();
    }

    public List<Material> getMaterials() {
        return productDAO.getMaterials();
    }

    public List<Provider> getProviders() {
        return productDAO.getProviders();
    }

    public void addProduct(Product product, int providerId, String[] materials, List<Price> prices, List<String> listImg) {
        int id = productDAO.insertProduct(product);
        productDAO.updateProvider(providerId, id);

        for(int i = 0; i < materials.length; i++) {
            productDAO.updateMaterial(Integer.parseInt(materials[i]), id);
        }

        for(Price price : prices) {
            price.setProductId(id);
            productDAO.insertProductPrice(price);
        }

        for(String img : listImg) {
            productDAO.insertProductImage(id, img);
        }
    }
}
