package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.admin.category;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Category;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.CategoryService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Arrays;

@WebServlet(name = "UpdateCategoryController", value = "/admin/category-management/update-category")
public class UpdateCategoryController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy dữ liệu từ form
        String categoryId = request.getParameter("categoryId");
        String name = request.getParameter("name");
        String[] selectedProductIdsDelete = request.getParameterValues("selectedProductIdsDelete")==null?new String[0]:request.getParameterValues("selectedProductIdsDelete");
        String[] selectedProductIdsAdd = request.getParameterValues("selectedProductIdsAdd")==null?new String[0]:request.getParameterValues("selectedProductIdsAdd");
        int active = Integer.parseInt(request.getParameter("statusCategory"));
        Category category = new Category(Integer.parseInt(categoryId), name, active, null, new Timestamp(System.currentTimeMillis()));
        CategoryService categoryService = new CategoryService();
        categoryService.updateCategory(category, selectedProductIdsDelete, selectedProductIdsAdd);
    }
}