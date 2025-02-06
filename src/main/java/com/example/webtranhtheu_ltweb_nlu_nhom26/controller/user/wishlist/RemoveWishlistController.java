package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.user.wishlist;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
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

@WebServlet(name = "RemoveWishlistController", value = "/remove-wishlist")
public class RemoveWishlistController extends HttpServlet {
    public UserService userService = new UserService();
    ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        Object accountId = session.getAttribute("accountId");
        List<WishProduct> wishlist = (List<WishProduct>) session.getAttribute("wishlist");
        System.out.println(wishlist);
        String productId = request.getParameter("productId");
        System.out.println(productId);
        WishProduct wishProduct = userService.getWishProductByUser((Integer) accountId, Integer.parseInt(productId));
        System.out.println(userService.getWishProductByUser((Integer) accountId, Integer.parseInt(productId)));
        wishlist.remove(wishProduct);
        System.out.println(userService.deleteWishProduct((Integer) accountId, Integer.parseInt(productId)));
        userService.deleteWishProduct((Integer) accountId, Integer.parseInt(productId));
        session.setAttribute("wishlist", wishlist);
    }
}