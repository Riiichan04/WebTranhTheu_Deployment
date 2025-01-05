package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.admin.category;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AddCategoryController", value = "/admin/category-management/add-category")
public class AddCategoryController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy dữ liệu từ form
        String name = request.getParameter("name");
        String quantity = request.getParameter("status");

        // Lưu dữ liệu vào cơ sở dữ liệu (chưa xử lý)
        System.out.println("Tên sản phẩm: " + name);
        System.out.println("Số lượng: " + quantity);
    }
}