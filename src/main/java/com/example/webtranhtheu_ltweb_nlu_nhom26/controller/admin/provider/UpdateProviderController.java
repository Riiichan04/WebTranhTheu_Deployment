package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.admin.provider;

import com.example.webtranhtheu_ltweb_nlu_nhom26.services.ProviderService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "UpdateProviderController", value = "/admin/provider-management/update-provider")
public class UpdateProviderController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String name = request.getParameter("name");
            String address = request.getParameter("address");
            int providerId = Integer.parseInt(request.getParameter("providerId"));

            response.setContentType("application/json");
            if(ProviderService.updateProvider(name, address, providerId)){
                response.getWriter().write("{\"success\": true}");
            } else {
                response.getWriter().write("{\"success\": false}");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}