package com.example.webtranhtheu_ltweb_nlu_nhom26.controller.category;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.ProductService;
import com.example.webtranhtheu_ltweb_nlu_nhom26.util.ControllerUtil;
import com.google.gson.JsonObject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "CategoryProductFilter", value = "/category-filter")
public class CategoryProductFilter extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        JsonObject jsonResult = new JsonObject();
        try {
            String categoryName = request.getParameter("categoryName");
            String[] listTopic = request.getParameterValues("listTopic");
            List<Integer> listTopicId = Arrays.stream(listTopic).map(Integer::parseInt).toList();
            int rating = Integer.parseInt(request.getParameter("rating"));
            double fromPrice = Double.parseDouble(request.getParameter("fromPrice"));
            double toPrice = Double.parseDouble(request.getParameter("toPrice"));
            int offset = Integer.parseInt(request.getParameter("offset"));
            int limit = Integer.parseInt(request.getParameter("limit"));

            ControllerUtil.sendAjaxResultFalse(response, jsonResult, null);
        }
        catch (Exception e) {
            ControllerUtil.sendAjaxResultFalse(response, jsonResult, null);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}