package com.example.webtranhtheu_ltweb_nlu_nhom26.dao.mapper;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseProductMapper implements RowMapper<Product> {
    @Override
    public Product map(ResultSet rs, StatementContext ctx) throws SQLException {
        Product product = new Product();
        product.setId(rs.getInt("id"));
        product.setCode(rs.getString("codeProduct"));
        product.setTitle(rs.getString("title"));
        product.setDescription(rs.getString("description"));
        product.setType(rs.getInt("typeOfProduct"));
        product.setCreatedAt(rs.getTimestamp("createdAt"));
        product.setUpdatedAt(rs.getTimestamp("updatedAt"));
        return product;
    }
}
