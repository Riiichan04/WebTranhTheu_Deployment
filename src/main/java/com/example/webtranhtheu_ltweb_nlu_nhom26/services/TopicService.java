package com.example.webtranhtheu_ltweb_nlu_nhom26.services;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin.TopicDTO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Topic;
import com.example.webtranhtheu_ltweb_nlu_nhom26.dao.TopicDAO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.db.JDBIConnector;

import java.sql.Timestamp;
import java.util.List;

public class TopicService {
    private static TopicDAO topicDAO;

    public TopicService() {
        topicDAO = JDBIConnector.getInstance().onDemand(TopicDAO.class);
    }
    public List<TopicDTO> getTopicsDTO() {
        return topicDAO.getListTopicDTO();
    }

    public boolean addTopic(Topic topic) {
        return topicDAO.insertTopic(topic);
    }

    public Topic getTopicById(int id) {
        return topicDAO.getTopicById(id);
    }

    public List<Product> listProductInTopic(int topicId) {
        return topicDAO.getProductsByTopicId(topicId);
    }

    public List<Product> listProductNotInTopic(int topicId) {
        return topicDAO.getProductsNotInTopic(topicId);
    }

    public void updateTopic(Topic topic, String[] deleteProductsId, String[] addProductsId) {
        topicDAO.updateTopic(topic);
        for(String productId : deleteProductsId) {
            topicDAO.deleteTopic(Integer.parseInt(productId), topic.getId());
        }
        for(String productId : addProductsId) {
            topicDAO.insertTopicProducts(topic.getId(), Integer.parseInt(productId), new Timestamp(System.currentTimeMillis()));
        }
    }

    public List<Topic> getListTopics() {
        return topicDAO.getListTopics();
    }
}
