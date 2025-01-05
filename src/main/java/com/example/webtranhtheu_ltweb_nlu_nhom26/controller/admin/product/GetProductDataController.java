package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.admin.product;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.admin.ProductDTO;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GetProductDataController", value = "/admin/product-management/get-product")
public class GetProductDataController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        //chưa xử lý service
        List<ProductDTO> products = new ArrayList<>();
        products.add(new ProductDTO(1, "SP01", "Tranh thêu phố cổ Hội An", "https://www.thegioitranhtheu.com/media/catalog/product/cache/1/small_image/9df78eab33525d08d6e5fb8d27136e95/f/i/file_7_35.jpg"
        , 12, 4.5, 18, 1));

        Gson gson = new Gson();
        response.getWriter().print(gson.toJson(products));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}