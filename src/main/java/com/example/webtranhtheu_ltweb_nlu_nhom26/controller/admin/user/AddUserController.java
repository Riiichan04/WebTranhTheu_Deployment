package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.admin.user;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.User;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.UserService;
import com.example.webtranhtheu_ltweb_nlu_nhom26.util.CloudinaryConfig;
import com.example.webtranhtheu_ltweb_nlu_nhom26.util.PasswordEncryption;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.sql.Timestamp;

@WebServlet(name = "AddUserController", value = "/admin/user-management/add-user")
@MultipartConfig
public class AddUserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = PasswordEncryption.hashPassword(request.getParameter("password"));
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email") == null ? request.getParameter("email") : "";
        String phone = request.getParameter("phone") == null ? "" : request.getParameter("phone");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String description = request.getParameter("description") == null ? "" : request.getParameter("description");
        int statusAccount = Integer.parseInt(request.getParameter("statusAccount"));
        int role = Integer.parseInt(request.getParameter("role"));

        Part filePart = request.getPart("avatar");

        String avatarUrl = CloudinaryConfig.getUrl(filePart);

        UserService userService = new UserService();
        User user = new User(avatarUrl, username, fullName, password, email, phone, gender, description, statusAccount, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), role);
        response.setContentType("application/json");
        if(userService.addUser(user)) {
            response.getWriter().write("{\"success\":true}");
        } else {
            response.getWriter().write("{\"success\":false}");
        }
    }
}