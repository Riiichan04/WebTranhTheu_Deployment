package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.admin;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin.OrderDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DashBoardController", value = "/admin/dashboard")
public class DashBoardController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //chưa xử lý service
        String totalRevenue = "7.123.567.000";
        int totalProduct = 1200;
        int totalTopic = 12;
        int totalCategory = 3;
        int totalPolicy = 20;
        int totalUser = 3012;
        int totalOrder = 13000;
        int totalOn1StatusOrder = 12; //Chờ xác nhận
        int totalOn2StatusOrder = 10; //Chờ lấy hàng
        int totalOn3StatusOrder = 40; //Chờ giao hàng
        int totalOn4StatusOrder = 120; //Đã giao
        int totalOn5StatusOrder = 1040; //Đã nhận hàng
        int totalOn6StatusOrder = 130; //Đơn yêu cầu hoàn trả
        int totalOn1StatusPayment = 1200; //Đã thanh toán
        int totalOn0StatusPayment = 1200; //Chưa thanh toán

        List<OrderDTO> listOrder = new ArrayList<>();
        listOrder.add(new OrderDTO(1, "Nguyễn Văn An", "anvan2k4", 2000000, new Timestamp(System.currentTimeMillis()), 1, 1));
        listOrder.add(new OrderDTO(1, "Nguyễn Văn An", "anvan2k4", 20000000, new Timestamp(System.currentTimeMillis()), 1, 1));
        listOrder.add(new OrderDTO(1, "Nguyễn Văn An", "anvan2k4", 20000000, new Timestamp(System.currentTimeMillis()), 1, 1));
        listOrder.add(new OrderDTO(1, "Nguyễn Văn An", "anvan2k4", 20000000, new Timestamp(System.currentTimeMillis()), 1, 1));
        listOrder.add(new OrderDTO(1, "Nguyễn Văn An", "anvan2k4", 20000000, new Timestamp(System.currentTimeMillis()), 1, 1));
        listOrder.add(new OrderDTO(1, "Nguyễn Văn An", "anvan2k4", 20000000, new Timestamp(System.currentTimeMillis()), 1, 1));
        listOrder.add(new OrderDTO(1, "Nguyễn Văn An", "anvan2k4", 20000000, new Timestamp(System.currentTimeMillis()), 1, 1));
        listOrder.add(new OrderDTO(1, "Nguyễn Văn An", "anvan2k4", 20000000, new Timestamp(System.currentTimeMillis()), 1, 1));
        listOrder.add(new OrderDTO(1, "Nguyễn Văn An", "anvan2k4", 20000000, new Timestamp(System.currentTimeMillis()), 1, 1));
        listOrder.add(new OrderDTO(1, "Nguyễn Văn An", "anvan2k4", 20000000, new Timestamp(System.currentTimeMillis()), 1, 1));
        listOrder.add(new OrderDTO(1, "Nguyễn Văn An", "anvan2k4", 20000000, new Timestamp(System.currentTimeMillis()), 1, 1));
        listOrder.add(new OrderDTO(1, "Nguyễn Văn An", "anvan2k4", 20000000, new Timestamp(System.currentTimeMillis()), 1, 1));
        listOrder.add(new OrderDTO(1, "Nguyễn Văn An", "anvan2k4", 20000000, new Timestamp(System.currentTimeMillis()), 1, 1));
        listOrder.add(new OrderDTO(1, "Nguyễn Văn An", "anvan2k4", 20000000, new Timestamp(System.currentTimeMillis()), 1, 1));
        listOrder.add(new OrderDTO(1, "Nguyễn Văn An", "anvan2k4", 20000000, new Timestamp(System.currentTimeMillis()), 1, 1));
        listOrder.add(new OrderDTO(1, "Nguyễn Văn An", "anvan2k4", 20000000, new Timestamp(System.currentTimeMillis()), 1, 1));
        listOrder.add(new OrderDTO(1, "Nguyễn Văn An", "anvan2k4", 20000000, new Timestamp(System.currentTimeMillis()), 1, 1));
        listOrder.add(new OrderDTO(1, "Nguyễn Văn An", "anvan2k4", 20000000, new Timestamp(System.currentTimeMillis()), 1, 1));
        listOrder.add(new OrderDTO(1, "Nguyễn Văn An", "anvan2k4", 20000000, new Timestamp(System.currentTimeMillis()), 1, 1));
        listOrder.add(new OrderDTO(1, "Nguyễn Văn An", "anvan2k4", 20000000, new Timestamp(System.currentTimeMillis()), 1, 1));
        listOrder.add(new OrderDTO(1, "Nguyễn Văn An", "anvan2k4", 20000000, new Timestamp(System.currentTimeMillis()), 1, 1));
        listOrder.add(new OrderDTO(1, "Nguyễn Văn An", "anvan2k4", 20000000, new Timestamp(System.currentTimeMillis()), 1, 1));
        listOrder.add(new OrderDTO(1, "Nguyễn Văn An", "anvan2k4", 20000000, new Timestamp(System.currentTimeMillis()), 1, 1));
        listOrder.add(new OrderDTO(1, "Nguyễn Văn An", "anvan2k4", 20000000, new Timestamp(System.currentTimeMillis()), 1, 1));
        listOrder.add(new OrderDTO(1, "Nguyễn Văn An", "anvan2k4", 20000000, new Timestamp(System.currentTimeMillis()), 1, 1));
        listOrder.add(new OrderDTO(1, "Nguyễn Văn An", "anvan2k4", 20000000, new Timestamp(System.currentTimeMillis()), 1, 1));

        request.setAttribute("totalRevenue", totalRevenue);
        request.setAttribute("totalProduct", totalProduct);
        request.setAttribute("totalTopic", totalTopic);
        request.setAttribute("totalCategory", totalCategory);
        request.setAttribute("totalPolicy", totalPolicy);
        request.setAttribute("totalUser", totalUser);
        request.setAttribute("totalOrder", totalOrder);
        request.setAttribute("totalOn1StatusOrder", totalOn1StatusOrder);
        request.setAttribute("totalOn2StatusOrder", totalOn2StatusOrder);
        request.setAttribute("totalOn3StatusOrder", totalOn3StatusOrder);
        request.setAttribute("totalOn4StatusOrder", totalOn4StatusOrder);
        request.setAttribute("totalOn5StatusOrder", totalOn5StatusOrder);
        request.setAttribute("totalOn6StatusOrder", totalOn6StatusOrder);
        request.setAttribute("listOrder", listOrder);
        request.setAttribute("totalOn1StatusPayment", totalOn1StatusPayment);
        request.setAttribute("totalOn0StatusPayment", totalOn0StatusPayment);

        request.getRequestDispatcher("/layout/admin/dashboard.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}