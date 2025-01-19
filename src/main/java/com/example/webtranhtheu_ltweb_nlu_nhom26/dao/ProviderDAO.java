package com.example.webtranhtheu_ltweb_nlu_nhom26.dao;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Provider;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;

public interface ProviderDAO {
    @SqlQuery("SELECT p.providerName, a.location as address, p.createdAt FROM providers p join addresses a on p.addressId = a.id")
    @RegisterBeanMapper(Provider.class)
    List<Provider> getProviders();
}
