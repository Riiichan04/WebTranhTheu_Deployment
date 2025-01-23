package com.example.webtranhtheu_ltweb_nlu_nhom26.dao;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin.DiscountDTO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Discount;
import com.example.webtranhtheu_ltweb_nlu_nhom26.db.JDBIConnector;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.sql.Timestamp;
import java.util.List;

public interface DiscountDAO {
    @SqlQuery("select id, title, value, startedAt, endedAt from discounts")
    @RegisterBeanMapper(DiscountDTO.class)
    List<DiscountDTO> getAllDiscountDTO();

    @SqlUpdate("insert into discounts(title, description, value, startedAt, endedAt, createdAt, updatedAt) values(:title, :description, :value, :startedAt, :endedAt, NOW(), NOW())")
    @RegisterBeanMapper(Discount.class)
    boolean insertDiscount(@BindBean Discount discount);

    @SqlQuery("select id, title, description, value, startedAt, endedAt, createdAt, updatedAt from discounts where id = :id")
    @RegisterBeanMapper(Discount.class)
    Discount getDiscountById(@Bind("id") Integer id);

    @SqlUpdate("update discounts set title = :title, description = :description, value = :value, startedAt = :startedAt, endedAt = :endedAt, updatedAt = NOW() where id = :id")
    @RegisterBeanMapper(Discount.class)
    boolean updateDiscount(@BindBean Discount discount);

    @SqlQuery("select id, title, value from discounts where NOW()>=startedAt and NOW()<=endedAt")
    @RegisterBeanMapper(Discount.class)
    List<Discount> getDiscountAvailable();
}
