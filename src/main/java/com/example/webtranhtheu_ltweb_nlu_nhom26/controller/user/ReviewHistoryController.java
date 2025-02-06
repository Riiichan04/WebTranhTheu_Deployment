package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.user;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Review;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.user.User;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.ProductService;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ReviewHistoryController", value = "/user/user-feedbacks")
public class ReviewHistoryController extends HttpServlet {
    public UserService userService = new UserService();
    public ProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User account= (User) session.getAttribute("account");
        List<Review> reviews= userService.getReviewByUser(account.getId());
        reviews.forEach(r->{
            Product product = productService.getProductById(r.getProductId());
            r.setProduct(product);
        });
        request.setAttribute("reviews", reviews);
        request.getRequestDispatcher("/layout/user/user-feedbacks.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}