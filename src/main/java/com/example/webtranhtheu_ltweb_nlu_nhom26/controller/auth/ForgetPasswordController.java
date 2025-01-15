package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.auth;

import com.example.webtranhtheu_ltweb_nlu_nhom26.services.AuthService;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.VerifyService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ForgetPasswordController", value = "/forget-password")
public class ForgetPasswordController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/layout/forget-password.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        AuthService authService = new AuthService();

        String email = authService.normalizeEmail(request.getParameter("email"));
        String username = request.getParameter("username");
        String error = null;

        if(authService.getAccountIdByEmailAndUsername(email, username) == null) {
            error = "Tài khoản không tồn tại.";
        }

        if(error != null){
            request.setAttribute("error", error);
        } else {
            int accountId = authService.getAccountIdByEmailAndUsername(email, username);
            request.setAttribute("accountId", accountId);
            VerifyService verifyService = new VerifyService();
            verifyService.deleteVerificationCodeOld(accountId);
            verifyService.sendVerificationEmail(email, accountId);
        }
        request.getRequestDispatcher("/layout/forget-password.jsp").forward(request, response);
    }
}