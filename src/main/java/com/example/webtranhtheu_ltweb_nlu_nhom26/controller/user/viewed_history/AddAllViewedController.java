package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.user.viewed_history;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.cart.Cart;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.user.history.ViewedHistory;
import com.google.gson.JsonObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "AddAllViewedController", value = "/user/history/add-all-to-cart")
public class AddAllViewedController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        Object accountIdObject = session.getAttribute("accountId");
        JsonObject jsonResult = new JsonObject();
        ViewedHistory viewedHistory= (ViewedHistory) session.getAttribute("viewedHistory");
        if (accountIdObject == null) {
            // Xử lý khúc này
            response.sendRedirect("/");
        } else {
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null) {
                cart = Cart.getInstance();
            }
            for(Product product: viewedHistory.getViewedProducts()){
                cart.addProduct(product,product.getMinPrice(),1);
            }
            viewedHistory.getViewedProducts().clear();
            session.setAttribute("cart", cart);
            session.setAttribute("viewedHistory", viewedHistory);
        }
    }
}