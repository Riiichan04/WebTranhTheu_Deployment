package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.admin.product;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Material;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Provider;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.ProductService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetFormAddProductController", value = "/admin/product-management/add-product-form")
public class GetFormAddProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        ProductService productService = new ProductService();
        List<Material> materials = productService.getMaterials();
        request.setAttribute("materials", materials);
        List<Provider> providers = productService.getProviders();
        request.setAttribute("providers", providers);

        request.getRequestDispatcher("/layout/admin/product-form/add-product-form.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}