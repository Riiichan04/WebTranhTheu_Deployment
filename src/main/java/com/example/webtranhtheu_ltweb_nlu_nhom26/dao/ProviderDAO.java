package com.example.webtranhtheu_ltweb_nlu_nhom26.dao;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Provider;
import com.example.webtranhtheu_ltweb_nlu_nhom26.db.JDBIConnector;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface ProviderDAO {
    @SqlQuery("SELECT p.providerName, a.location as address, p.createdAt FROM providers p join addresses a on p.addressId = a.id")
    @RegisterBeanMapper(Provider.class)
    List<Provider> getProviders();

    @SqlUpdate("insert into addresses(location) values (:location)")
    @GetGeneratedKeys
    int addAddress(@Bind("location") String location);

    @SqlUpdate("insert into providers(providerName, addressId, createdAt, updatedAt) VALUES(:providerName, :addressId, NOW(), NOW())")
    boolean insertProvider(@Bind("providerName") String providerName, @Bind("addressId") int addressId);

}
