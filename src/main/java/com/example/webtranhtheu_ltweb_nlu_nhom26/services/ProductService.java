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

public class ProductService {
    private static ProductService instance;
    private static ProductDAO productDAO;

    public ProductService() {
        productDAO = JDBIConnector.getInstance().onDemand(ProductDAO.class);
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

        for (String material : materials) {
            productDAO.updateMaterial(Integer.parseInt(material), id);
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
        Policy policy = productDAO.getPolicyByProductId(id);
        product.setPolicy(policy);
        List<Material> listMaterial = productDAO.getListMaterialByProductId(id);
        product.setListMaterials(listMaterial);
        Provider provider = productDAO.getProviderByProductId(id);
        product.setProvider(provider);
        return product;
    }

    public void updateProduct(Product product, String[] delImg, List<String> addImg, String[] materials) {
        productDAO.updateProduct(product);
        for (int i = 0; i < delImg.length; i++) {
            productDAO.deleteProductImage(product.getId(), delImg[i]);
        }
        for(String img : addImg) {
            productDAO.insertProductImage(product.getId(), img);
        }
        productDAO.deleteProductReview(product.getId());
        productDAO.deleteMaterialProductDetails(product.getId());
        for (int i = 0; i < materials.length; i++) {
            productDAO.insertMaterialProductDetails(Integer.parseInt(materials[i]), product.getId());
        }
    }

    public void deleteProductReview(String[] delId) {
        for (int i = 0; i < delId.length; i++) {
            productDAO.deleteProductReview(Integer.parseInt(delId[i]));
        }
    }

    public void updateProductPrice(String[] listProductPrice, String[] priceProductPrice, String[] availableProductPrice, String[] widthProductPrice, String[] heightProductPrice, String[] delProductPrice) {
        for (int i = 0; i < priceProductPrice.length; i++) {
            if(containsDelProductPriceId(delProductPrice, listProductPrice[i])) {
                productDAO.deleteProductPrice(Integer.parseInt(listProductPrice[i]));
            } else {
                productDAO.updateProductPrice(Integer.parseInt(widthProductPrice[i]), Integer.parseInt(heightProductPrice[i]), Double.parseDouble(priceProductPrice[i]),
                        Integer.parseInt(availableProductPrice[i]), Integer.parseInt(listProductPrice[i]));
            }
        }
    }

    private boolean containsDelProductPriceId(String[] delProductPrice, String id) {
        for (int i = 0; i < delProductPrice.length; i++) {
            if (delProductPrice[i].equals(id)) {
                return true;
            }
        }
        return false;
    }

    public void addProductPrice(int productId, String[] addPriceProductPrice, String[] addAvailableProductPrice, String[] addWidthProductPrice, String[] addHeightProductPrice) {
        for (int i = 0; i < addPriceProductPrice.length; i++) {
            productDAO.insertProductPrice(productId, Integer.parseInt(addWidthProductPrice[i]), Integer.parseInt(addHeightProductPrice[i]), Double.parseDouble(addPriceProductPrice[i]), Integer.parseInt(addAvailableProductPrice[i]));
        }
    }

    public static List<Product> filterProduct(String categoryName, List<Integer> listTopicId, int rating, double fromPrice, double toPrice, String providerName, String productName, int offset, int amount) {
        List<Integer> listId = new ConcreteProductDetail().filterProduct(categoryName, listTopicId, rating, fromPrice, toPrice, providerName, productName, offset, amount);
        List<Product> products = new ArrayList<>();
        for (Integer id : listId) {
            products.add(new DisplayCardProduct(new ConcreteProductDetail()).getDisplayProductInfo(id));
        }
        return products;
    }

    public static List<Product> findProductsByName(String name, int page, int amount) {
        List<Integer> listProductId = new ConcreteProductDetail().findProductsIdByName(name, page, amount);
        List<Product> products = new ArrayList<>();
        for (int productId : listProductId) {
            products.add(new DisplayCardProduct(new ConcreteProductDetail()).getDisplayProductInfo(productId));
        }
        return products;
    }
}
