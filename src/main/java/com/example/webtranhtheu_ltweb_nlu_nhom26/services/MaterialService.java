package com.example.webtranhtheu_ltweb_nlu_nhom26.services;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Material;
import com.example.webtranhtheu_ltweb_nlu_nhom26.dao.MaterialDAO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.db.JDBIConnector;

import java.util.List;

public class MaterialService {
    private static MaterialDAO materialDAO = JDBIConnector.getInstance().onDemand(MaterialDAO.class);

    public static List<Material> getAllMaterial() {
        return materialDAO.getAllMaterial();
    }

    public static boolean addMaterial(String title, int status) {
        return materialDAO.addMaterial(title, status);
    }

    public static Material getMaterialById(int id) {
        return materialDAO.getMaterialById(id);
    }

    public static boolean updateMaterial(int id, String title, int status) {
        return materialDAO.updateMaterial(title, status, id);
    }
}
