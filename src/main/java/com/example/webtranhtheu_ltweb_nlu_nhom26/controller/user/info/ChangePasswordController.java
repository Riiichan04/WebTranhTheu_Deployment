package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.user.info;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.user.User;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.UserService;
import com.example.webtranhtheu_ltweb_nlu_nhom26.util.PasswordEncryption;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "ChangePasswordController", value = "/user/change-password")
public class ChangePasswordController extends HttpServlet {
    public UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User account= (User) session.getAttribute("account");
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String dbOldPassword= userService.getPassword(account.getUsername());
        if(PasswordEncryption.checkPassword(oldPassword,dbOldPassword)){
            String newHashPassword= PasswordEncryption.hashPassword(newPassword);
            userService.updatePassword(account.getId(),newHashPassword);
            session.setAttribute("account",account);
        }else{
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}