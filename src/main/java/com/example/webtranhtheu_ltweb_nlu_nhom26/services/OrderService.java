package com.example.webtranhtheu_ltweb_nlu_nhom26.services;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin.OrderDTO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.user.order.Order;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.user.order.OrderProduct;
import com.example.webtranhtheu_ltweb_nlu_nhom26.dao.OrderDAO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.db.JDBIConnector;

import java.util.List;

public class OrderService {
    private static OrderDAO orderDAO = JDBIConnector.getInstance().onDemand(OrderDAO.class);

    public static List<OrderDTO> getListOrderDTO() {
        return orderDAO.getListOrderDTO();
    }
    public static List<Order> getListOrderByUser(int accountId){
        return orderDAO.getListOrderByUser(accountId);
    }
    public static List<OrderProduct> getListOrderProductByOrderId(int orderId){
        return orderDAO.getListOrderProductByOrderId(orderId);
    }
    public static List<Order> getListOrderByUserAndStatus(int accountId, int status){
        return orderDAO.getListOrderByUserAndStatus(accountId, status);
    }
}
