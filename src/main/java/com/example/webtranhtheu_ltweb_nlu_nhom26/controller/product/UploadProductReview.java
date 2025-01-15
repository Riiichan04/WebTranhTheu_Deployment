package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Review;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.product.ConcreateProductDetail;
import com.example.webtranhtheu_ltweb_nlu_nhom26.util.ControllerUtil;
import com.google.gson.JsonObject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UploadProductReview", value = "/upload-review")
public class UploadProductReview extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        JsonObject jsonResult = new JsonObject();
        try {
            HttpSession session = request.getSession();
            int userSessionId = (int) session.getAttribute("userId");
            int validateUserId = Integer.parseInt(request.getParameter("account"));
            if (validateUserId != userSessionId) {
                jsonResult.addProperty("result", false);
            }
            else {
                int productId = Integer.parseInt(request.getParameter("productId"));
                int rating = Integer.parseInt(request.getParameter("rating"));
                String content = request.getParameter("content");

                if (!new ConcreateProductDetail().isUserCanReview(validateUserId, productId)) {
                    ControllerUtil.sendAjaxResultFalse(response, jsonResult, null);
                }
                else {
                    Review newReview = new Review(productId, validateUserId, rating, content);
                    boolean insertResult = new ConcreateProductDetail().uploadReview(newReview);
                    jsonResult.addProperty("result", insertResult);
                    response.getWriter().write(jsonResult.toString());
                }
            }

        }
        catch (Exception e) {
            ControllerUtil.sendAjaxResultFalse(response, jsonResult, null);
        }

    }
}