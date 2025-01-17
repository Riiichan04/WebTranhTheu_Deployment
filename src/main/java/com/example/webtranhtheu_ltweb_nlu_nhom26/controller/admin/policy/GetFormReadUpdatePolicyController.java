package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.admin.policy;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Policy;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.PolicyService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(name = "GetFormReadUpdatePolicyController", value = "/admin/policy-management/read-edit-policy-form")
public class GetFormReadUpdatePolicyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        int policyId = request.getParameter("policyId") == null ? -1 : Integer.parseInt(request.getParameter("policyId"));

        PolicyService policyService = new PolicyService();
        Policy p = policyService.getPolicyById(policyId);
        List<Product> listProduct = policyService.listProductsUsePolicy(policyId);
        List<Product> listProductsNotUsePolicy = policyService.listProductsNotUsePolicy(policyId);

        if (p == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            request.setAttribute("policy", p);
            request.setAttribute("listProduct", listProduct);
            request.setAttribute("listProductsNotUsePolicy", listProductsNotUsePolicy);

            Timestamp timestamp = p.getCreateAt();
            Timestamp timestampUpdate = p.getUpdateAt();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = dateFormat.format(timestamp); // Chuyển đổi sang định dạng yyyy-MM-dd
            request.setAttribute("createAt", formattedDate);
            String formattedDateUpdate = dateFormat.format(timestampUpdate);
            request.setAttribute("updateAt", formattedDateUpdate);

            request.getRequestDispatcher("/layout/admin/policy-form/read-edit-policy-form.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}