package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.checkout;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.cart.Cart;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.cart.CartProduct;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Discount;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.DiscountService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CheckoutController", value = "/user/purchase")
public class CheckoutController extends HttpServlet {
    DiscountService discountService = new DiscountService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String[] selectedProductCodes= request.getParameterValues("selectedProductCode[]");
        String discountId= request.getParameter("discountId");
        Discount discount= discountService.getDiscount(Integer.parseInt(discountId));
        Cart cart = (Cart) session.getAttribute("cart");
        if(discount==null) {
            discount = cart.getMaxDiscount();
        }
        if(cart.getCartSize()==0){
            response.sendRedirect("/cart");
        }else{
            Map<String,CartProduct> cartProducts= cart.getProducts();
            Map<String,CartProduct> selectedProducts= new HashMap<>();
            if(selectedProductCodes!=null){
                for(String productCode:selectedProductCodes){
                    if(cartProducts.containsKey(productCode)){
                        CartProduct cartProduct = cartProducts.get(productCode);
                        selectedProducts.put(productCode,cartProduct);
                        break;
                    }
                }
            }
            session.setAttribute("selectedProducts",selectedProducts);
            session.setAttribute("discount",discount);
            request.getRequestDispatcher("/layout/user/purchase.jsp").forward(request, response);
        }
    }
}