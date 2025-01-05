package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.admin.promotion;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin.PromotionDTO;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GetPromotionDataController", value = "/admin/promotion-management/get-promotion")
public class GetPromotionDataController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        //chưa xử lý service
        List<PromotionDTO> promotions = new ArrayList<>();
        promotions.add(new PromotionDTO(1, "Giảm giá lễ 30/4", new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), 122, 1));

        Gson gson = new Gson();
        response.getWriter().print(gson.toJson(promotions));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}