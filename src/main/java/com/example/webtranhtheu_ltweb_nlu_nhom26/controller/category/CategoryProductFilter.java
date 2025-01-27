package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.category;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.CategoryService;
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

@WebServlet(name = "CategoryProductFilter", value = "/category-filter")
public class CategoryProductFilter extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        JsonObject jsonResult = new JsonObject();
        try {
            String requestPatternName = request.getParameter("patternName");
            String requestListTopicId = request.getParameter("listTopic");
            String requestRating = request.getParameter("rating");
            String requestFromPrice = request.getParameter("fromPrice");
            String requestToPrice = request.getParameter("toPrice");
            String requestAmount = request.getParameter("amount");
            String requestPage = request.getParameter("page");
            String requestProviderName = request.getParameter("providerName");
            String requestProductName = request.getParameter("productName");

            //Cần xem lại và tối ưu code này
            String productName = requestProductName == null || requestProductName.isEmpty() ? null : "%" + requestProductName + "%";
            String patternName = requestPatternName.isEmpty() ? null : requestPatternName;
            String providerName = requestProviderName.isEmpty() ? null : requestProviderName;
            List<Integer> listTopicId = requestListTopicId == null || requestListTopicId.isEmpty() ? null : Arrays.stream(requestListTopicId.split(",")).map(Integer::parseInt).toList();
            int rating = requestRating == null || requestRating.isEmpty() ? 0 : Integer.parseInt(requestRating);
            double fromPrice = requestFromPrice == null || requestFromPrice.isEmpty() ? 0 : Double.parseDouble(requestFromPrice);
            double toPrice = requestToPrice == null || requestToPrice.isEmpty() ? 0 : Double.parseDouble(requestToPrice);
            int amount = Integer.parseInt(requestAmount);
            int page = Integer.parseInt(requestPage);

            if (page <= 0 || amount <= 0 || fromPrice > toPrice || rating < 0 || rating > 5) {
                ControllerUtil.sendAjaxResultFalse(response, jsonResult, null);
                return;
            }

            List<Product> listProducts = ProductService.filterProduct(patternName, listTopicId, rating, fromPrice, toPrice, providerName, productName, page, amount);
            if (listProducts.isEmpty()) {
                jsonResult.addProperty("notice", "Không tìm thấy sản phẩm nào!");
                ControllerUtil.sendAjaxResultFalse(response, jsonResult, null);
            }
            else {
                JsonArray listResult = new JsonArray();
                for (Product product : listProducts) {
                    ControllerUtil.addProductToJson(listResult, product, product.getMinPrice());
                }
                jsonResult.addProperty("maxPage", CategoryService.calculateCategoryPage(patternName, listTopicId, rating, fromPrice, toPrice, providerName, productName, amount));
                jsonResult.addProperty("currentPage", page);
                jsonResult.add("listProducts", listResult);
                ControllerUtil.sendAjaxResultSuccess(response, jsonResult, null);
            }

        } catch (Exception e) {
            jsonResult.addProperty("notice", "Không tìm thấy sản phẩm nào!");
            ControllerUtil.sendAjaxResultFalse(response, jsonResult, null);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}