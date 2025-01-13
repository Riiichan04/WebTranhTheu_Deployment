package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.product;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Price;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.product.ConcreateProductDetail;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.product.DisplayFullProduct;
import com.google.gson.JsonObject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ProductController", value = "/product")
public class ProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String productId = request.getParameter("id");
        String widthParam = request.getParameter("width");
        String heightParam = request.getParameter("height");
        try {
            int id = Integer.parseInt(productId);
            DisplayFullProduct service = new DisplayFullProduct(new ConcreateProductDetail());
            Product product = service.getFullProductInfo(id);
            if (product == null) {  //Không tìm thấy product với id đã nhập
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
            Price displayPrice = null;
            if (widthParam == null && heightParam == null) {    //Nếu cả width và height đều không có
                displayPrice = product.getMinPrice();
            } else if (widthParam == null || heightParam == null) {   //Nếu chỉ có 1 trong 2
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            } else {  //Nếu có đủ cả width và height
                int width = Integer.parseInt(widthParam);
                int height = Integer.parseInt(heightParam);
                displayPrice = product.getSelectedPrice(width, height);
            }
            if (displayPrice == null) { //Không thể tìm thấy giá của sản phẩm do lỗi nào đó ở db
//                response.sendError(418, "Tui là ấm trà mà, sao mấy người muốn bắt tui pha cà phê vậy :<"); //Joke giải trí trước khi thi cuối kì =))
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            } else {
                request.setAttribute("product", product);
                request.setAttribute("displayPrice", displayPrice);
                request.getRequestDispatcher("/layout/product.jsp").forward(request, response);
            }

        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND); //Ném trang 404
        }
    }

    //Khi người dùng gửi comment lên
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        //Kiểm tra session
        HttpSession session = request.getSession();
        JsonObject jsonResult = new JsonObject();
        if (session.getAttribute("user") != null) {
            //Insert review vào db

            //Kết quả thực hiện
            jsonResult.addProperty("result", true);
        } else {
            jsonResult.addProperty("result", false);
        }
        response.getWriter().write(jsonResult.toString());
    }
}