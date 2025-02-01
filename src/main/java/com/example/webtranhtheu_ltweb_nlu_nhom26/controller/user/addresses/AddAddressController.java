package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.user.addresses;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.user.User;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "AddAddressController", value = "/user/user-addresses/add-address")
public class AddAddressController extends HttpServlet {
    public UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        User account = (User) session.getAttribute("account");
        String newAddress = request.getParameter("newAddress");
        response.setContentType("application/json");
        if(newAddress == null || newAddress.isEmpty()){
            response.getWriter().write("{\"success\": false}");
        }else{
            userService.insertAddress(newAddress);
            Integer addressId= userService.getIdByLocation(newAddress);
            userService.insertUserAddress(account.getId(),addressId);
            session.setAttribute("account", account);
            response.getWriter().write("{\"success\": true}");
        }
    }
}