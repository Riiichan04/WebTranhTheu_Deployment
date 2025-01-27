package com.example.webtranhtheu_ltweb_nlu_nhom26.dao.mapper;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.user.WishProduct;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseWishProductMapper implements RowMapper<WishProduct> {
    @Override
    public WishProduct map(ResultSet rs, StatementContext ctx) throws SQLException {
        WishProduct wp = new WishProduct();
        Product product = new Product();
        product.setId(rs.getInt("id"));
        product.setCode(rs.getString("codeProduct"));
        product.setTitle(rs.getString("title"));
        wp.setProduct(product);
        wp.setCreatedAt(rs.getTimestamp("createdAt"));
        return wp;
    }
}
