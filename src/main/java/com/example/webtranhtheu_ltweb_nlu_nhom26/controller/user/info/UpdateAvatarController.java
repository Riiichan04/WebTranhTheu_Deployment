package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.user.info;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.user.User;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.UserService;
import com.example.webtranhtheu_ltweb_nlu_nhom26.util.CloudinaryConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "UpdateAvatarController", value = "/update-avatar")
public class UpdateAvatarController extends HttpServlet {
    public UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part avatar = request.getPart("avatar");
        String avatarUrl = CloudinaryConfig.getUrl(avatar);
        HttpSession session = request.getSession();
        User account= (User) session.getAttribute("account");
        System.out.println(avatarUrl);
        if (account == null) {
            response.sendRedirect("/login");
        }
        if(avatarUrl == null || avatarUrl.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }else {
            userService.updateAvatarUser(account.getId(), avatarUrl);
            account.setAvatarUrl(avatarUrl);
            System.out.println(account.getAvatarUrl());
        }
        session.setAttribute("account", account);
    }
}