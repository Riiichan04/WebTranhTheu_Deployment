package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.product;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Review;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.ProductService;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.UserService;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.product.ConcreteProductDetail;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.product.DisplayFullProduct;
import com.example.webtranhtheu_ltweb_nlu_nhom26.util.ControllerUtil;
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
            int amount = Integer.parseInt(request.getParameter("amount"));
            String limit = request.getParameter("limit");
            int limitValue = -1;
            //Gọi method lấy review
            //Kiểm tra offset
            //Kiểm tra lấy theo id được không
            List<Review> listReview = new DisplayFullProduct(new ConcreteProductDetail()).getListReviews(productId, offset, amount);
            if (limit == null || limit.isEmpty()) {
                limitValue = ProductService.countReviews(productId);
                jsonResult.addProperty("limit", limitValue);
            }
            else limitValue = Integer.parseInt(limit);
            if (offset > limitValue) {
                jsonResult.addProperty("currentOffset", -1);
                ControllerUtil.sendAjaxResultFalse(response, jsonResult, null);
            }
            else {
                //Thêm review vào json
                JsonArray jsonArray = new JsonArray();
                for (Review review : listReview) {
                    JsonObject jsonReview = new JsonObject();
                    jsonReview.addProperty("username", new UserService().getUsername(review.getAccountId())); //Một hàm nào đó sẽ viết trong service sau
                    jsonReview.addProperty("rating", review.getRating());
                    jsonReview.addProperty("content", review.getContent());
                    jsonReview.addProperty("reviewTime", review.getCreatedAt().toString());
                    jsonArray.add(jsonReview);
                }
                jsonResult.addProperty("currentOffset", offset + listReview.size());
                jsonResult.add("reviewData", jsonArray);
                ControllerUtil.sendAjaxResultSuccess(response, jsonResult, null);
            }

        }
        catch (Exception e) {
            jsonResult.addProperty("currentOffset", -1);
            ControllerUtil.sendAjaxResultFalse(response, jsonResult, null);

        }
    }
}