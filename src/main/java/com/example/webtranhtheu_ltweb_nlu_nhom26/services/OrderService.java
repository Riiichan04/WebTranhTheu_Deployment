package com.example.webtranhtheu_ltweb_nlu_nhom26.services;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.User;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin.OrderDTO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.order.Order;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.order.OrderDetails;
import com.example.webtranhtheu_ltweb_nlu_nhom26.dao.OrderDAO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.db.JDBIConnector;

import java.sql.Timestamp;
import java.util.List;

public class OrderService {
    private static OrderDAO orderDAO = JDBIConnector.getInstance().onDemand(OrderDAO.class);

    public static List<OrderDTO> getListOrderDTO() {
        return orderDAO.getListOrderDTO();
    }

    public static Order getOrderById(int orderId) {
        Order order = orderDAO.getOrderById(orderId);
        User user = orderDAO.getUserByOrderId(orderId);
        order.setUser(user);
        List<OrderDetails> listOrderDetails = orderDAO.getOrderDetailByOrderId(orderId);
        order.setListOrderDetails(listOrderDetails);
        return order;
    }

    public static boolean updateOrder(int orderId, int statusOrder, Timestamp deliveredAt) {
        return orderDAO.updateOrderStatus(orderId, statusOrder, deliveredAt);
    }

    public static void deleteCancelReasonOrder(int orderId) {
        orderDAO.deleteCancelReasonByOrderId(orderId);
    }

    public static void insertCancelReasonOrder(int orderId, int reason) {
        orderDAO.insertCancelReasonOrder(orderId, reason);
    }
}
