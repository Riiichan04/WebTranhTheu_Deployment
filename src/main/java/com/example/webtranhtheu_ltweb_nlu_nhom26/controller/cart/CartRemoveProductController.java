package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.cart;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.cart.Cart;
import com.example.webtranhtheu_ltweb_nlu_nhom26.util.ControllerUtil;
import com.google.gson.JsonObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "CartRemoveProductController", value = "/remove-product")
public class CartRemoveProductController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String productCode = request.getParameter("productCode");
        Cart cart = (Cart) session.getAttribute("cart");
        JsonObject jsonResult = new JsonObject();
        if(cart!=null){
            cart.removeProduct(productCode);
            session.setAttribute("cart", cart);
            jsonResult.addProperty("currentCartLength", cart.getCartSize());
            ControllerUtil.sendAjaxResultSuccess(response, jsonResult, null);
        }
        response.sendRedirect("/cart");
    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
}