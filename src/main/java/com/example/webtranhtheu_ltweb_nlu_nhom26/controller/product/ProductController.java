package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.product;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Price;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.product.ConcreateProductDetail;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.product.DisplayFullProduct;
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
        try {
            String width = request.getParameter("width");
            String height = request.getParameter("height");
            if (width == null && height == null || width != null && height != null) {
                int id = Integer.parseInt(productId);
                DisplayFullProduct service = new DisplayFullProduct(new ConcreateProductDetail());
                Product product = service.getFullProductInfo(id);
                //Không tìm thấy product với id đã nhập
                if (product == null) response.sendError(HttpServletResponse.SC_NOT_FOUND);
                else {
                    request.setAttribute("product", product);
                    request.getRequestDispatcher("/layout/product.jsp").forward(request, response);
                }
            } else response.sendError(HttpServletResponse.SC_NOT_FOUND);

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
        } else {
            jsonResult.addProperty("result", false);
        }
        response.getWriter().write(jsonResult.toString());
    }
}