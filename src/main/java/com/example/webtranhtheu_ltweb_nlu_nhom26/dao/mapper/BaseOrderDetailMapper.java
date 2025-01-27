package com.example.webtranhtheu_ltweb_nlu_nhom26.dao.mapper;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin.orderAdmin.OrderDetails;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseOrderDetailMapper implements RowMapper<OrderDetails> {
    @Override
    public OrderDetails map(ResultSet rs, StatementContext ctx) throws SQLException {
        OrderDetails orderDetails = new OrderDetails();
        Product product = new Product();
        product.setId(rs.getInt("productId"));
        product.setCode(rs.getString("codeProduct"));
        product.setTitle(rs.getString("title"));
        orderDetails.setProduct(product);
        orderDetails.setAmount(rs.getInt("amount"));
        orderDetails.setWidth(rs.getInt("width"));
        orderDetails.setHeight(rs.getInt("height"));
        orderDetails.setPrice(rs.getDouble("price"));
        return orderDetails;
    }
}
