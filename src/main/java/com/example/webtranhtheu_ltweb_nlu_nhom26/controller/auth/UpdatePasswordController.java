package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.auth;

import com.example.webtranhtheu_ltweb_nlu_nhom26.util.PasswordEncryption;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.AuthService;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.UserService;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.VerifyService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "UpdatePasswordController", value = "/update-pass")
public class UpdatePasswordController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        int accountId = Integer.parseInt(request.getParameter("accountId"));
        int code = Integer.parseInt(request.getParameter("code"));
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        String error = null;
        AuthService authService = new AuthService();

        if (!password.equals(confirmPassword)) {
            error = "Mật khẩu không khớp. Vui lòng xác nhận lại mật khẩu.";
        }
        if (!authService.checkPassword(password)) {
            error = "Mật khẩu không hợp lệ.";
        }

        response.setContentType("application/json");
        if (error != null) {
            response.getWriter().write("{\"error\": true, \"message\": \"" + error + "\"}");
        } else {
            VerifyService verifyService = new VerifyService();
            if (verifyService.checkCode(code) != null && accountId == verifyService.checkCode(code)) {
                String updatePass = PasswordEncryption.hashPassword(password);
                UserService userService = new UserService();
                boolean update = userService.updatePassword(accountId, updatePass);
                if (update) {
                    verifyService.deleteVerificationCodeOld(accountId);
                    response.getWriter().write("{\"success\": true}");
                } else {
                    response.getWriter().write("{\"success\": false}");
                }
            } else {
                response.getWriter().write("{\"success\": false}");
            }
        }
    }
}