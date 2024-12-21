package com.example.webtranhtheu_ltweb_nlu_nhom26.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

//Dùng để lấy review của sản phẩm
@WebServlet(name = "ProductReviewController", value = "/get-product-review")
public class ProductReviewController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}