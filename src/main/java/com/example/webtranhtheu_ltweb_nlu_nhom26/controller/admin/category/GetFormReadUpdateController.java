package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.admin.category;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin.CategoryDTO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Category;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.CategoryService;
import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GetFormReadUpdateController", value = "/admin/category-management/read-edit-category-form")
public class GetFormReadUpdateController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        int categoryId = request.getParameter("categoryId") == null ? -1 : Integer.parseInt(request.getParameter("categoryId"));
        //chưa xử lý
        CategoryService categoryService = new CategoryService();
        Category c = categoryService.getCategoryById(categoryId);
        List<Product> listProduct = categoryService.listProductInCategory(categoryId);
        List<Product> listProductNotInCategory = categoryService.listProductNotInCategory(categoryId);

        if (c == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            request.setAttribute("category", c);
            request.setAttribute("listProduct", listProduct);
            request.setAttribute("listProductNotInCategory", listProductNotInCategory);

            Timestamp timestamp = c.getCreatedAt();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = dateFormat.format(timestamp); // Chuyển đổi sang định dạng yyyy-MM-dd
            request.setAttribute("createAt", formattedDate);

            request.getRequestDispatcher("/layout/admin/category-form/read-edit-category-form.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}