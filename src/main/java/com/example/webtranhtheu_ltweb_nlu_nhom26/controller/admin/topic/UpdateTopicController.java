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

@WebServlet(name = "UpdateTopicController", value = "/admin/topic-management/update-topic")
public class UpdateTopicController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy dữ liệu từ form
        String topicId = request.getParameter("topicId");
        String name = request.getParameter("name");
        String[] selectedProductIdsDelete = request.getParameterValues("selectedProductIdsDelete")==null?new String[0]:request.getParameterValues("selectedProductIdsDelete");
        String[] selectedProductIdsAdd = request.getParameterValues("selectedProductIdsAdd")==null?new String[0]:request.getParameterValues("selectedProductIdsAdd");
        int active = Integer.parseInt(request.getParameter("statusTopic"));
        Topic topic = new Topic(Integer.parseInt(topicId), name, active, null, new Timestamp(System.currentTimeMillis()));
        TopicService topicService = new TopicService();
        topicService.updateTopic(topic, selectedProductIdsDelete, selectedProductIdsAdd);
    }
}