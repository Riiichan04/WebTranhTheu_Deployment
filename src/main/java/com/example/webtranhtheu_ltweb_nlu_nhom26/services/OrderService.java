package com.example.webtranhtheu_ltweb_nlu_nhom26.services;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin.OrderDTO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.dao.OrderDAO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.db.JDBIConnector;

import java.sql.Timestamp;
import java.util.List;

public class OrderService {
    private static OrderDAO orderDAO = JDBIConnector.getInstance().onDemand(OrderDAO.class);

    public static List<OrderDTO> getListOrderDTO() {
        return orderDAO.getListOrderDTO();
    }

    public static void addOrder(int userId, String[] productSelected, String[] amountProduct,  int discountId, String addressShipping, Timestamp deliveredAt, int statusOrder, int cancelOrder, int method, int statusPay) {
        orderDAO.insertOrder(userId, statusOrder, deliveredAt, addressShipping, statusPay, method);
        for(int i=0; i<productSelected.length; i++) {

        }
    }
}
