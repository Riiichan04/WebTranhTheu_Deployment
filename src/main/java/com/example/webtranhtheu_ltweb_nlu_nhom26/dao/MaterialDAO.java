package com.example.webtranhtheu_ltweb_nlu_nhom26.dao;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Material;
import com.example.webtranhtheu_ltweb_nlu_nhom26.db.JDBIConnector;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface MaterialDAO {
    @SqlQuery("select id, title, active, createdAt from materials")
    @RegisterBeanMapper(Material.class)
    List<Material> getAllMaterial();

    @SqlUpdate("insert into materials(title, active, createdAt, updatedAt) VALUES(:title, :active, NOW(), NOW())")
    boolean addMaterial(@Bind("title") String title, @Bind("active") int active);

    @SqlQuery("SELECT id, title, active, createdAt, updatedAt FROM materials where id = :materialId")
    @RegisterBeanMapper(Material.class)
    Material getMaterialById(@Bind("materialId") int materialId);

    @SqlUpdate("update materials set title = :title, active = :active, updatedAt = NOW() where id = :materialId")
    boolean updateMaterial(@Bind("title") String title, @Bind("active") int active, @Bind("materialId") int materialId);

    public static void main(String[] args) {
        MaterialDAO dao = JDBIConnector.getInstance().onDemand(MaterialDAO.class);
        for(Material m : dao.getAllMaterial()) {
            System.out.println(m);
        }

    }
}
