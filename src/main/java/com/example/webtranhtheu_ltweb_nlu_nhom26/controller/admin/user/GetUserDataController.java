package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.admin.user;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin.TopicDTO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin.UserDTO;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GetUserDataController", value = "/admin/user-management/get-user")
public class GetUserDataController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        //chưa xử lý service
        List<UserDTO> users = new ArrayList<>();
        users.add(new UserDTO(1, "Nguyễn Văn An", "anvan2k4", "0123456789", 1, new Timestamp(System.currentTimeMillis()), 1));

        Gson gson = new Gson();
        response.getWriter().print(gson.toJson(users));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}