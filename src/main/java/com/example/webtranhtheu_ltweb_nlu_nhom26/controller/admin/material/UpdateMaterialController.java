package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.admin.material;

import com.example.webtranhtheu_ltweb_nlu_nhom26.services.MaterialService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "UpdateMaterialController", value = "/admin/material-management/update-material")
public class UpdateMaterialController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int status = Integer.parseInt(request.getParameter("status"));
        int materialId = Integer.parseInt(request.getParameter("materialId"));

        response.setContentType("application/json");
        if(MaterialService.updateMaterial(materialId, name, status)){
            response.getWriter().write("{\"success\": true}");
        } else {
            response.getWriter().write("{\"success\": false}");
        }
    }
}