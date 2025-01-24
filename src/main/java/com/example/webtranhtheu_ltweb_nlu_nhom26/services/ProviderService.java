package com.example.webtranhtheu_ltweb_nlu_nhom26.services;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Provider;
import com.example.webtranhtheu_ltweb_nlu_nhom26.dao.ProductDAO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.db.JDBIConnector;

import java.util.List;

//Do chưa có ProviderDAO nên tạm gọi riêng
public class ProviderService {
    public static List<Provider> getListProviders() {
        return JDBIConnector.getInstance().onDemand(ProductDAO.class).getListProvider();
    }
}
