package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.cart;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Price;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.cart.Cart;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "CartAddProductController", value = "/session/add-product")
public class CartAddProductController extends HttpServlet {
    ProductService productService;

    public CartAddProductController() {
        productService =ProductService.getInstance();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String productId = request.getParameter("productId");
        String widthParam= request.getParameter("width");
        String heightParam= request.getParameter("height");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        Cart cart = (Cart) session.getAttribute("Cart");
        if(cart == null) {
            cart = Cart.getInstance();
        }
       try{
           int id = Integer.parseInt(productId);
           Product product = productService.getProduct(id);
           if(product == null) {
               response.sendError(HttpServletResponse.SC_NOT_FOUND);
           }
           Price selectedPrice = null;
           if(widthParam==null && heightParam==null) {
               selectedPrice= product.getMinPrice();
           }else if(widthParam== null||heightParam==null) {
               response.sendError(HttpServletResponse.SC_NOT_FOUND);
           }else{
               int width = Integer.parseInt(widthParam);
               int height = Integer.parseInt(heightParam);
               selectedPrice= product.getSelectedPrice(width, height);
           }
           //
           if(selectedPrice == null) {
               request.setAttribute("error","Vui lòng chọn kích thước!");
               request.getRequestDispatcher("/layout/product.jsp").forward(request,response);
           }else{
               cart.addProduct(Integer.parseInt(productId),selectedPrice,quantity);
               session.setAttribute("Cart",cart);
               request.getRequestDispatcher("/layout/product.jsp").forward(request,response);
           }

       }catch (NumberFormatException e){
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
       }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}