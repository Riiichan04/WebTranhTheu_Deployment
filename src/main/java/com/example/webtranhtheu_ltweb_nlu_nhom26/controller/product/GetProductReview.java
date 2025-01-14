package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.product;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Review;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.UserService;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.product.ConcreateProductDetail;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.product.DisplayFullProduct;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

//Dùng để lấy review của sản phẩm
@WebServlet(name = "ProductReviewController", value = "/get-product-review")
public class GetProductReview extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        JsonObject jsonResult = new JsonObject();
        try {
            int productId = Integer.parseInt(request.getParameter("id"));
            int offset = Integer.parseInt(request.getParameter("offset"));
            //Gọi method lấy review
            //Kiểm tra offset
            //Kiểm tra lấy theo id được không
            List<Review> listReview = new DisplayFullProduct(new ConcreateProductDetail()).getListReviews(productId, offset);
            JsonArray jsonArray = new JsonArray();
            for (Review review : listReview) {
                JsonObject jsonReview = new JsonObject();
                jsonReview.addProperty("username", new UserService().getUsername(review.getAccountId())); //Một hàm nào đó sẽ viết trong service sau
                jsonReview.addProperty("rating", review.getRating());
                jsonReview.addProperty("content", review.getContent());
                jsonReview.addProperty("reviewTime", review.getCreatedAt().toString());
                jsonArray.add(jsonReview);
            }

            jsonResult.addProperty("result", true);
            jsonResult.add("reviewData", jsonArray);
            response.getWriter().write(jsonResult.toString());
        }
        catch (Exception e) {
            jsonResult.addProperty("result", false);
            response.getWriter().write(jsonResult.toString());
        }
    }
}