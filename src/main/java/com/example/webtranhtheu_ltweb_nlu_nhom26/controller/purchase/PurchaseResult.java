package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.purchase;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.PurchaseOperator;
import com.example.webtranhtheu_ltweb_nlu_nhom26.util.ControllerUtil;
import com.google.gson.JsonObject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PurchaseResult", value = "/PurchaseResult")
public class PurchaseResult extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Kiểm tra có phải request này đến từ /perform-purchase không
        String reqPath = request.getServletPath();
        JsonObject jsonResult = new JsonObject();
        if (reqPath.equals("/perform-purchase")) {
            try {
                boolean result = PurchaseOperator.performPurchase();
                ControllerUtil.sendAjaxResultSuccess(response, jsonResult, null);
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