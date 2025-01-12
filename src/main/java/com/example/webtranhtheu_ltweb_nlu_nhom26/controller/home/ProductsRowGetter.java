package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.home;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.ProductService;
import com.example.webtranhtheu_ltweb_nlu_nhom26.util.ControllerUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

//Dùng để lấy 1 hàng 5 sản phẩm
@WebServlet(name = "ProductsRowGetter", value = "/get-product-row")
public class ProductsRowGetter extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        JsonObject jsonResult = new JsonObject();
        try {
            //Lấy offset và số lượng cần lấy
            String ajaxOffset = request.getParameter("offset");
            String ajaxAmount = request.getParameter("amount");
            int offset = (ajaxOffset != null) ? Integer.parseInt(ajaxOffset) : 0;
            int amount = (ajaxAmount != null) ? Integer.parseInt(ajaxAmount): 5;
            //Lấy một hàng sản phẩm
            List<Product> productsRow = ProductService.getOneProductsRow(offset, amount);
            if (productsRow.isEmpty()) ControllerUtil.sendAjaxResultFalse(response, jsonResult, null);
            //TODO: Xử lý nhận biết khi nào không còn để lấy
            // - Cho offset = -1

            JsonArray listProducts = new JsonArray();
            for (Product product : productsRow) {
                //Thêm thông tin hiển thị card product dạng json
                //Lấy product Price để hiển thị
                ControllerUtil.addProductToJson(listProducts, product, product.getMinPrice());
            }
            jsonResult.add("listProducts", listProducts);
            ControllerUtil.sendAjaxResultSuccess(response, jsonResult, null);
        }
        catch (Exception e) {
            ControllerUtil.sendAjaxResultFalse(response, jsonResult, null);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}