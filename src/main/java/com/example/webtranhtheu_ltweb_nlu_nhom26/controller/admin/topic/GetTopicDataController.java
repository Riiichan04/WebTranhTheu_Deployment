package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.admin.topic;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin.TopicDTO;
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

@WebServlet(name = "GetTopicDataController", value = "/admin/topic-management/get-topic")
public class GetTopicDataController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        //chưa xử lý service
        List<TopicDTO> topics = new ArrayList<>();
        topics.add(new TopicDTO(1, "Tranh thêu phong cảnh", 1200, 122, new Timestamp(System.currentTimeMillis()), 1));

        Gson gson = new Gson();
        response.getWriter().print(gson.toJson(topics));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}