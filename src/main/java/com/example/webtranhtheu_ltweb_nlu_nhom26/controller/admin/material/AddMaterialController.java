package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.admin.material;

import com.example.webtranhtheu_ltweb_nlu_nhom26.services.MaterialService;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.ProviderService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AddMaterialController", value = "/admin/material-management/add-material")
public class AddMaterialController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String status = request.getParameter("status");

        response.setContentType("application/json");
        if(MaterialService.addMaterial(name, Integer.parseInt(status))){
            response.getWriter().write("{\"success\": true}");
        } else {
            response.getWriter().write("{\"success\": false}");
        }
    }
}