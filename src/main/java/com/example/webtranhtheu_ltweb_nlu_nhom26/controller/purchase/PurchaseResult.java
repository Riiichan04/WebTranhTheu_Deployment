package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.purchase;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.cart.Cart;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.cart.CartProduct;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.PurchaseOperator;
import com.example.webtranhtheu_ltweb_nlu_nhom26.util.ControllerUtil;
import com.google.gson.JsonObject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "PurchaseResult", value = "/PurchaseResult")
public class PurchaseResult extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Kiểm tra có phải request này đến từ /perform-purchase không
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String reqPath = request.getServletPath();
        JsonObject jsonResult = new JsonObject();

        if (reqPath.equals("/perform-purchase")) {
            try {
                Cart cart = (Cart) session.getAttribute("cart");
                Map<String, CartProduct> listSelectedProductCode = new HashMap<>();
                if (session.getAttribute("selectedProducts") != null) {
                    Map<?, ?> tempMap = (Map<?, ?>) session.getAttribute("selectedProducts");
                    if (tempMap.keySet().stream().allMatch(k -> k instanceof String) &&
                            tempMap.values().stream().allMatch(v -> v instanceof CartProduct)) {
                        listSelectedProductCode = (Map<String, CartProduct>) tempMap;
                    }
                }

                boolean result = PurchaseOperator.performPurchase(cart, listSelectedProductCode);
                if (result) ControllerUtil.sendAjaxResultSuccess(response, jsonResult, null);
                else ControllerUtil.sendAjaxResultFalse(response, jsonResult, null);
            }
            catch (Exception e) {
                ControllerUtil.sendAjaxResultFalse(response, jsonResult, null);
            }
        }
        else {
            ControllerUtil.sendAjaxResultFalse(response, jsonResult, null);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}