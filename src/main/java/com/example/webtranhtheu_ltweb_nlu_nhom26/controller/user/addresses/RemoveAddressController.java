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

@WebServlet(name = "RemoveAddressController", value = "/user/user-addresses/remove-address")
public class RemoveAddressController extends HttpServlet {
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
        response.setContentType("application/json");
        String addressId= request.getParameter("addressId");
        if(addressId!=null){
            userService.deleteUserAddress(account.getId(),Integer.parseInt(addressId));
            session.setAttribute("account",account);
            response.getWriter().write("{\"success\": true}");
        }else{
            response.getWriter().write("{\"success\": false}");
        }
    }
}