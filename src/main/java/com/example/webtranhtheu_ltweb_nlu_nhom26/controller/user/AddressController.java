package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.user;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.Address;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.User;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddressController", value = "/user/user-addresses")
public class AddressController extends HttpServlet {
    public static UserService userService= UserService.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        User account = (User) session.getAttribute("account");
        if(account == null){
            response.sendRedirect("/login");
        }else{
            List<Address> userAddresses= userService.getLocation(account.getId());
            if(userAddresses == null){
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }else {
                session.setAttribute("userAddresses", userAddresses);
                request.getRequestDispatcher("/layout/user/user-addresses.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}