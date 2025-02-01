package com.example.webtranhtheu_ltweb_nlu_nhom26.services;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.Address;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.user.User;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.user.WishProduct;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin.UserDTO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.dao.UserDAO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.db.JDBIConnector;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import java.util.List;

public class UserService {
    private static UserDAO userDAO;
    private static UserService instance;
    public static UserService getInstance() {
        if(instance == null) {
            Jdbi jdbi= JDBIConnector.getInstance();
            jdbi.installPlugin(new SqlObjectPlugin());
            userDAO = jdbi.onDemand(UserDAO.class);
            instance = new UserService(userDAO);
            return instance;
        }
        return instance;
    }
    public UserService(UserDAO userDAO) {this.userDAO = userDAO;}
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
        user.setWishProducts(userDAO.getWishProducts(userId));
        return user;
    }

    public void updateUser(User user, String[] location, String[] deleteLocation, String[] addWishProduct, String[] deleteWishProduct) {
        userDAO.updateUser(user);
        for (int i = 0; i < deleteLocation.length; i++) {
            userDAO.deleteUserAddress(user.getId(), Integer.parseInt(deleteLocation[i]));
        }

        for(int i = 0; i < location.length; i++) {
            userDAO.insertAddress(location[i]);
            userDAO.insertUserAddress(user.getId(), userDAO.getIdByLocation(location[i]));
        }

        for(int i = 0; i < addWishProduct.length; i++) {
            userDAO.insertWishProduct(user.getId(), Integer.parseInt(addWishProduct[i]));
        }

        for(int i = 0; i < deleteWishProduct.length; i++) {
            userDAO.deleteWishProduct(user.getId(), Integer.parseInt(deleteWishProduct[i]));
        }

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

    // Danh sách sản phẩm yêu thích
    public List<WishProduct> getWishProducts(int userId) {
        return userDAO.getWishProducts(userId);
    }
    public List<Address> getLocation(int userId) {
        return userDAO.getLocation(userId);
    }

    public boolean updateInfo(User user) {
        return userDAO.updateUser(user);
    }
    public boolean updateAddress(Address address) {
        userDAO.updateAddress(address);
        userDAO.updateUserAddress(address.getId());
        return true;
    }

    public boolean insertAddress(String location){
        return userDAO.insertAddress(location);
    }

    public Integer getIdByLocation(String newAddress) {
        return userDAO.getIdByLocation(newAddress);
    }

    public void insertUserAddress(int id, Integer addressId) {
        userDAO.insertUserAddress(id, addressId);
    }
    public void deleteUserAddress(int accountId, int addressId) {
        userDAO.deleteUserAddress(accountId, addressId);
        userDAO.deleteAddress(addressId);
    }
}
