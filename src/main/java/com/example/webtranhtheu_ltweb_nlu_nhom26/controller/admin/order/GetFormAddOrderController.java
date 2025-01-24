package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.admin.order;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.User;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Discount;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.DiscountService;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.ProductService;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.UserService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetFormAddOrderController", value = "/admin/order-management/add-order-form")
public class GetFormAddOrderController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        List<User> listUsers = new UserService().getAllUserEmailValid();
        request.setAttribute("listUsers", listUsers);
        List<Product> listProducts = new ProductService().getAllListProductsCodeAndTitle();
        request.setAttribute("listProducts", listProducts);
        List<Discount> discountValid = new DiscountService().getDiscountValid();
        request.setAttribute("discountValid", discountValid);
        request.getRequestDispatcher("/layout/admin/order-form/add-order-form.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}