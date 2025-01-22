package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.purchase;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.User;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.cart.Cart;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.cart.CartProduct;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.CategoryService;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "PurchaseController", value = "/purchase")
public class PurchaseController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession(); //Kiểm tra session
        try {
            if (session.getAttribute("accountId") == null) {
                response.sendRedirect("/login"); //Cần phải đăng nhập
            } else {
                int userId = Integer.parseInt((String) session.getAttribute("accountId"));
                if (session.getAttribute("listCategory") == null) {
                    session.setAttribute("listCategory", CategoryService.getNameAndPatternCategory());
                }
                //Xử lý thông tin
                String[] listProductCodes = request.getParameterValues("listProductCode");
                Cart sessionCart = (Cart) session.getAttribute("cart");
                User userInfo = new UserService().getUserById(userId);
                List<CartProduct> listPurchased = new ArrayList<>();
                for (String code : listProductCodes) {
                    listPurchased.add(sessionCart.getProducts().get(code));
                }
                request.setAttribute("listPurchased", listPurchased);
                request.setAttribute("userInfo", userInfo);
                request.getRequestDispatcher("layout/purchase.jsp").forward(request, response);
            }
        }
        catch (Exception e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND); //Ném trang 404
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}