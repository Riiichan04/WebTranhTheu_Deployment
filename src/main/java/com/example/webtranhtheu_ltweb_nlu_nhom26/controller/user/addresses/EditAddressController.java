package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.user.addresses;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.Address;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.user.User;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "EditAddressController", value = "/user/user-addresses/update-address")
public class EditAddressController extends HttpServlet {
    public UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        User account = (User) session.getAttribute("account");
        if(account == null){
            response.sendRedirect("/login");
        }
        String addressId= request.getParameter("addressId");
        String fixedAddress = request.getParameter("fixedAddress");
        if(addressId != null && fixedAddress != null){
            for (Address address: account.getLocation()){
                if(address.getId()== Integer.parseInt(addressId)){
                    address.setLocation(fixedAddress);
                    userService.updateAddress(address);
                }
            }
            session.setAttribute("account", account);
        }
    }
}