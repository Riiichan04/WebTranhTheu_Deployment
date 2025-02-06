package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.user;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.user.User;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.user.order.Order;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.user.order.OrderProduct;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.OrderService;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderController", value = "/user/user-orders")
public class OrderController extends HttpServlet {
    public ProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        User account = (User) session.getAttribute("account");
        Object accountId = session.getAttribute("accountId");
        if (account == null) {
            response.sendRedirect("/login");
        }else {
            List<Order> orders = OrderService.getListOrderByUser((Integer) accountId);
            orders.forEach(order -> {
                List<OrderProduct> orderProducts = OrderService.getListOrderProductByOrderId(order.getId());
                orderProducts.forEach(orderProduct -> {
                    Product product = productService.getProduct(orderProduct.getId());
                    product.setListImageUrls(productService.getListImageUrls(product.getId()));
                    orderProduct.setThumbnail(product.getThumbnail());
                });
                order.setProducts(orderProducts);
            });
            account.setOrders(orders);
            session.setAttribute("account", account);
            request.getRequestDispatcher("/layout/user/user-orders.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}