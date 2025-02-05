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

@WebServlet(name = "GetReviewDetailController", value = "/get-review-detail")
public class GetReviewDetailController extends HttpServlet {
    public UserService userService = new UserService();
    public ProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String reviewId = request.getParameter("reviewId");
        HttpSession session = request.getSession();
        User account = (User) session.getAttribute("account");
        Review review= userService.getReviewById(Integer.parseInt(reviewId));
        Product product = productService.getProductById(review.getProductId());
        product.setProvider(productService.getProviderByProductId(review.getProductId()));
        review.setProduct(product);
        request.setAttribute("review", review);
        session.setAttribute("account", account);
        request.getRequestDispatcher("/layout/user/review-form/read-review-detail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}