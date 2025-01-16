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
        select patternName
        from categories
        where patternName = :categoryName
    """)
    String getCategoryPatternName(@Bind("categoryName") String categoryName);

    @SqlQuery("""
        select products.id
        from products
            join category_products_details
            on products.id = category_products_details.productId
            join categories
            on category_products_details.categoryId = categories.id
        where categories.patternName like :categoryName
        limit :offset, :limit
    """)
    List<Integer> getListIdInCategory(@Bind("categoryName") String categoryName, @Bind("offset") int offset, @Bind("limit") int limit);

    @SqlQuery("""
        select count(products.id)
        from products
            join category_products_details
            on products.id = category_products_details.productId
            join categories
            on category_products_details.categoryId = categories.id
        where categories.patternName like :categoryName
    """)
    int countProductByCategory(@Bind("categoryName") String categoryName);
}
