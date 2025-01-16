package com.example.webtranhtheu_ltweb_nlu_nhom26.controller;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Category;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.CategoryService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchProductController", value = "/search")
public class SearchProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String keyword = request.getParameter("keyword");

        List<Category> listCategory = CategoryService.getNameAndPatternCategory();
        request.setAttribute("listCategoryName", listCategory);
        request.getRequestDispatcher("layout/search.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}