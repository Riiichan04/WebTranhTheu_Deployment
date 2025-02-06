package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.user;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.user.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "ViewedHistoryController", value = "/user/user-viewed-history")
public class ViewedHistoryController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        User account = (User) session.getAttribute("account");
        // làm chức năng lưu lịch sử xem
        request.getRequestDispatcher("/layout/user/user-viewed-info.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}