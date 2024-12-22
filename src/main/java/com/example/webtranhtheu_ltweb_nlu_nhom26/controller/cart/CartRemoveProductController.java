package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.cart;

import com.example.webtranhtheu_ltweb_nlu_nhom26.dao.cart.Cart;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "CartRemoveProductController", value = "/session/remove-product")
public class CartRemoveProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int productId = Integer.parseInt(request.getParameter("productId"));
        Cart cart = (Cart) session.getAttribute("Cart");
        if(cart == null) {
            cart = new Cart();
        }
        cart.remove(productId);
        // removeAttribute Cart?????
        session.setAttribute("Cart", cart);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}