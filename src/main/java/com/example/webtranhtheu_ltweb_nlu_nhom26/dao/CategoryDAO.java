package com.example.webtranhtheu_ltweb_nlu_nhom26.dao;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin.CategoryDTO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Category;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.sql.Timestamp;
import java.util.List;

public interface CategoryDAO {
    @SqlQuery("select x.id, x.title, x.createdAt, x.active, x.totalProduct as quantity, COALESCE(y.totalProductBuy, 0) as numProductBought from (select c.id, c.title, c.active, c.createdAt, count(cd.productId) as totalProduct from categories c LEFT JOIN category_products_details cd on c.id = cd.categoryId\n" +
            "group by c.id, c.title, c.createdAt) as x LEFT JOIN (\n" +
            "select c.id, sum(o.amount) as totalProductBuy from order_products_details o join category_products_details cd on o.productId = cd.productId join categories c on c.id = cd.categoryId \n" +
            "group by c.id ) as y on x.id = y.id")
    @RegisterBeanMapper(CategoryDTO.class)
    List<CategoryDTO> getListCategoryDTO();

    @SqlUpdate("insert into categories(title, active, createdAt, updatedAt) values (:title, :active, :createdAt, :updatedAt)")
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

    @SqlUpdate("update categories set title = :title, active = :active, updatedAt = :updatedAt where id = :id")
    boolean updateCategory(@BindBean Category category);

    @SqlUpdate("DELETE FROM category_products_details WHERE productId = :productId AND categoryId = :categoryId")
    void deleteCategory(@Bind("productId") int productId, @Bind("categoryId") int categoryId);

    @SqlUpdate("INSERT INTO category_products_details (categoryId, productId, updatedAt) " +
            "VALUES (:categoryId, :productId, :updatedAt)")
    void insertCategoryProducts(@Bind("categoryId") int categoryId,
                                @Bind("productId") int productId,
                                @Bind("updatedAt") Timestamp updatedAt);

}
