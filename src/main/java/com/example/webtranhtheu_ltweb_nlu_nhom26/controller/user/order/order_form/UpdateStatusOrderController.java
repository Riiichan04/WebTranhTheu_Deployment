package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.user.order.order_form;

import com.example.webtranhtheu_ltweb_nlu_nhom26.services.OrderService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "UpdateStatusOrderController", value = "/user/update-order-status")
public class UpdateStatusOrderController extends HttpServlet {
    public OrderService orderService = new OrderService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String orderId= request.getParameter("orderId");
        String status= request.getParameter("status");
        if(orderId.isEmpty() || status.isEmpty()){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }else{
            orderService.updateStatus(Integer.parseInt(orderId), Integer.parseInt(status));
        }
    }
}