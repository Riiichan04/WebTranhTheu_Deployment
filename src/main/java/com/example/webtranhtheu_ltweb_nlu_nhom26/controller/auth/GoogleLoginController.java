package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.auth;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.User;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.AuthService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.*;
import java.sql.Timestamp;

@WebServlet(name = "GoogleLoginController", value = "/google-login")
public class GoogleLoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String image  = request.getParameter("image");
        AuthService authService = new AuthService();
        Integer accountId = authService.getIdByEmail(email);
        if(accountId == null){
            User user = new User(name, email, image, 2, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), 0);
            authService.addUser(user);
            accountId = authService.getIdByEmail(email);
        }
        HttpSession session = request.getSession();
        session.setAttribute("accountId", accountId);
    }
}