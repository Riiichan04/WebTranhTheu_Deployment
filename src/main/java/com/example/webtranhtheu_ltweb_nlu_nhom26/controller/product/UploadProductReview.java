package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.product;
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
                //TODO - Làm phần gửi bình luận:
                //- Kiểm tra điều kiện xem có được bình luận không + có đủ thông tin không
                //- Thực hiện post review vào
                //- Trả về kết quả
            }
            response.getWriter().write(jsonResult.toString());

        }
        catch (Exception e) {
            jsonResult.addProperty("result", false);
            response.getWriter().write(jsonResult.toString());
        }

    }
}