package com.example.webtranhtheu_ltweb_nlu_nhom26.dao;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.ProductCategory;
import com.example.webtranhtheu_ltweb_nlu_nhom26.db.JDBIConnector;

import java.util.LinkedList;
import java.util.List;

public class CategoryDAO {
    private static List<ProductCategory> getCategories() {
        return JDBIConnector.getInstance().withHandle(handle ->
                handle.createQuery("select * from categories").mapToBean(ProductCategory.class).list());
    }

    private static List<Product> getProductByCategory(int categoryId) {
        List<Integer> listProductIdByCategory = JDBIConnector.getInstance().withHandle(handle ->
                handle.createQuery("select productId " +
                                "from category_product_details " +
                                "join categories on category_product_details.categoryId = categories.id" +
                                "where categories.id = :categoryId")
                        .bind("categoryId", categoryId).mapToBean(Integer.class).list());

        List<Product> listProduct = new LinkedList<>();
        for (Integer productId : listProductIdByCategory) {
            listProduct.add(ProductDAO.getProductById(productId));
        }
        return listProduct;
    }
}
