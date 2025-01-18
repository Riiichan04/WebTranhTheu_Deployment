package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.admin.provider;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin.CategoryDTO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Provider;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.CategoryService;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GetProviderDataController", value = "/admin/provider-management/get-provider")
public class GetProviderDataController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // chưa xử lý service
        List<Provider> providers = new ArrayList<>();

        Gson gson = new Gson();
        response.getWriter().print(gson.toJson(providers));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}