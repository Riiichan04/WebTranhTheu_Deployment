package com.example.webtranhtheu_ltweb_nlu_nhom26.services;

import com.example.webtranhtheu_ltweb_nlu_nhom26.dao.ProductDAO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.dao.UserDAO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.db.JDBIConnector;

public class UserService {
    UserDAO userDAO;

    public UserService() {
        this.userDAO = JDBIConnector.getInstance().onDemand(UserDAO.class);
    }
    //Để tạm thôi
    public String getUsername(int userId) {
        return userDAO.getUsername(userId);
    }

    // cập nhật trạng thái cho user
    public boolean updateStatus(int userId, int status) {
        return userDAO.updateStatus(userId, status);
    }

}
