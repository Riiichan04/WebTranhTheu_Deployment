package com.example.webtranhtheu_ltweb_nlu_nhom26.dao;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Provider;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface ProviderDAO {
    @SqlQuery("SELECT p.id, p.providerName, a.location as address, p.createdAt FROM providers p join addresses a on p.addressId = a.id")
    @RegisterBeanMapper(Provider.class)
    List<Provider> getProviders();

    @SqlUpdate("insert into addresses(location) values (:location)")
    @GetGeneratedKeys
    int addAddress(@Bind("location") String location);

    @SqlUpdate("insert into providers(providerName, addressId, createdAt, updatedAt) VALUES(:providerName, :addressId, NOW(), NOW())")
    boolean insertProvider(@Bind("providerName") String providerName, @Bind("addressId") int addressId);

    @SqlQuery("select p.id, p.providerName, a.location as address, p.createdAt, p.updatedAt from providers p join addresses a on p.addressId = a.id where p.id = :providerId")
    @RegisterBeanMapper(Provider.class)
    Provider getProviderById(@Bind("providerId") int providerId);

    @SqlQuery("select id, codeProduct as code, title, typeOfProduct as type, status from products where providerId = :providerId ")
    @RegisterBeanMapper(Product.class)
    List<Product> getProductByProviderId(@Bind("providerId") int providerId);

    @SqlUpdate("update providers p join addresses a on p.addressId = a.id set p.providerName = :providerName, a.location = :address, p.updatedAt = NOW() where p.id = :providerId")
    boolean updateProviderById(@Bind("providerName") String providerName, @Bind("address") String address, @Bind("providerId") int providerId);
}
