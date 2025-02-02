package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.cart;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Price;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.cart.Cart;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.ProductService;
import com.example.webtranhtheu_ltweb_nlu_nhom26.util.ControllerUtil;
import com.google.gson.JsonObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "CartAddProductController", value = "/add-product")
public class CartAddProductController extends HttpServlet {
    ProductService productService;

    public CartAddProductController() {
        productService =new ProductService();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String productId = request.getParameter("id");
        String widthParam = request.getParameter("width");
        String heightParam = request.getParameter("height");
        Object accountIdObject = session.getAttribute("accountId");
        JsonObject jsonResult = new JsonObject();

        if (accountIdObject == null) {
            // Xử lý khúc này
            response.sendRedirect("/");
        } else {
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null) {
                cart = Cart.getInstance();
            }
            try {
                int id = Integer.parseInt(productId);
                Product product = productService.getProduct(id);
                product.setListPrices(productService.getProductPrices(product.getId()));
                product.setListImageUrls(productService.getListImageUrls(product.getId()));
                if (product == null) {
//                    response.sendError(HttpServletResponse.SC_NOT_FOUND);
                }
                Price selectedPrice = null;
                if (widthParam == null && heightParam == null) {
                    selectedPrice = product.getMinPrice();
                } else if (widthParam == null || heightParam == null) {
//                    response.sendError(HttpServletResponse.SC_NOT_FOUND);
                } else {
                    int width = Integer.parseInt(widthParam);
                    int height = Integer.parseInt(heightParam);
                    selectedPrice = product.getSelectedPrice(width, height);
                }
                //
                if (selectedPrice == null) {
//                    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//                    response.getWriter().println("Vui lòng chọn kích thước!");
//                    response.getWriter().flush();
                    // Xử lý
                } else {
                    cart.addProduct(product, selectedPrice, quantity);
                    session.setAttribute("cart", cart);
                    jsonResult.addProperty("currentCartLength", cart.getCartSize());
                    ControllerUtil.sendAjaxResultSuccess(response, jsonResult, null);
                }

            } catch (NumberFormatException e) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        }
    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request, response);
//    }
}