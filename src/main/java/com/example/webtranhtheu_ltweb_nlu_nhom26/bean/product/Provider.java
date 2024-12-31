package com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Provider implements Serializable {
    private int id;
    private String prodiverName;
    private String address; //Còn sửa sau

    public Provider(int id, String prodiverName, String address) {
        this.id = id;
        this.prodiverName = prodiverName;
        this.address = address;
    }

    public Provider() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProdiverName() {
        return prodiverName;
    }

    public void setProdiverName(String prodiverName) {
        this.prodiverName = prodiverName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static class ProviderMapper implements RowMapper<Provider> { //Cần sửa cái này
        @Override
        public Provider map(ResultSet rs, StatementContext ctx) throws SQLException {
            return new Provider(rs.getInt("id"), rs.getString("providerName"), rs.getString("location"));
        }
    }
}
