package com.example.webtranhtheu_ltweb_nlu_nhom26.services;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin.OrderDTO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.cart.CartProduct;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.user.order.OrderProduct;
import com.example.webtranhtheu_ltweb_nlu_nhom26.dao.OrderDAO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.db.JDBIConnector;

import java.util.List;

public class OrderService {
    private static OrderDAO orderDAO = JDBIConnector.getInstance().onDemand(OrderDAO.class);

    public static List<OrderDTO> getListOrderDTO() {
        return orderDAO.getListOrderDTO();
    }

    public static OrderProduct convertCartToOrder(CartProduct cartProduct, int chosenAmount) {
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setId(cartProduct.getId());
        orderProduct.setTitle(cartProduct.getTitle());
        orderProduct.setThumbnail(cartProduct.getThumbnailUrl());
        orderProduct.setWidth(cartProduct.getPrice().getWidth());
        orderProduct.setHeight(cartProduct.getPrice().getHeight());
        orderProduct.setPrice(cartProduct.getPrice().getPrice());
        orderProduct.setQuantity(chosenAmount);
        return orderProduct;
    }
}
