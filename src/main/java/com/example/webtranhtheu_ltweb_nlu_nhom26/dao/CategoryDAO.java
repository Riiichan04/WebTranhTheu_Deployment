package com.example.webtranhtheu_ltweb_nlu_nhom26.dao;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin.CategoryDTO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Category;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.dao.mapper.CategoryNameMapper;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.customizer.BindList;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.sql.Timestamp;
import java.util.List;

public interface CategoryDAO {
    //Dùng cho admin
    @SqlQuery("select x.id, x.title, x.createdAt, x.active, x.totalProduct as quantity, COALESCE(y.totalProductBuy, 0) as numProductBought from (select c.id, c.title, c.active, c.createdAt, count(cd.productId) as totalProduct from categories c LEFT JOIN category_products_details cd on c.id = cd.categoryId\n" +
            "group by c.id, c.title, c.createdAt) as x LEFT JOIN (\n" +
            "select c.id, sum(o.amount) as totalProductBuy from order_products_details o join category_products_details cd on o.productId = cd.productId join categories c on c.id = cd.categoryId \n" +
            "group by c.id ) as y on x.id = y.id")
    @RegisterBeanMapper(CategoryDTO.class)
    List<CategoryDTO> getListCategoryDTO();

    @SqlUpdate("insert into categories(title, patternName,active, createdAt, updatedAt) values (:title, :patternName, :active, :createdAt, :updatedAt)")
    @RegisterBeanMapper(Category.class)
    boolean insertCategory(@BindBean Category category);

    @SqlQuery("select id, title, active, createdAt, updatedAt from categories where id = :id")
    @RegisterBeanMapper(Category.class)
    Category getCategoryById(@Bind("id") Integer id);

    @SqlQuery("select p.id, p.codeProduct as code, p.title, p.typeOfProduct as type from category_products_details cd join products p on cd.productId = p.id WHERE cd.categoryId = :categoryId")
    @RegisterBeanMapper(Product.class)
    List<Product> getProductsByCategoryId(@Bind("categoryId") int categoryId);

    @SqlQuery("select id, codeProduct as code, title from products where id not in (select productId from category_products_details WHERE categoryId = :categoryId)")
    @RegisterBeanMapper(Product.class)
    List<Product> getProductsNotInCategory(@Bind("categoryId") int categoryId);

    @SqlUpdate("update categories set title = :title, patternName = :patternName, active = :active, updatedAt = :updatedAt where id = :id")
    boolean updateCategory(@BindBean Category category);

    @SqlUpdate("DELETE FROM category_products_details WHERE productId = :productId AND categoryId = :categoryId")
    void deleteCategory(@Bind("productId") int productId, @Bind("categoryId") int categoryId);

    @SqlUpdate("INSERT INTO category_products_details (categoryId, productId, updatedAt) " +
            "VALUES (:categoryId, :productId, :updatedAt)")
    void insertCategoryProducts(@Bind("categoryId") int categoryId,
                                @Bind("productId") int productId,
                                @Bind("updatedAt") Timestamp updatedAt);

    //Dùng cho trang danh mục
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
                offset :offset,
                limit :limit
            """)
    List<Integer> getListIdInCategory(@Bind("categoryName") String categoryName, @Bind("offset") int offset, @Bind("limit") int limit);

//    @SqlQuery("""
//        select count(products.id)
//        from products
//            join category_products_details
//            on products.id = category_products_details.productId
//            join categories
//            on category_products_details.categoryId = categories.id
//        where categories.patternName like :categoryName
//    """)
//    int countProductByCategory(@Bind("categoryName") String categoryName);

    @SqlQuery("""
                select distinct count( products.id) over ()
                from products
                join category_products_details
                    on products.id = category_products_details.productId
                join categories
                    on category_products_details.categoryId = categories.id
                join topic_products_details
                    on products.id = topic_products_details.productId
                join product_prices
                    on products.id = product_prices.productId
                left join product_reviews
                    on products.id = product_reviews.productId
                join providers
                    on products.providerId = providers.id
                where (:patternName is null or categories.patternName like :patternName)
                    and (json_array(<topicId>) = '[null]' or topic_products_details.topicId in (<topicId>))
                    and (:providerName is null or providers.providerName like :providerName)
                    and ((:fromPrice = 0 and :toPrice = 0) or :fromPrice <= :toPrice and product_prices.price between :fromPrice and :toPrice)
                    and (:productName is null or products.title like :productName)
                group by products.id
                having (:rating = 0 or coalesce(avg(product_reviews.rating), 0) >= :rating)
            """)
    Integer countProductByCategory(@Bind("patternName") String patternName, @BindList(value = "topicId", onEmpty = BindList.EmptyHandling.NULL_STRING) List<Integer> topicId,
                               @Bind("rating") int rating,
                               @Bind("fromPrice") double fromPrice, @Bind("toPrice") double toPrice,
                               @Bind("providerName") String providerName, @Bind("productName") String productName);


    @SqlQuery("""
                select title, patternName
                from categories
                where active = 1
            """)
    @RegisterRowMapper(CategoryNameMapper.class)
    List<Category> getAllCategoriesName();
}