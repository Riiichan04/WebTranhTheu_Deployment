package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.admin.policy;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Category;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Policy;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.CategoryService;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.PolicyService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Timestamp;

@WebServlet(name = "UpdatePolicyController", value = "/admin/policy-management/update-policy")
public class UpdatePolicyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy dữ liệu từ form
        String policyId = request.getParameter("policyId");
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String[] selectedProductIdsDelete = request.getParameterValues("selectedProductIdsDelete")==null?new String[0]:request.getParameterValues("selectedProductIdsDelete");
        String[] selectedProductIdsAdd = request.getParameterValues("selectedProductIdsAdd")==null?new String[0]:request.getParameterValues("selectedProductIdsAdd");
        Policy policy = new Policy(Integer.parseInt(policyId), name, description, null, new Timestamp(System.currentTimeMillis()));
        PolicyService policyService = new PolicyService();
        policyService.updatePolicy(policy, selectedProductIdsDelete, selectedProductIdsAdd);
    }
}