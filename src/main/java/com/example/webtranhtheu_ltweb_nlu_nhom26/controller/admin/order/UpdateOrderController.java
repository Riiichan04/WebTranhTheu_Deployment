package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.admin.order;

import com.example.webtranhtheu_ltweb_nlu_nhom26.services.OrderService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "UpdateOrderController", value = "/admin/order-management/update-order")
public class UpdateOrderController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int orderId = Integer.parseInt(request.getParameter("orderId"));
            int statusOrder = Integer.parseInt(request.getParameter("statusOrder"));
            int cancelReason = Integer.parseInt(request.getParameter("cancelReason"));
            String deliveredDate = request.getParameter("deliveredAt");
            Timestamp deliveredTimestamp = null;
            if(deliveredDate!=null && !deliveredDate.isEmpty()){
                LocalDate localDate = LocalDate.parse(deliveredDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                // Chuyển đổi LocalDate sang LocalDateTime (thêm giờ phút giây = 00:00:00)
                LocalDateTime localDateTimeDelivered = localDate.atStartOfDay();
                deliveredTimestamp = Timestamp.valueOf(localDateTimeDelivered);
            }

            response.setContentType("application/json");
            if(OrderService.updateOrder(orderId, statusOrder, deliveredTimestamp)){
                OrderService.deleteCancelReasonOrder(orderId);
                if(statusOrder==0){
                    OrderService.insertCancelReasonOrder(orderId, cancelReason);
                }
                response.getWriter().write("{\"success\": true}");
            } else {
                response.getWriter().write("{\"success\": false}");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}