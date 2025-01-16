package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.category;

import com.example.webtranhtheu_ltweb_nlu_nhom26.services.CategoryService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.StringTokenizer;

@WebServlet(name = "category", value = "/category/*")
public class CategoryController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String pathName = request.getPathInfo();
        StringTokenizer tokenizer = new StringTokenizer(pathName, "/");
        String categoryName = tokenizer.nextToken();

        if (CategoryService.isCategoryNameExist(categoryName)) {
            request.getRequestDispatcher("/layout/category.jsp").forward(request, response);
        }
        else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}