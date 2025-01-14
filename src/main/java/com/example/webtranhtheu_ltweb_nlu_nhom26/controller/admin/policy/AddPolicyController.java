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

@WebServlet(name = "AddPolicyController", value = "/admin/policy-management/add-policy")
public class AddPolicyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy dữ liệu từ form
        String title = request.getParameter("name");
        String description = request.getParameter("description");

        PolicyService policyService = new PolicyService();
        Policy policy = new Policy(title, description, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()));
        response.setContentType("application/json");
        if(policyService.addPolicy(policy)){
            response.getWriter().write("{\"success\": true}");
        } else {
            response.getWriter().write("{\"success\": false}");
        }
    }
}