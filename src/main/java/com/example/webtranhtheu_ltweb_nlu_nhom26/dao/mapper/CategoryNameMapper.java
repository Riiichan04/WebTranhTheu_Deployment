package com.example.webtranhtheu_ltweb_nlu_nhom26.dao.mapper;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Category;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

//Cần tối ưu
public class CategoryNameMapper implements RowMapper<Category> {
    @Override
    public Category map(ResultSet rs, StatementContext ctx) throws SQLException {
       Category category = new Category();
       category.setTitle(rs.getString("title"));
       category.setPatternName(rs.getString("patternName"));
       return category;
    }
}
