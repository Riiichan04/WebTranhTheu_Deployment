package com.example.webtranhtheu_ltweb_nlu_nhom26.services;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.AuthDTO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.User;
import com.example.webtranhtheu_ltweb_nlu_nhom26.dao.UserDAO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.db.JDBIConnector;
import com.example.webtranhtheu_ltweb_nlu_nhom26.util.PasswordEncryption;


public class AuthService {
    final private UserDAO userDao;
    public AuthService() {
        userDao = JDBIConnector.getInstance().onDemand(UserDAO.class);
    }

    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    public boolean checkPassword(String password) {
        String regex = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#$%^&*])[A-Za-z\\d!@#$%^&*]{8,}$";
        return password.matches(regex);
    }

    public Integer getIdByEmail(String email) {
        return userDao.getIdByEmail(email);
    }

    public Integer getAccountId(String username) {
        return userDao.getId(username);
    }

    public Integer getAccountIdByEmailAndUsername(String email, String username) {
        return userDao.getIdByEmailAndUsername(email, username);
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

    public AuthDTO getAuth(String username, String password) {
        String hashedPassword = userDao.getPassword(username);
        if(hashedPassword != null) {
            if(PasswordEncryption.checkPassword(password, hashedPassword)) {
                return userDao.getAuth(username);
            }
        }
        return null;
    }

    public String getEmail(int id) {
        return userDao.getEmail(id);
    }

    public Integer getStatusById(int id) {
        return userDao.getStatusAccount(id);
    }


}
