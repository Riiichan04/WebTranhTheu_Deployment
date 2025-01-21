package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.cart;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.cart.Cart;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.CategoryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "CartSessionController", value = "/cart")
public class CartSessionController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        Object accountIdObject = session.getAttribute("accountId");
        if (accountIdObject == null) {
            response.sendRedirect("/");
        }
        else {
            if(cart == null) {
                cart= Cart.getInstance();
            }
            if (session.getAttribute("listCategory") == null) {
                session.setAttribute("listCategory", CategoryService.getNameAndPatternCategory());
            }
            session.setAttribute("cart", cart);

            request.getRequestDispatcher("/views/web/cart.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}