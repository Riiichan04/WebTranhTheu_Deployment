package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.product;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Discount;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Price;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.product.ConcreteProductDetail;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.product.DisplayFullProduct;
import com.google.gson.JsonObject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

@WebServlet(name = "GetProductBasicInfo", value = "/get-product-price")
public class GetProductPrice extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        JsonObject jsonResult = new JsonObject();
        try {
            String widthParam = request.getParameter("width");
            String heightParam = request.getParameter("height");
            String productId = request.getParameter("id");
            String discountValue = request.getParameter("discount");

            int id = Integer.parseInt(productId);
            DisplayFullProduct service = new DisplayFullProduct(new ConcreteProductDetail());
            List<Price> listPrices = service.getListPrices(id);

            if (listPrices == null || listPrices.isEmpty()) {  //Không tìm thấy product với id đã nhập
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
            Discount currentDiscount = null;
            if (discountValue == null || discountValue.isEmpty()) {
                currentDiscount = new DisplayFullProduct(new ConcreteProductDetail()).getDiscount();
                jsonResult.addProperty("discountValue", currentDiscount.getValue());
            }

            Price displayPrice = null;
            if (widthParam.isEmpty() && heightParam.isEmpty()) {    //Nếu cả width và height đều không có
                displayPrice = listPrices.stream().min(Comparator.comparingDouble(Price::getPrice)).orElse(null);
            } else if (widthParam.isEmpty() || heightParam.isEmpty()) {   //Nếu chỉ có 1 trong 2
                jsonResult.addProperty("result", false);
            } else {  //Nếu có đủ cả width và height
                int width = Integer.parseInt(widthParam);
                int height = Integer.parseInt(heightParam);
                displayPrice = listPrices.stream().filter(price -> price.getWidth() == width && price.getHeight() == height).findFirst().orElse(null);
            }

            if (displayPrice == null) { //Không thể tìm thấy giá của sản phẩm do lỗi nào đó ở db
                jsonResult.addProperty("result", false);
            }

            jsonResult.addProperty("width", displayPrice.getWidth());
            jsonResult.addProperty("height", displayPrice.getHeight());
            jsonResult.addProperty("price", displayPrice.getDisplayPriceToString());
            jsonResult.addProperty("available", displayPrice.getAvailable());
            jsonResult.addProperty("discountedPrice", currentDiscount == null ? null : displayPrice.getDiscountedPrice(currentDiscount.getValue()).getDisplayPriceToString());
            jsonResult.addProperty("result", true);
            response.getWriter().write(jsonResult.toString());
        } catch (Exception e) {
            jsonResult.addProperty("result", false);
            response.getWriter().write(jsonResult.toString());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}