package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.admin.topic;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Topic;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.TopicService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Timestamp;

@WebServlet(name = "AddTopicController", value = "/admin/topic-management/add-topic")
public class AddTopicController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy dữ liệu từ form
        String title = request.getParameter("name");
        int active = Integer.parseInt(request.getParameter("status"));

        TopicService topicService = new TopicService();
        Topic topic = new Topic(title,  active, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()));
        response.setContentType("application/json");
        if(topicService.addTopic(topic)){
            response.getWriter().write("{\"success\": true}");
        } else {
            response.getWriter().write("{\"success\": false}");
        }
    }
}