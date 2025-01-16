package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.admin.promotion;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Discount;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.DiscountService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "GetFormReadUpdatePromotionController", value = "/admin/promotion-management/read-edit-promotion-form")
public class GetFormReadUpdatePromotionController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String  discountId = request.getParameter("discountId");
        DiscountService discountService = new DiscountService();
        Discount discount = discountService.getDiscount(Integer.parseInt(discountId));
        request.setAttribute("discount", discount);

        Timestamp timestampStart = discount.getStartedAt();
        Timestamp timestampEnd = discount.getEndedAt();
        // Chuyển Timestamp sang LocalDateTime
        LocalDateTime localDateTimeStart = timestampStart.toLocalDateTime();
        LocalDateTime localDateTimeEnd = timestampEnd.toLocalDateTime();

        // Định dạng thành chuỗi theo yêu cầu của datetime-local
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        String formattedDateTimeStart = localDateTimeStart.format(formatter);
        String formattedDateTimeEnd = localDateTimeEnd.format(formatter);
        request.setAttribute("startedAt", formattedDateTimeStart);
        request.setAttribute("endedAt", formattedDateTimeEnd);

        Timestamp timestampCreated = discount.getCreatedAt();
        Timestamp timestampUpdated = discount.getUpdatedAt();
        LocalDateTime localDateTimeCreated = timestampCreated.toLocalDateTime();
        LocalDateTime localDateTimeUpdated = timestampUpdated.toLocalDateTime();

        String formattedDateCreated = localDateTimeCreated.format(formatter);
        request.setAttribute("createAt", formattedDateCreated);
        String formattedDateUpdated = localDateTimeUpdated.format(formatter);
        request.setAttribute("updateAt", formattedDateUpdated);

        request.getRequestDispatcher("/layout/admin/promotion-form/read-edit-promotion-form.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}