package com.example.webtranhtheu_ltweb_nlu_nhom26.services;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Price;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Review;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.product.ConcreteProductDetail;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin.ProductDTO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.*;
import com.example.webtranhtheu_ltweb_nlu_nhom26.dao.ProductDAO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.db.JDBIConnector;

import java.util.List;

import com.example.webtranhtheu_ltweb_nlu_nhom26.services.product.DisplayCardProduct;

import java.util.ArrayList;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

public class ProductService {
    private static ProductService instance;
    private static ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public static ProductService getInstance() {
        if (instance == null) {
            Jdbi jdbi = JDBIConnector.getInstance();
            jdbi.installPlugin(new SqlObjectPlugin());
            productDAO = jdbi.onDemand(ProductDAO.class);
            instance = new ProductService(productDAO);
            return instance;
        }
        return instance;
    }

    //Cần lấy phần discount ra class này

    public static int countReviews(int id) {
        return new ConcreteProductDetail().countReviews(id);
    }

    public static int countProduct() {
        return new ConcreteProductDetail().countProducts();
    }

    //Lấy đánh giá trung bình của sản phẩm (Sẽ cho vào product)
    public static double getProductRating(int productId) {
        return new ConcreteProductDetail().getProductRating(productId);
    }

    public ProductService() {
        productDAO = JDBIConnector.getInstance().onDemand(ProductDAO.class);
    }

    public List<Product> getAllListProductsCodeAndTitle() {
        return productDAO.getProductsCodeAndTitle();
    }

    public static List<Product> getOneProductsRow(int offset, int amount) {
        List<Product> products = new ArrayList<>();
        DisplayCardProduct productInfoGetter = new DisplayCardProduct(new ConcreteProductDetail());
        for (int i = offset; i < offset + amount; i++) {
            Product product = productInfoGetter.getDisplayProductInfo(i);
            products.add(product);
        }
        return products;
    }

    public Product getProduct(int productId) {
        //TODO
        return productDAO.getProductInfo(productId);
    }

    public List<Price> getProductPrices(int productId) {
        return productDAO.getProductPrices(productId);
    }

    public List<String> getListImageUrls(int productId) {
        return productDAO.getListImageUrls(productId);
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

        for (int i = 0; i < materials.length; i++) {
            productDAO.updateMaterial(Integer.parseInt(materials[i]), id);
        }

        for (Price price : prices) {
            price.setProductId(id);
            productDAO.insertProductPrice(price);
        }

        for (String img : listImg) {
            productDAO.insertProductImage(id, img);
        }
    }

    public Product getProductById(int id) {
        Product product = productDAO.getProductById(id);
        Category c = productDAO.getCategoryById(product.getId());
        product.setCategory(c);
        List<Topic> topics = productDAO.getTopicById(product.getId());
        product.setListTopics(topics);
        List<Price> prices = productDAO.getPriceById(product.getId());
        product.setListPrices(prices);
        List<Review> reviews = productDAO.getReviewById(id);
        product.setListReviews(reviews);
        List<String> img = productDAO.getImgUrlById(id);
        product.setListImageUrls(img);
        return product;
    }


    public static List<Product> filterProduct(String categoryName, List<Integer> listTopicId, int rating, double fromPrice, double toPrice, String providerName, int offset, int amount) {
        List<Integer> listId = new ConcreteProductDetail().filterProduct(categoryName, listTopicId, rating, fromPrice, toPrice, providerName, offset, amount);
        List<Product> products = new ArrayList<>();
        for (Integer id : listId) {
            products.add(new DisplayCardProduct(new ConcreteProductDetail()).getDisplayProductInfo(id));
        }
        return products;
    }
}
