package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.admin.policy;

import com.example.webtranhtheu_ltweb_nlu_nhom26.services.PolicyService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "DeletePolicyController", value = "/admin/policy-management/delete-policy")
public class DeletePolicyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String policyId = request.getParameter("policyId");
        PolicyService policyService = new PolicyService();
        if(Integer.parseInt(policyId) == 1) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            policyService.deletePolicy(Integer.parseInt(policyId));
        }
    }
}