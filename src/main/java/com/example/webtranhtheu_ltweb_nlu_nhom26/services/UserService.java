package com.example.webtranhtheu_ltweb_nlu_nhom26.services;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.Address;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.user.User;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin.UserDTO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.dao.UserDAO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.db.JDBIConnector;

import java.util.List;

public class UserService {
    UserDAO userDAO;

    public UserService() {
        this.userDAO = JDBIConnector.getInstance().onDemand(UserDAO.class);
    }

    //Để tạm thôi
    public String getUsername(int userId) {
        return userDAO.getUsername(userId);
    }

    public List<UserDTO> listUserDTO() {
        return userDAO.getUsersDTO();
    }

    public boolean addUser(User user) {
        return userDAO.insertUser(user);
    }

    public User getUserById(int userId) {
        User user = userDAO.getUser(userId);
        List<Address> location = userDAO.getLocation(userId);
        user.setLocation(location);
        //user.setWishProducts(userDAO.getWishProducts(userId));
        return user;
    }

    public void updateUser(User user, String[] location, String[] deleteLocation) {
        userDAO.updateUser(user);
        for (int i = 0; i < deleteLocation.length; i++) {
            userDAO.deleteUserAddress(user.getId(), Integer.parseInt(deleteLocation[i]));
        }

        for (int i = 0; i < location.length; i++) {
            userDAO.insertAddress(location[i]);
            userDAO.insertUserAddress(user.getId(), userDAO.getIdByLocation(location[i]));
        }

//        for(int i = 0; i < addWishProduct.length; i++) {
//            userDAO.insertWishProduct(user.getId(), Integer.parseInt(addWishProduct[i]));
//        }
//
//        for(int i = 0; i < deleteWishProduct.length; i++) {
//            userDAO.deleteWishProduct(user.getId(), Integer.parseInt(deleteWishProduct[i]));
//        }

    }

    public boolean updateAvatar(int id, String url) {
        return userDAO.updateAvatar(id, url);
    }

    // cập nhật trạng thái cho user
    public boolean updateStatus(int userId, int status) {
        return userDAO.updateStatus(userId, status);
    }

    //cập nhật password
    public boolean updatePassword(int userId, String password) {
        return userDAO.updatePassword(userId, password);
    }

    public void updateInfoAdmin(User user) {
        userDAO.updateInfoAdmin(user);
    }

    //Lấy thông tin địa chỉ theo id
    public String getLocationById(int accountId, int id) {
        if (id == 0) return "Chưa chọn";
        else {
            return userDAO.getAddressLocationById(accountId, id);
        }
    }

}
