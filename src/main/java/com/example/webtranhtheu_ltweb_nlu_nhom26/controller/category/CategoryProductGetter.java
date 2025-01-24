package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.category;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.CategoryService;
import com.example.webtranhtheu_ltweb_nlu_nhom26.util.ControllerUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

//Mặc định lấy 25 product

/**
 * @deprecated
 * Hiển tại không dùng servlet này nữa. Sẽ bị xóa trước khi merge
 */
@WebServlet(name = "ProductGetter", value = "/category-product-getter")
public class CategoryProductGetter extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        JsonObject jsonResult = new JsonObject();
        try {
            int page = Integer.parseInt(request.getParameter("page"));  //Trang hiện tại
            int amount = Integer.parseInt(request.getParameter("amount"));  //Số lượng cần lấy
            String maxPage = request.getParameter("maxPage");
            String categoryPatternName = request.getParameter("patternName");
            //Không hợp lệ
            if (!CategoryService.isCategoryNameExist(categoryPatternName) || page <= 0 || amount <= 0)  {
                ControllerUtil.sendAjaxResultFalse(response, jsonResult, null);
                return;
            }
            if (maxPage == null || maxPage.isEmpty()) {
//                jsonResult.addProperty("maxPage", CategoryService.calculateCategoryPage(categoryPatternName, amount));
            }

            List<Product> listProductByCategory = CategoryService.getDisplayProductByCategory(categoryPatternName, page, amount);
            //Không tìm thấy sp nào
            if (listProductByCategory.isEmpty()) {
                jsonResult.addProperty("notice", "Không tìm thấy sản phẩm nào!");
                ControllerUtil.sendAjaxResultFalse(response, jsonResult, null);
            }
            else {
                JsonArray listProducts = new JsonArray();
                for (Product product : listProductByCategory) {
                    ControllerUtil.addProductToJson(listProducts, product, product.getMinPrice());
                }
                jsonResult.addProperty("currentPage", page);
                jsonResult.add("listProducts", listProducts);
                ControllerUtil.sendAjaxResultSuccess(response, jsonResult, null);
            }
        }
        catch (Exception e) {
            ControllerUtil.sendAjaxResultFalse(response, jsonResult, null);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}