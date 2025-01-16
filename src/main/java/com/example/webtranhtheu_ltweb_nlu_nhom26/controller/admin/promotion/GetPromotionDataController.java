package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.admin.promotion;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin.DiscountDTO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.DiscountService;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetPromotionDataController", value = "/admin/promotion-management/get-promotion")
public class GetPromotionDataController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        DiscountService discountService = new DiscountService();
        List<DiscountDTO> promotions = discountService.getAllDiscountDTO();

        Gson gson = new Gson();
        response.getWriter().print(gson.toJson(promotions));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}