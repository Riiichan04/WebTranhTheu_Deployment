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
import java.util.Arrays;
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
            String limit = request.getParameter("limit");

            int limitValue = -1;
            //Nếu có limit trên request thì lấy xuống
            if (limit == null) {
                limitValue = ProductService.countProduct();
                jsonResult.addProperty("limit", limitValue);
            }
            else limitValue = Integer.parseInt(limit);

            int offset = (ajaxOffset != null) ? Integer.parseInt(ajaxOffset) : 1;
            int amount = (ajaxAmount != null) ? Integer.parseInt(ajaxAmount) : 5;

            if (offset > limitValue) {
                ControllerUtil.sendAjaxResultFalse(response, jsonResult, null);
            } else {
                //Lấy một hàng sản phẩm
                List<Product> productsRow = ProductService.getOneProductsRow(offset, amount);
                if (productsRow.isEmpty()) ControllerUtil.sendAjaxResultFalse(response, jsonResult, null);
                JsonArray listProducts = new JsonArray();
                for (Product product : productsRow) {
                    //Thêm thông tin hiển thị card product dạng json
                    ControllerUtil.addProductToJson(listProducts, product, product.getMinPrice());
                }
                jsonResult.addProperty("currentOffset", productsRow.getLast().getId() + 1);
                jsonResult.add("listProducts", listProducts);

                ControllerUtil.sendAjaxResultSuccess(response, jsonResult, null);
            }
        } catch (Exception e) {
            jsonResult.addProperty("currentOffset", -1);
            ControllerUtil.sendAjaxResultFalse(response, jsonResult, null);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}