package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.purchase;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.cart.Cart;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.cart.CartProduct;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.OrderService;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.PurchaseOperator;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.UserService;
import com.example.webtranhtheu_ltweb_nlu_nhom26.util.ControllerUtil;
import com.google.gson.JsonObject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "PerformPurchase", value = "/perform-purchase")
public class PerformPurchase extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        JsonObject jsonResult = new JsonObject();
        HttpSession session = request.getSession();
        try {
            System.out.println("START START");
            //Cho biết là đặt cọc hay thanh toán toàn bộ
//            String type = request.getParameter("type");
            //Validate thông tin thanh toán
            System.out.println(session.getAttribute("accountId"));
            System.out.println(session.getAttribute("selectedProducts"));
            if (session.getAttribute("accountId") == null || session.getAttribute("selectedProducts") == null) {
                System.out.println("CAUSED BY NULL");
                ControllerUtil.sendAjaxResultFalse(response, jsonResult, null);
            }
            else {
                //Chuẩn bị các thông tin cần thiết để gửi sang VNPay
                //request.getRequestDispatcher("/vnpay-purchase").forward(request, response);

                //Tạm bỏ để test phần hiển thị kết quả thanh toán
                Cart cart = (Cart) session.getAttribute("cart");
                Map<String, CartProduct> listSelectedProductCode = new HashMap<>();
                if (session.getAttribute("selectedProducts") != null) {
                    Map<?, ?> tempMap = (Map<?, ?>) session.getAttribute("selectedProducts");
                    if (tempMap.keySet().stream().allMatch(k -> k instanceof String) &&
                            tempMap.values().stream().allMatch(v -> v instanceof CartProduct)) {
                        listSelectedProductCode = (Map<String, CartProduct>) tempMap;
                    }
                }

                int accountId = (int) session.getAttribute("accountId");
                int addressId = Integer.parseInt(request.getParameter("addressId"));
                System.out.println("PURCHASE");
                System.out.println(addressId);
                if (addressId == 0) {
                    ControllerUtil.sendAjaxResultFalse(response, jsonResult, null);
                    return;
                }
                String location = new UserService().getLocationById(accountId, addressId);

                //Chỉnh phần method
                System.out.println(listSelectedProductCode);
                boolean result = PurchaseOperator.performPurchase(accountId, location, OrderService.PAYMENT_BY_BANK, cart, listSelectedProductCode);
                if (result) {
                    ControllerUtil.sendAjaxResultSuccess(response, jsonResult, null);
                    System.out.println(cart.getProducts());
                    System.out.println("END OF PURCHASE");
                }
                else ControllerUtil.sendAjaxResultFalse(response, jsonResult, null);
            }

        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            ControllerUtil.sendAjaxResultFalse(response, jsonResult, null);
        }
    }
}