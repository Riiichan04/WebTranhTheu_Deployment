package com.example.webtranhtheu_ltweb_nlu_nhom26.services;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin.OrderDTO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.dao.DashBoardAminDAO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.db.JDBIConnector;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class DashboardAdminService {
    private DashBoardAminDAO dashBoardAminDAO;

    public DashboardAdminService() {
        dashBoardAminDAO = JDBIConnector.getInstance().onDemand(DashBoardAminDAO.class);
    }

    public int getTotalProduct() {
        return dashBoardAminDAO.countProducts();
    }

    public int getTotalTopic() {
        return dashBoardAminDAO.countTopics();
    }

    public int getTotalCategory() {
        return dashBoardAminDAO.countCategories();
    }

    public int getTotalPolicy() {
        return dashBoardAminDAO.countPolicies();
    }

    public int getTotalUser() {
        return dashBoardAminDAO.countAccounts();
    }

    public int getTotalOrder() {
        return dashBoardAminDAO.countOrders();
    }

    public int getTotalOrderStatus1() {
        return dashBoardAminDAO.countOrdersStatus1();
    }

    public int getTotalOrderStatus2() {
        return dashBoardAminDAO.countOrdersStatus2();
    }

    public int getTotalOrderStatus3() {
        return dashBoardAminDAO.countOrdersStatus3();
    }

    public int getTotalOrderStatus4() {
        return dashBoardAminDAO.countOrdersStatus4();
    }

    public int getTotalOrderStatus5() {
        return dashBoardAminDAO.countOrdersStatus5();
    }

    public int getTotalOrderStatus6() {
        return dashBoardAminDAO.countOrdersStatus6();
    }

    public int getTotalOrderPayStatus0() {
        return dashBoardAminDAO.countPaymentStatus0();
    }

    public int getTotalOrderPayStatus1() {
        return dashBoardAminDAO.countPaymentStatus1();
    }

    public String getSumAllOrderPrice() {
        // Tạo đối tượng NumberFormat cho tiền tệ Việt Nam (VND)
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
        // Định dạng số thành dạng tiền tệ VNĐ
        String formattedAmount = currencyFormat.format(dashBoardAminDAO.sumOrderValue());
        return formattedAmount;
    }

    public List<OrderDTO> getLastListOrder() {
        return dashBoardAminDAO.getLastListOrder();
    }
}
