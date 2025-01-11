package com.example.webtranhtheu_ltweb_nlu_nhom26.util;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface ControllerUtil {
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

    static void addProductToJson(JsonArray jsonArray, Product product) {

    }
}
