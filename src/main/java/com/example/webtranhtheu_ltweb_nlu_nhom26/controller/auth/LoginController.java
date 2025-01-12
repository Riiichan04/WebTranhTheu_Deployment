package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.auth;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.AuthDTO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.AuthService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/layout/sign-in.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String error = null;

        AuthService authService = new AuthService();
        AuthDTO authDTO = authService.getAuth(username, password);

        if (authDTO == null) {
            error = "Tên đăng nhập hoặc mật khẩu sai.";
        }
        else if (authDTO.getStatusAccount() == 1) {
            request.setAttribute("accountId", authDTO.getId());
            request.getRequestDispatcher("/layout/sign-in.jsp").forward(request, response);
            return;
        } else if (authDTO.getStatusAccount() == 0) {
            error = "Tài khoản bạn đã bị khóa.";
        }

        if (error != null) {
            request.setAttribute("error", error);
            request.getRequestDispatcher("/layout/sign-in.jsp").forward(request, response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("accountId", authDTO.getId());
            if (authDTO.getRole() == 0) {
                response.sendRedirect("/");
            } else if (authDTO.getRole() == 1) {
                response.sendRedirect("/admin");
            }
        }

    }
}