package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.auth;

import com.example.webtranhtheu_ltweb_nlu_nhom26.services.UserService;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.VerifyService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "VerifyController", value = "/verify")
public class VerifyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/layout/verify.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        int code = Integer.parseInt(request.getParameter("code"));

        VerifyService verifyService = new VerifyService();
        if (verifyService.checkCode(code) != null) {
            UserService userService = new UserService();
            boolean update = userService.updateStatus(verifyService.checkCode(code), 2);
            response.setContentType("application/json");
            if (update) {
                response.getWriter().write("{\"success\": true}");
            } else {
                response.getWriter().write("{\"success\": false}");
            }
        }

    }
}