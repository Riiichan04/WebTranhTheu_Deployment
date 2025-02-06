package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.admin.promotion;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.ProductService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetFormAddPromotionController", value = "/admin/promotion-management/add-promotion-form")
public class GetFormAddPromotionController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        List<Product> listProduct = new ProductService().getAllListProductsCodeAndTitle();
        request.setAttribute("listProduct", listProduct);

        request.getRequestDispatcher("/layout/admin/promotion-form/add-promotion-form.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}