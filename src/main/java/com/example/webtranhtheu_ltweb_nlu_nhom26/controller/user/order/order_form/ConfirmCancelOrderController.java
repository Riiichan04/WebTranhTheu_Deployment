package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.user.order.order_form;

import com.example.webtranhtheu_ltweb_nlu_nhom26.services.OrderService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ConfirmCancelOrderController", value = "/confirm-cancel-order")
public class ConfirmCancelOrderController extends HttpServlet {
    public OrderService orderService = new OrderService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderId = request.getParameter("orderId");
        String cancelReason = request.getParameter("cancelReason");
        System.out.println(orderId);
        System.out.println(cancelReason);
        orderService.updateStatus(Integer.parseInt(orderId), 0);
        orderService.insertCancelOrder(Integer.parseInt(orderId), Integer.parseInt(cancelReason));
    }
}