package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.user;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.user.User;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.user.WishProduct;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.ProductService;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.UserService;
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
    public UserService userService= new UserService();
    public ProductService productService= new ProductService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        Object accountId = session.getAttribute("accountId");
        User account = (User) session.getAttribute("account");
        if(accountId == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }else{
            List<WishProduct> wishlist= userService.getWishProducts((Integer)accountId);
            for(WishProduct wishProduct:wishlist){
                wishProduct.getProduct().setListImageUrls(productService.getListImageUrls(wishProduct.getProduct().getId()));
                wishProduct.getProduct().setListPrices(productService.getProductPrices(wishProduct.getProduct().getId()));
            }
            // Xu ly lay thumbnail voi price hay sao a (500)
            account.setWishProducts(wishlist);
            session.setAttribute("account", account);
            request.getRequestDispatcher("/layout/user/user-wishlist.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}