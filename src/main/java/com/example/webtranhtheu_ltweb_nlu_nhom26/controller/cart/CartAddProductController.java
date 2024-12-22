package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.cart;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.dao.ProductDAO;
import com.example.webtranhtheu_ltweb_nlu_nhom26.dao.cart.Cart;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "CartAddProductController", value = "/session/add-product")
public class CartAddProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int productId = Integer.parseInt(request.getParameter("productId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        Cart cart = (Cart) session.getAttribute("Cart");
        if(cart == null) {
            cart = new Cart();
        }
        if(cart.getProduct(productId) != null) {
            cart.update(productId, quantity);
        }
        else{
            Product product = ProductDAO.getProductById(productId);
            if(product != null) {cart.add(product);}
        }
        session.setAttribute("Cart", cart);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}