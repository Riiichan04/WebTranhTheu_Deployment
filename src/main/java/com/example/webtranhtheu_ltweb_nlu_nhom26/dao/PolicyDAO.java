package com.example.webtranhtheu_ltweb_nlu_nhom26.dao;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin.PolicyDTO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Policy;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.db.JDBIConnector;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.sql.Timestamp;
import java.util.List;

public interface PolicyDAO {

    @SqlQuery("SELECT p.id, p.title, p.createdAt, x.countProduct FROM policies p left join (select policyId, count(id) as countProduct from products GROUP BY policyId) as x on p.id = x.policyId")
    @RegisterBeanMapper(PolicyDTO.class)
    List<PolicyDTO> getPoliciesDTO();

    @SqlUpdate("insert into policies(title, description, createdAt, updatedAt) values(:title, :description, :createAt, :updateAt)")
    @RegisterBeanMapper(Policy.class)
    boolean addPolicy(@BindBean Policy policy);

    @SqlQuery("select id, title, description, createdAt as createAt, updatedAt as updateAt from policies where id = :id")
    @RegisterBeanMapper(Policy.class)
    Policy getPolicyById(@Bind("id") long id);

    @SqlQuery("select id, codeProduct as code, title, typeOfProduct as type from products where policyId = :policyId")
    @RegisterBeanMapper(Product.class)
    List<Product> getProductsByPolicyId(@Bind("policyId") int policyId);

    @SqlQuery("select id, codeProduct as code, title, typeOfProduct as type from products where policyId != :policyId")
    @RegisterBeanMapper(Product.class)
    List<Product> getProductsByPolicyIdNot(@Bind("policyId") int policyId);

    @SqlUpdate("update policies set title = :title, description = :description, updatedAt = :updateAt where id = :id")
    @RegisterBeanMapper(Policy.class)
    void updatePolicy(@BindBean Policy policy);

    @SqlUpdate("update products set policyId = 1 where id = :productId")
    void deletePolicyProductById(@Bind("productId") int productId);

    @SqlUpdate("update products set policyId = :policyId where id = :productId")
    void updatePolicyProductById(@Bind("productId") int productId, @Bind("policyId") int policyId);

}
