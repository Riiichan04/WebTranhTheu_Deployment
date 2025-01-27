package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.user;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.user.User;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "UserController", value = "/user")
public class UserController extends HttpServlet {
    public static UserService userService = UserService.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding( "UTF-8");
        HttpSession session = request.getSession();
        try{
            Object accountId = session.getAttribute("accountId");
            Integer id= (Integer) accountId;
            if(id == null){
                request.getRequestDispatcher("/login").forward(request, response);
            }
            else{
                User account = userService.getUserById(id);
                if(account== null){
                    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                }else{
                    session.setAttribute("account", account);
                    request.getRequestDispatcher("layout/user/user.jsp").forward(request, response);
                }
            }

        }catch (NumberFormatException e){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}