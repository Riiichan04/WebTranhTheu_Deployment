package com.example.webtranhtheu_ltweb_nlu_nhom26.dao;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Category;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.product.ConcreateProductDetail;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.product.DisplayFullProduct;
import com.example.webtranhtheu_ltweb_nlu_nhom26.db.JDBIConnector;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.LinkedList;
import java.util.List;

public interface CategoryDAO {
    @SqlQuery("""
        select products.id
        from products
            join category_products_details
            on products.id = category_products_details.productId
            join categories
            on category_products_details.categoryId = categories.id
        where categories.title like :categoryName
    """)
    List<Integer> getListIdInCategory(@Bind("categoryName") String categoryName);
//    private static List<Category> getCategories() {
//        return JDBIConnector.getInstance().withHandle(handle ->
//                handle.createQuery("select * from categories").mapToBean(Category.class).list());
//    }
//
//    private static List<Product> getProductByCategory(int categoryId) {
//        List<Integer> listProductIdByCategory = JDBIConnector.getInstance().withHandle(handle ->
//                handle.createQuery("select productId " +
//                                "from category_product_details " +
//                                "join categories on category_product_details.categoryId = categories.id" +
//                                "where categories.id = :categoryId")
//                        .bind("categoryId", categoryId).mapToBean(Integer.class).list());
//
//        List<Product> listProduct = new LinkedList<>();
//        for (Integer productId : listProductIdByCategory) {
//            listProduct.add(new DisplayFullProduct(new ConcreateProductDetail()).getFullProductInfo(productId));
//        }
//        return listProduct;
//    }
}
