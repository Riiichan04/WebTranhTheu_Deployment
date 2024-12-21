package com.example.webtranhtheu_ltweb_nlu_nhom26.controller;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.ProductPrice;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ProductController", value = "/product")
public class ProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String productId = request.getParameter("id");
        String widthParam = request.getParameter("width");
        String heightParam = request.getParameter("height");
        try {
            ProductPrice productPrice;
            if (widthParam == null && heightParam == null) { //Nếu thiếu cả 2 param thì lấy giá nhỏ nhất
//                productPrice = ProductService.getMinProductPrice(id);
            } else if (widthParam == null || heightParam == null) { //Nhập thiếu width hoặc height
                response.sendError(HttpServletResponse.SC_NOT_FOUND); //Ném trang 404
            }
            else { //Test
                int width = Integer.parseInt(widthParam);
                int height = Integer.parseInt(heightParam);
            }
            int triggerErrorPage = Integer.parseInt(productId); //Trigger error khi cần
//            Chưa có db để chạy
//            Product product = ProductService.getProduct(Integer.parseInt(productId));
//            productPrice = ProductService.getProductPrice(id, width, height);
//            request.setAttribute("product", product);
//            request.setAttribute("displayPrice", productPrice);
            request.getRequestDispatcher("/layout/product.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND); //Ném trang 404
        }
    }

    //Khi người dùng gửi comment lên
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        //Kiểm tra session
        HttpSession session = request.getSession();
        JsonObject jsonResult = new JsonObject();
        if (session.getAttribute("user") != null) {
            //Insert review vào db

            //Kết quả thực hiện
            jsonResult.addProperty("result", true);
        }
        else {
            jsonResult.addProperty("result", false);
        }
        response.getWriter().write(jsonResult.toString());
    }
}