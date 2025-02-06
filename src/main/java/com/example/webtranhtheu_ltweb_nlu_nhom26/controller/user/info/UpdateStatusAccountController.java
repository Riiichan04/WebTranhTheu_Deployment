package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.user.info;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.user.User;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "UpdateStatusAccountController", value = "/user/deactivate-user")
public class UpdateStatusAccountController extends HttpServlet {
    public UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String accountId = request.getParameter("accountId");
        userService.updateUserStatus(Integer.parseInt(accountId), 0);
        session.invalidate();  // Hủy session hiện tại
        response.sendRedirect("/");
    }
}