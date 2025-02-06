package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.user.viewed_history;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.user.history.ViewedHistory;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "RemoveViewedProductController", value = "/user/history/removal-history")
public class RemoveViewedProductController extends HttpServlet {
    private ProductService productService= new ProductService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("id");
        Integer productId = Integer.parseInt(id);
        HttpSession session = request.getSession();
        Product product = productService.getProduct(productId);
        product.setListPrices(productService.getProductPrices(product.getId()));
        product.setListImageUrls(productService.getListImageUrls(product.getId()));
        ViewedHistory viewedHistory = (ViewedHistory) session.getAttribute("viewedHistory");
        viewedHistory.removeProduct(product);
        session.setAttribute("viewedHistory", viewedHistory);
    }
}