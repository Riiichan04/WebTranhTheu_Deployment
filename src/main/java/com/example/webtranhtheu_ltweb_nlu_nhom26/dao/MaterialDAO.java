package com.example.webtranhtheu_ltweb_nlu_nhom26.dao;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Material;
import com.example.webtranhtheu_ltweb_nlu_nhom26.db.JDBIConnector;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;

public interface MaterialDAO {
    @SqlQuery("select id, title, active, createdAt from materials")
    @RegisterBeanMapper(Material.class)
    List<Material> getAllMaterial();

    public static void main(String[] args) {
        MaterialDAO dao = JDBIConnector.getInstance().onDemand(MaterialDAO.class);
        for(Material m : dao.getAllMaterial()) {
            System.out.println(m);
        }

    }
}
