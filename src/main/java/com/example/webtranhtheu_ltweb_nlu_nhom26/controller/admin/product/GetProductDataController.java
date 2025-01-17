package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.admin.product;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin.ProductDTO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.ProductService;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetProductDataController", value = "/admin/product-management/get-product")
public class GetProductDataController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        ProductService productService = new ProductService();
        List<ProductDTO> products = productService.listProductsDTO();

        Gson gson = new Gson();
        response.getWriter().print(gson.toJson(products));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}