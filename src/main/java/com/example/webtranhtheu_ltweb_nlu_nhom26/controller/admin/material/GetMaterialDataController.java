package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.admin.material;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Material;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.MaterialService;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetMaterialDataController", value = "/admin/material-management/get-material")
public class GetMaterialDataController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // ch xử lý service
        List<Material> materials = MaterialService.getAllMaterial();

        Gson gson = new Gson();
        response.getWriter().print(gson.toJson(materials));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}