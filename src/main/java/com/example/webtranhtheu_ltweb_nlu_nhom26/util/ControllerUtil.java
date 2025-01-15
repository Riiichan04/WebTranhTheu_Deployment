package com.example.webtranhtheu_ltweb_nlu_nhom26.util;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Price;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface ControllerUtil {
    //Dành cho AJAX khi thực hiện thất bại yêu cầu (Khi không dùng hàm error trong AJAX)
    static void sendAjaxResultFalse(HttpServletResponse response, JsonObject json, String message) {
        try {
            if (message == null || message.isEmpty()) json.addProperty("result", false);
            else json.addProperty("result", message);
            response.getWriter().write(json.toString());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Dành cho AJAX khi thực hiện thành công
    static void sendAjaxResultSuccess(HttpServletResponse response, JsonObject json, String message) {
        try {
            if (message == null || message.isEmpty()) json.addProperty("result", true);
            else json.addProperty("result", message);
            response.getWriter().write(json.toString());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Thêm một sản phẩm vào JSON trong AJAX response
    static void addProductToJson(JsonArray jsonArray, Product product, Price productPrice) {
        if (productPrice == null) return;
        JsonObject jsonProduct = new JsonObject();
        jsonProduct.addProperty("id", product.getId());
        jsonProduct.addProperty("code", product.getCode());
        jsonProduct.addProperty("title", product.getTitle());
        jsonProduct.addProperty("type", product.getType()); //Xem có cần thêm không
        jsonProduct.addProperty("thumbnail", product.getThumbnail());
        jsonProduct.addProperty("size", productPrice.getWidth() + "x" + productPrice.getHeight() + " cm");
        jsonProduct.addProperty("price", productPrice.getDisplayPriceToString());
        jsonArray.add(jsonProduct);
    }
}
