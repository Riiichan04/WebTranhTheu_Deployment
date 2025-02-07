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

@WebServlet(name = "AddPromotionController", value = "/admin/promotion-management/add-promotion")
public class AddPromotionController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String title = request.getParameter("name");
        String description = request.getParameter("description");
        String[] selectedDiscountProduct = request.getParameterValues("selectedDiscountProduct") == null ? new String[0] : request.getParameterValues("selectedDiscountProduct");

        String startedAt = request.getParameter("startedAt");
        LocalDateTime startTime = LocalDateTime.parse(startedAt);
        Timestamp startTimestamp = Timestamp.valueOf(startTime);

        String endedAt = request.getParameter("endedAt");
        LocalDateTime endedTime = LocalDateTime.parse(endedAt);
        Timestamp endedTimestamp = Timestamp.valueOf(endedTime);

        double value = Double.parseDouble(request.getParameter("value") == null ? "0" : request.getParameter("value"));

        if (endedTimestamp.before(startTimestamp)) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        DiscountService discountService = new DiscountService();
        Discount discount = new Discount(title, description, value, startTimestamp, endedTimestamp);

        int discountId = discountService.addDiscount(discount);
        discountService.addDiscountProduct(selectedDiscountProduct, discountId);
    }
}