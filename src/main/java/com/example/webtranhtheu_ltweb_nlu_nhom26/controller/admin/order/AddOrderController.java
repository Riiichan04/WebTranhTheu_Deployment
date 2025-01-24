package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.admin.order;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@WebServlet(name = "AddOrderController", value = "/admin/order-management/add-order")
public class AddOrderController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        String[] productSelected =request.getParameterValues("productSelected");
        String[] amountProduct =request.getParameterValues("amountProduct");
        String discountId = request.getParameter("discountId");
        String addressShipping = request.getParameter("addressShipping");

        String deliveredAt = request.getParameter("deliveredAt");
        LocalDateTime localDateTime = LocalDateTime.parse(deliveredAt);
        Timestamp timestampDeliveredAt = Timestamp.valueOf(localDateTime);

        int statusOrder = Integer.parseInt(request.getParameter("statusOrder"));
        int method = Integer.parseInt(request.getParameter("method"));
        int statusPay = Integer.parseInt(request.getParameter("statusPay"));
        int cancelOrder = Integer.parseInt(request.getParameter("reasonCancelOrder"));

    }
}