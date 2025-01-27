package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.user;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.user.User;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.user.WishProduct;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "WishListController", value = "/user/user-wishlist")
public class WishListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        User account = (User) session.getAttribute("account");
        if(account == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }else{
            List<WishProduct> wishlist = account.getWishProducts();
            session.setAttribute("wishlist", wishlist);
            request.getRequestDispatcher("/layout/user/user-wishlist.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}