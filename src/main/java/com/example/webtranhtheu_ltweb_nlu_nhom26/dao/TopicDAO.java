package com.example.webtranhtheu_ltweb_nlu_nhom26.dao;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin.TopicDTO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Topic;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.sql.Timestamp;
import java.util.List;

public interface TopicDAO {
    @SqlQuery("select x.id, x.title, x.createdAt, x.active, x.totalProduct as quantity, COALESCE(y.totalProductBuy, 0) as numProductBought from (select c.id, c.title, c.active, c.createdAt, count(cd.productId) as totalProduct from topics c LEFT JOIN topic_products_details cd on c.id = cd.topicId\n" +
            "group by c.id, c.title, c.createdAt) as x LEFT JOIN (\n" +
            "select c.id, sum(o.amount) as totalProductBuy from order_products_details o join topic_products_details cd on o.productId = cd.productId join topics c on c.id = cd.topicId \n" +
            "group by c.id ) as y on x.id = y.id")
    @RegisterBeanMapper(TopicDTO.class)
    List<TopicDTO> getListTopicDTO();

    @SqlUpdate("insert into topics(title, active, createdAt, updatedAt) values (:title, :active, :createdAt, :updatedAt)")
    @RegisterBeanMapper(Topic.class)
    boolean insertTopic(@BindBean Topic topic);

    @SqlQuery("select id, title, active, createdAt, updatedAt from topics where id = :id")
    @RegisterBeanMapper(Topic.class)
    Topic getTopicById(@Bind("id") Integer id);

    @SqlQuery("select p.id, p.codeProduct as code, p.title, p.typeOfProduct as type from topic_products_details cd join products p on cd.productId = p.id WHERE cd.topicId = :topicId")
    @RegisterBeanMapper(Product.class)
    List<Product> getProductsByTopicId(@Bind("topicId") int topicId);

    @SqlQuery("select id, codeProduct as code, title from products where id not in (select productId from topic_products_details WHERE topicId = :topicId)")
    @RegisterBeanMapper(Product.class)
    List<Product> getProductsNotInTopic(@Bind("topicId") int topicId);

    @SqlUpdate("update topics set title = :title, active = :active, updatedAt = :updatedAt where id = :id")
    boolean updateTopic(@BindBean Topic topic);

    @SqlUpdate("DELETE FROM topic_products_details WHERE productId = :productId AND topicId = :topicId")
    void deleteTopic(@Bind("productId") int productId, @Bind("topicId") int topicId);

    @SqlUpdate("INSERT INTO topic_products_details (topicId, productId, updatedAt) " +
            "VALUES (:topicId, :productId, :updatedAt)")
    void insertTopicProducts(@Bind("topicId") int topicId,
                                @Bind("productId") int productId,
                                @Bind("updatedAt") Timestamp updatedAt);

}
