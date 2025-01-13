package com.example.webtranhtheu_ltweb_nlu_nhom26.services.product;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.*;

import java.util.ArrayList;
import java.util.List;

public class DisplayFullProduct extends DecorationProductDetail {
    ProductDetailService wrapper;

    public DisplayFullProduct(ProductDetailService wrapper) {
        this.wrapper = wrapper;
    }

    public Product getFullProductInfo(int productId) {
        Product product = this.wrapper.getProductInfo(productId);
        product.setPolicy(this.getPolicy(productId));
        product.setProvider(this.getProvider(productId));
        product.setCategory(this.getCategory(productId));
        product.getListTopics().addAll(this.getListTopics(productId));
        product.getListPrices().addAll(this.getListPrices(productId));
        product.getListMaterials().addAll(this.getListMaterials(productId));
        product.getListImageUrls().addAll(this.getListImageUrls(productId));
        product.getListReviews().addAll(this.getListReviews(productId, 0)); //Mặc định offset = 0
        return product;
    }

    public Policy getPolicy(int productId) {
        return super.productDAO.getProductPolicy(productId);
    }

    public Provider getProvider(int productId) {
        return super.productDAO.getProductProvider(productId);
    }

    public Category getCategory(int productId) {
        return super.productDAO.getCategory(productId);
    }

    public List<Topic> getListTopics(int productId) {
        return super.productDAO.getTopics(productId);
    }

    public List<Price> getListPrices(int productId) {
        return super.productDAO.getProductPrices(productId);
    }

    public List<Material> getListMaterials(int productId) {
        return super.productDAO.getMaterials(productId);
    }

    public List<String> getListImageUrls(int productId) {
        return super.productDAO.getListImageUrls(productId);
    }

    public List<Review> getListReviews(int productId, int offset) { //Lấy 5 review
        //FIXME Thêm phần kiểm tra khi nào hết bình luận có thể lấy
        return super.productDAO.getProductReviews(productId, offset);
    }

    //Sẽ chuyển qua chỗ khác
    public List<Product> getSimilarProduct(int productId, int cagegoryId) {
        List<Integer> listId = super.productDAO.getSimilarProductId(productId, cagegoryId);
        List<Product> result = new ArrayList<>();
        for (int id : listId) {
            result.add(getFullProductInfo(id));
        }
        return result;
    }
}
