package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.checkout;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.cart.Cart;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.cart.CartProduct;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Discount;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.DiscountService;
import com.example.webtranhtheu_ltweb_nlu_nhom26.util.ControllerUtil;
import com.google.gson.JsonObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CheckoutController", value = "/prepare-purchase")
public class CheckoutController extends HttpServlet {
    DiscountService discountService = new DiscountService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
//        try {
//
//        }
//        catch (Exception e) {
//
//        }
        String requestProductCode = request.getParameter("selectedProductCode");
        System.out.println(requestProductCode);
        String[] selectedProductCodes = new String[0];
        if (requestProductCode != null) {
            selectedProductCodes = request.getParameter("selectedProductCode").split(",");
        }
        String discountId = request.getParameter("discountId");

        Discount discount = new Discount();
        if (Integer.parseInt(discountId) != 0) {
            discountService.getDiscount(Integer.parseInt(discountId));
        }

        Cart cart = (Cart) session.getAttribute("cart");
        JsonObject jsonResult = new JsonObject();

        if (selectedProductCodes != null) {
            if (discount == null) {
                discount = cart.getMaxDiscount();
            }
            if (cart.getCartSize() == 0) {
                response.sendRedirect("/cart");
            } else {
                Map<String, CartProduct> cartProducts = cart.getProducts();
                Map<String, CartProduct> selectedProducts = new HashMap<>();
                for (String productCode : selectedProductCodes) {
                    if (cartProducts.containsKey(productCode)) {
                        CartProduct cartProduct = cartProducts.get(productCode);
                        selectedProducts.put(productCode, cartProduct);
                    }
                }
                session.setAttribute("selectedProducts", selectedProducts);
                session.setAttribute("discount", discount);
                ControllerUtil.sendAjaxResultSuccess(response, jsonResult, null);
            }
        } else {
            ControllerUtil.sendAjaxResultFalse(response, jsonResult, null);
        }
    }
}