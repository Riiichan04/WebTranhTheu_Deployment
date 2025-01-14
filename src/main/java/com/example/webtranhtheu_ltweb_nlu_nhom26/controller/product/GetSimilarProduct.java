package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.product;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.product.ConcreateProductDetail;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.product.DisplayFullProduct;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetSimilarProduct", value = "/similar-product")
public class GetSimilarProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        JsonObject jsonResult = new JsonObject();
        try {
            int productId = Integer.parseInt(request.getParameter("productId"));
            int categoryId = Integer.parseInt(request.getParameter("categoryId"));
            List<Product> listResult = new DisplayFullProduct(new ConcreateProductDetail()).getSimilarProduct(productId, categoryId);
            //Nếu rỗng trả vè ajax false
            JsonArray jsonArray = new JsonArray();
            for (Product product : listResult) {
                //Đoạn này dùng code ở homepage
                JsonObject obj = new JsonObject();
                obj.addProperty("productId", product.getId());
                obj.addProperty("thumbnail", product.getThumbnail());
                obj.addProperty("price", product.getMinPrice().getDisplayPriceToString());
                jsonArray.add(obj);
            }
            jsonResult.add("listProducts", jsonArray);
            //Trả về ajax true
        }
        catch (Exception e) {

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}