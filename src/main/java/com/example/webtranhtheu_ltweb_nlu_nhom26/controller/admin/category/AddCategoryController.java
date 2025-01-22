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

@WebServlet(name = "AddCategoryController", value = "/admin/category-management/add-category")
public class AddCategoryController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy dữ liệu từ form
        String title = request.getParameter("name");
        int active = Integer.parseInt(request.getParameter("status"));

        CategoryService categoryService = new CategoryService();
        String patternName = categoryService.removeDiacritics(title);
        Category category = new Category(title, patternName, active, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()));
        response.setContentType("application/json");
        if(categoryService.addCategory(category)){
            response.getWriter().write("{\"success\": true}");
        } else {
            response.getWriter().write("{\"success\": false}");
        }
    }
}