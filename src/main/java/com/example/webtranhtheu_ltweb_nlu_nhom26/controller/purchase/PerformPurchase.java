package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.purchase;

import com.example.webtranhtheu_ltweb_nlu_nhom26.util.ControllerUtil;
import com.google.gson.JsonObject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "PerformPurchase", value = "/perform-purchase")
public class PerformPurchase extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        JsonObject jsonResult = new JsonObject();
        HttpSession session = request.getSession();
        try {
            //Cho biết là đặt cọc hay thanh toán toàn bộ
            String type = request.getParameter("type");
            //Validate thông tin thanh toán
            if (session.getAttribute("accountId") == null || session.getAttribute("selectedItems") == null) {
                ControllerUtil.sendAjaxResultFalse(response, jsonResult, null);
            }
            else {
                //Gửi các thông tin cần hiển thị trên order
                //Thêm địa chỉ thanh toán vào req
                //Thêm danh sách các cartproduct đã thanh toán vào req
                //Thêm giá tiền cuối cùng vào req

                //Chuẩn bị các thông tin cần thiết để gửi sang VNPay
                //request.getRequestDispatcher("/vnpay-purchase").forward(request, response);
                //Tạm bỏ để test phần hiển thị kết quả thanh toán
                request.getRequestDispatcher("/purchase-result").forward(request, response);
            }

        }
        catch (Exception e) {
            ControllerUtil.sendAjaxResultFalse(response, jsonResult, null);
        }
    }
}