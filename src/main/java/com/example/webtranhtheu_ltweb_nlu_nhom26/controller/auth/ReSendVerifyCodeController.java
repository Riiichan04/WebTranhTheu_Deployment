package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.auth;

import com.example.webtranhtheu_ltweb_nlu_nhom26.services.AuthService;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.VerifyService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ReSendVerifyCodeController", value = "/re-send-verify")
public class ReSendVerifyCodeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        int id = Integer.parseInt(request.getParameter("accountId"));
        AuthService authService = new AuthService();
        String email = authService.getEmail(id);
        if(email != null) {
            VerifyService verifyService = new VerifyService();
            verifyService.deleteVerificationCodeOld(id);
            verifyService.sendVerificationEmail(email, id);
            response.sendRedirect("/verify");
        } else {
            request.getRequestDispatcher("/login").forward(request, response);
        }
    }
}