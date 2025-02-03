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

    public int getTotalOrderStatus(int status) {
        return dashBoardAminDAO.countOrdersStatus(status);
    }

    public int getTotalOrderPayStatus(int status) {
        return dashBoardAminDAO.countPaymentStatus(status);
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
