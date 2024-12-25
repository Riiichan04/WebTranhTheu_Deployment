package com.example.webtranhtheu_ltweb_nlu_nhom26.dao.temp_dao;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.db.JDBIConnector;

public class CardProductDAO extends DecorationProductDAO {
    public CardProductDAO(ProductDAO wrapper) {
        super(wrapper);
    }

    public Product getDisplayProductInfo(int productId) {
        Product product = super.getProductInfo(productId);
        product.getListImageUrls().add(getThumbnail(productId));
        return product;
    }

    private String getThumbnail(int productId) {
        return JDBIConnector.getInstance().withHandle(handle ->
            handle.createQuery("select img_url from product_images where productId = :id limit 1")
                    .bind("id", productId)
                    .mapToBean(String.class).one());
    }
}
