package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.admin.category;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin.CategoryDTO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Category;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GetCategoryDataController", value = "/admin/category-management/get-category")
public class GetCategoryDataController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        //chưa xử lý service
        List<CategoryDTO> categories = new ArrayList<>();
        categories.add(new CategoryDTO(1, "Tranh thêu chữ thập", 1200, 122, new Timestamp(System.currentTimeMillis()), 1));

        Gson gson = new Gson();
        response.getWriter().print(gson.toJson(categories));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}