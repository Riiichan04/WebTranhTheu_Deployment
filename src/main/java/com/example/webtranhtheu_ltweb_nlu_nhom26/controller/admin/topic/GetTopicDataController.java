package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.admin.topic;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin.TopicDTO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.TopicService;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetTopicDataController", value = "/admin/topic-management/get-topic")
public class GetTopicDataController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        TopicService topicService = new TopicService();
        List<TopicDTO> topics = topicService.getTopicsDTO();

        Gson gson = new Gson();
        response.getWriter().print(gson.toJson(topics));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}