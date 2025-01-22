package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.admin.topic;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Topic;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.TopicService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(name = "GetFormReadUpdateTopicController", value = "/admin/topic-management/read-edit-topic-form")
public class GetFormReadUpdateTopicController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        int topicId = request.getParameter("topicId") == null ? -1 : Integer.parseInt(request.getParameter("topicId"));
        TopicService topicService = new TopicService();
        Topic t = topicService.getTopicById(topicId);
        List<Product> listProduct = topicService.listProductInTopic(topicId);
        List<Product> listProductNotInTopic = topicService.listProductNotInTopic(topicId);

        if (t == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            request.setAttribute("topic", t);
            request.setAttribute("listProduct", listProduct);
            request.setAttribute("listProductNotInTopic", listProductNotInTopic);

            Timestamp timestamp = t.getCreatedAt();
            Timestamp timestampUpdate = t.getUpdatedAt();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            String formattedDate = dateFormat.format(timestamp); // Chuyển đổi sang định dạng yyyy-MM-dd
            request.setAttribute("createAt", formattedDate);
            String formattedDateUpdate = dateFormat.format(timestampUpdate);
            request.setAttribute("updateAt", formattedDateUpdate);

            request.getRequestDispatcher("/layout/admin/topic-form/read-edit-topic-form.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}