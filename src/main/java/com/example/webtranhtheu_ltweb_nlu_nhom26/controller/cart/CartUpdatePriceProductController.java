package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.cart;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.cart.Cart;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Price;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "CartUpdatePriceProductController", value = "/update-price")
public class CartUpdatePriceProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productKey=request.getParameter("productKey");
        String widthParam=request.getParameter("width");
        String heightParam=request.getParameter("height");
        HttpSession session=request.getSession();
        Cart cart=(Cart) session.getAttribute("cart");
        try{
            int width=Integer.parseInt(widthParam);
            int height=Integer.parseInt(heightParam);
            if(cart!=null){
                cart.updateProductByPrice(productKey,width,height);
                session.setAttribute("cart",cart);
            }
            response.sendRedirect("/cart");
        }catch(NumberFormatException e){

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}