package com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin.orderAdmin;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.user.User;

import java.sql.Timestamp;
import java.util.List;

public class OrderAdmin {
    //để tạm, sẽ tối ưu sau
    public static final int STATUS_ORDER_CANCELED = 0; // Đã hủy
    public static final int STATUS_ORDER_PENDING_CONFIRMATION = 1; // Chờ xác nhận
    public static final int STATUS_ORDER_WAITING_FOR_PICKUP = 2; // Chờ lấy hàng
    public static final int STATUS_ORDER_WAITING_FOR_DELIVERY = 3; // Chờ giao hàng
    public static final int STATUS_ORDER_DELIVERED = 4; // Đã giao
    public static final int STATUS_ORDER_RECEIVED = 5; // Đã nhận hàng
    public static final int STATUS_ORDER_RETURN_REQUESTED = 6; // Đơn yêu cầu hoàn trả
    public static final int STATUS_ORDER_DEPOSITED = 7; // Đã cọc

    public static final int STATUS_PAYMENT_PAID = 1; // Đã thanh toán
    public static final int STATUS_PAYMENT_UNPAID = 0; // Chưa thanh toán

    private int id;
    private User user;
    private int statusOrder;
    private Timestamp createdAt;
    private Timestamp deliveredAt;
    private String shippingAddress;
    private int statusPay;
    private int method;
    private int cancelReason;
    private List<OrderDetails> listOrderDetails;
    public OrderAdmin() {

    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public int getStatusOrder() {
        return statusOrder;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getDeliveredAt() {
        return deliveredAt;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public int getStatusPay() {
        return statusPay;
    }

    public int getMethod() {
        return method;
    }

    public List<OrderDetails> getListOrderDetails() {
        return listOrderDetails;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setStatusOrder(int statusOrder) {
        this.statusOrder = statusOrder;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setDeliveredAt(Timestamp deliveredAt) {
        this.deliveredAt = deliveredAt;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public void setStatusPay(int statusPay) {
        this.statusPay = statusPay;
    }

    public void setMethod(int method) {
        this.method = method;
    }

    public void setListOrderDetails(List<OrderDetails> listOrderDetails) {
        this.listOrderDetails = listOrderDetails;
    }

    public void setCancelReason(int cancelReason) {
        this.cancelReason = cancelReason;
    }

    public int getCancelReason() {
        return cancelReason;
    }
}
