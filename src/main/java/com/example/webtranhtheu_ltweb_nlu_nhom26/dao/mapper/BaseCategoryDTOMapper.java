package com.example.webtranhtheu_ltweb_nlu_nhom26.dao.mapper;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin.CategoryDTO;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseCategoryDTOMapper implements RowMapper<CategoryDTO> {
    @Override
    public CategoryDTO map(ResultSet rs, StatementContext ctx) throws SQLException {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(rs.getInt("id"));
        categoryDTO.setName(rs.getString("name"));
        categoryDTO.setCreateAt(rs.getTimestamp("create_at"));
        categoryDTO.setQuantity(rs.getInt("quantity"));
        categoryDTO.setNumProductBought(rs.getInt("num_product_bought"));
        categoryDTO.setStatus(rs.getInt("status"));
        return categoryDTO;
    }
}
