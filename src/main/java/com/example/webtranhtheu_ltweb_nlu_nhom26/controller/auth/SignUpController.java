package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.auth;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.User;
import com.example.webtranhtheu_ltweb_nlu_nhom26.mail.PasswordEncryption;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.AuthService;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.VerifyService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Timestamp;

@WebServlet(name = "SignUpController", value = "/sign-up")
public class SignUpController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/layout/sign-up.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        AuthService authService = new AuthService();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = authService.normalizeEmail(request.getParameter("email"));
        String fullName = request.getParameter("full-name");
        String error = null;

        if(!authService.checkPassword(password)) {
            error = "Mật khẩu không hợp lệ!";
        }
        if(!authService.checkUsername(username)) {
            error = "Tên đăng nhập đã tồn tại!";
        }
        if(!authService.checkEmail(email)) {
            error = "Tài khoản email đã được dùng, vui lòng đổi taì khoản!";
        }

        if(error != null) {
            request.setAttribute("error", error);
            request.getRequestDispatcher("/layout/sign-up.jsp").forward(request, response);
        } else {
            password = PasswordEncryption.hashPassword(password);
            User user = new User(username, fullName, password, email, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), 0, 1);
            if(authService.addUser(user)) {
                VerifyService verifyService = new VerifyService();
                if(authService.getAccountId(username) != null) {
                    //gửi email
                    verifyService.sendVerificationEmail(email, authService.getAccountId(username));
                    response.sendRedirect("/verify");
                }
            } else {
                error = "Đã xảy ra lỗi. Vui lòng thử lại!";
                request.setAttribute("error", error);
                request.getRequestDispatcher("/layout/sign-up.jsp").forward(request, response);
            }
        }
    }
}