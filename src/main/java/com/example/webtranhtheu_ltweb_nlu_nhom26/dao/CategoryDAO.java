package com.example.webtranhtheu_ltweb_nlu_nhom26.dao;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Category;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.dao.mapper.CategoryNameMapper;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.product.ConcreateProductDetail;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.product.DisplayFullProduct;
import com.example.webtranhtheu_ltweb_nlu_nhom26.db.JDBIConnector;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindList;
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


    @SqlQuery("""
        select title, patternName
        from categories
        where active = 1
    """)
    @RegisterRowMapper(CategoryNameMapper.class)
    List<Category> getAllCategoriesName();

    @SqlQuery("""
        select products.id
        from products
            join category_products_details
            on products.id = category_products_details.productId
            join categories
            on category_products_details.categoryId = categories.id
        where categories.patternName like :categoryName
            and products.id in (<listId>)
            and products.status = 1
        limit :offset, :limit
    """)
    List<Integer> filterProductIdWithNameAndCategory(@Bind("categoryName") String categoryName, @Bind("offset") int offset, @Bind("limit") int limit, @BindList("listId") List<Integer> listId);

    @SqlQuery("""
        select products.id
        from products
        join category_products_details
            on products.id = category_products_details.productId
        join categories
            on category_products_details.categoryId = categories.id
        join topic_products_details
            on products.id = topic_products_details.productId
        join product_prices
            on products.id = product_prices.productId
        join product_reviews
            on products.id = product_reviews.productId
        where (categories.title like :categoryName or :categoryName is null)
            and (product_reviews.rating >= :rating or :rating is null)
            and ((:fromPrice is null and :toPrice is null) or product_prices.price between :fromPrice and :toPrice)
            and (topic_products_details.topicId in (<topicId>) or topicId is null)
        limit :offset, :limit
    """)
    List<Product> filterProduct(@Bind("categoryName") String categoryName, @BindList("topicId") List<Integer> topicId,
                                @Bind("rating") int rating,
                                @Bind("fromPrice") double fromPice, @Bind("toPrice") double toPrice,
                                @Bind("offset") int offset, @Bind("limit") int limit);
}
