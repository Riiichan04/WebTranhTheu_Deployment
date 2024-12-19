package com.example.webtranhtheu_ltweb_nlu_nhom26.controller;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.ProductService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ProductController", value = "/product")
public class ProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String productId = request.getParameter("id");
        try {
            int triggerErrorPage = Integer.parseInt(productId); //Trigger error khi cần
//            Chưa có db để chạy
//            Product product = ProductService.getProduct(Integer.parseInt(productId));
            request.getRequestDispatcher("/layout/product.jsp").forward(request, response);
        }
        catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND); //Ném trang 404
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}