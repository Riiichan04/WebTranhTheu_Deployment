package com.example.webtranhtheu_ltweb_nlu_nhom26.services;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Provider;
import com.example.webtranhtheu_ltweb_nlu_nhom26.dao.ProviderDAO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.dao.ProductDAO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.db.JDBIConnector;

import java.util.List;

//Do chưa có ProviderDAO nên tạm gọi riêng
public class ProviderService {
    public static List<Provider> getListProviders() {
        return JDBIConnector.getInstance().onDemand(ProductDAO.class).getListProvider();
    private static ProviderDAO providerDAO = JDBIConnector.getInstance().onDemand(ProviderDAO.class);

    public static List<Provider> getAllProviders() {
        return providerDAO.getProviders();
    }

    public static boolean addProvider(String name, String location) {
        int addressId = providerDAO.addAddress(location);
        return providerDAO.insertProvider(name, addressId);
    }

    public static Provider getProviderById(int id) {
        return providerDAO.getProviderById(id);
    }

    public static List<Product> getAllProductsByProvider(int providerId) {
        return providerDAO.getProductByProviderId(providerId);
    }

    public static boolean updateProvider(String providerName, String address, int providerId) {
        return providerDAO.updateProviderById(providerName, address, providerId);
    }
}
