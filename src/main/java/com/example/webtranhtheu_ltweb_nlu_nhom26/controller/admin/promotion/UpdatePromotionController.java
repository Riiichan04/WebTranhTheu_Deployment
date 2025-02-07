package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.admin.promotion;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Discount;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.DiscountService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@WebServlet(name = "UpdatePromotionController", value = "/admin/promotion-management/update-promotion")
public class UpdatePromotionController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        int promotionId = Integer.parseInt(request.getParameter("promotionId"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        double value = Double.parseDouble(request.getParameter("value"));

        String startedAt = request.getParameter("startedAt");
        LocalDateTime startTime = LocalDateTime.parse(startedAt);
        Timestamp startTimestamp = Timestamp.valueOf(startTime);

        String endedAt = request.getParameter("endedAt");
        LocalDateTime endedTime = LocalDateTime.parse(endedAt);
        Timestamp endedTimestamp = Timestamp.valueOf(endedTime);

        if(endedTimestamp.before(startTimestamp)) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

        String[] selectedProductIdsDelete = request.getParameterValues("selectedProductIdsDelete") == null ? new String[0] : request.getParameterValues("selectedProductIdsDelete");
        String[] selectedProductIdsAdd = request.getParameterValues("selectedProductIdsAdd") == null ? new String[0] : request.getParameterValues("selectedProductIdsAdd");

        Discount discount = new Discount(title, description, value, startTimestamp, endedTimestamp);
        discount.setId(promotionId);

        DiscountService discountService = new DiscountService();
        discountService.updateDiscount(discount);
        discountService.addDiscountProduct(selectedProductIdsAdd, discount.getId());
        discountService.deleteDiscountProduct(selectedProductIdsDelete, discount.getId());

    }
}