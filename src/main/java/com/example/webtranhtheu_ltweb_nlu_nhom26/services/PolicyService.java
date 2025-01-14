package com.example.webtranhtheu_ltweb_nlu_nhom26.services;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin.PolicyDTO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Policy;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.dao.PolicyDAO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.db.JDBIConnector;

import java.sql.Timestamp;
import java.util.List;

public class PolicyService {
    private static PolicyDAO policyDAO;

    public PolicyService() {
        policyDAO = JDBIConnector.getInstance().onDemand(PolicyDAO.class);
    }

    public List<PolicyDTO> getPoliciesDTO(){
        return policyDAO.getPoliciesDTO();
    }

    public boolean addPolicy(Policy policy){
        return policyDAO.addPolicy(policy);
    }

    public Policy getPolicyById(int id){
        return policyDAO.getPolicyById(id);
    }

    public List<Product> listProductsUsePolicy(int policyId){
        return policyDAO.getProductsByPolicyId(policyId);
    }

    public List<Product> listProductsNotUsePolicy(int policyId){
        return policyDAO.getProductsByPolicyIdNot(policyId);
    }

    public void updatePolicy(Policy policy, String[] deleteProductId, String[] addProductId){
        policyDAO.updatePolicy(policy);
        for(String productId : deleteProductId) {
            policyDAO.deletePolicyProductById(Integer.parseInt(productId));
        }
        for(String productId : addProductId) {
            policyDAO.updatePolicyProductById(Integer.parseInt(productId), policy.getId());
        }
    }
}
