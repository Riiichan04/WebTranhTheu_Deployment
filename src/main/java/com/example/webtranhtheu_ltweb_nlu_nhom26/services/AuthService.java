package com.example.webtranhtheu_ltweb_nlu_nhom26.services;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.User;
import com.example.webtranhtheu_ltweb_nlu_nhom26.dao.UserDAO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.db.JDBIConnector;


public class AuthService {
    final private UserDAO userDao;
    public AuthService() {
        userDao = JDBIConnector.getInstance().onDemand(UserDAO.class);
    }

    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    public boolean checkUsername(String username) {
        return userDao.getUsername(username) == null;
    }

    public boolean checkPassword(String password) {
        String regex = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#$%^&*])[A-Za-z\\d!@#$%^&*]{8,}$";
        return password.matches(regex);
    }

    public boolean checkEmail(String email) {
        return userDao.getEmail(email) == null;
    }

    public Integer getAccountId(String username) {
        return userDao.getId(username);
    }

    public String normalizeEmail(String email) {
        // Tách phần local-part và domain
        String[] parts = email.split("@");
        String localPart = parts[0];
        String domain = parts[1].toLowerCase(); // Chuyển domain về chữ thường

        // Nếu là Gmail, xử lý alias
        if (domain.equals("gmail.com")) {
            localPart = localPart.split("\\+")[0]; // Loại bỏ phần sau dấu +
            localPart = localPart.replace(".", ""); // Loại bỏ dấu chấm
        }

        return localPart + "@" + domain;
    }

}
