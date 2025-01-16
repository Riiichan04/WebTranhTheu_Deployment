package com.example.webtranhtheu_ltweb_nlu_nhom26.controller;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.CategoryService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

@WebServlet(name = "category", value = "/category/*")
public class Category extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String pathName = request.getPathInfo();
        StringTokenizer tokenizer = new StringTokenizer(pathName, "/");
        String categoryName = tokenizer.nextToken();
        List<Product> listProduct = CategoryService.getDisplayProductByCategory(categoryName);

        request.getRequestDispatcher("/layout/category.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}