package com.example.webtranhtheu_ltweb_nlu_nhom26.services;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Provider;
import com.example.webtranhtheu_ltweb_nlu_nhom26.dao.ProviderDAO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.db.JDBIConnector;

import java.util.List;

public class ProviderService {
    private static ProviderDAO providerDAO = JDBIConnector.getInstance().onDemand(ProviderDAO.class);

    public static List<Provider> getAllProviders() {
        return providerDAO.getProviders();
    }
}
