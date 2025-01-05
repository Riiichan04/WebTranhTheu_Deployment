package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.admin.category;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "UpdateCategoryController", value = "/admin/category-management/update-category")
public class UpdateCategoryController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy dữ liệu từ form
        String name = request.getParameter("name");
        String[] selectedProductIdsDelete = request.getParameterValues("selectedProductIdsDelete")==null?new String[0]:request.getParameterValues("selectedProductIdsDelete");
        String[] selectedProductIdsAdd = request.getParameterValues("selectedProductIdsAdd")==null?new String[0]:request.getParameterValues("selectedProductIdsAdd");
        int statusCategory = Integer.parseInt(request.getParameter("statusCategory"));

        // Lưu dữ liệu vào cơ sở dữ liệu (chưa xử lý)
        System.out.println(name);
        System.out.println(Arrays.toString(selectedProductIdsDelete));
        System.out.println(Arrays.toString(selectedProductIdsAdd));
        System.out.println(statusCategory);
    }
}