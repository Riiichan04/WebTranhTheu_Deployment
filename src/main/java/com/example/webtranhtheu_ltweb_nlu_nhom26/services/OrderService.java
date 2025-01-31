package com.example.webtranhtheu_ltweb_nlu_nhom26.services;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin.OrderDTO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.cart.CartProduct;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.user.order.OrderProduct;
import com.example.webtranhtheu_ltweb_nlu_nhom26.dao.OrderDAO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.db.JDBIConnector;
import org.jdbi.v3.sqlobject.customizer.Bind;

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

    //Thêm hằng số cho class Order
    //Dùng tsql ????
    public static boolean createOrder(int accountId, String address, int orderId, int method, List<CartProduct> listProduct) {
        if (createNewOrder(accountId, 1, address, 1, 1)) {
            for (CartProduct cartProduct : listProduct) {
                if (!addProductToOrder(orderId, cartProduct.getId(),
                        cartProduct.getQuantity(), cartProduct.getPrice().getPrice(),
                        cartProduct.getPrice().getWidth(), cartProduct.getPrice().getHeight())) return false;
            }
            return true;
        }
        else return false;
    }

    private static boolean createNewOrder(int accountId, int statusOrder, String shippingAddress, int statusPay, int method) {
        return orderDAO.createNewOrder(accountId, statusOrder, shippingAddress, statusPay, method) > 0;
    }

    private static boolean addProductToOrder(int orderId, int productId, int amount, double price, int width, int height) {
        return orderDAO.addDetailToOrder(orderId, productId, amount, price, width, height) > 0;
    }
}
