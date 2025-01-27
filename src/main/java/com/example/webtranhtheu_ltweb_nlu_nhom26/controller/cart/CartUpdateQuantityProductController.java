package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.cart;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.cart.Cart;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "CartUpdateProductController", value = "/update-product")
public class CartUpdateQuantityProductController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO
        String productCode=request.getParameter("productCode");
        int quantity=Integer.parseInt(request.getParameter("quantity"));
        HttpSession session=request.getSession();
        Cart cart=(Cart) session.getAttribute("cart");
            if(cart!=null){
                boolean success=cart.updateProductByQuantity(productCode,quantity);
                if(success) {
                    session.setAttribute("cart", cart);
                    System.out.println(cart);
                    return;
                }
            }
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//            response.sendRedirect("/cart");
    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
}