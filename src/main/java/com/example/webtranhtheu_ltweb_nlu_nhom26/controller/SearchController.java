package com.example.webtranhtheu_ltweb_nlu_nhom26.controller;

import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Category;
import com.example.webtranhtheu_ltweb_nlu_nhom26.bean.product.Product;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.CategoryService;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.ProductService;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.ProviderService;
import com.example.webtranhtheu_ltweb_nlu_nhom26.services.TopicService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

@WebServlet(name = "SearchController", value = "/search")
public class SearchController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        if (session.getAttribute("listCategory") == null) {
            session.setAttribute("listCategory", CategoryService.getNameAndPatternCategory());
        }

        //Hiển thị lần đầu
        int page = 1;
        int amount = 15;

        String keyword = request.getParameter("keyword");
//        List<Product> productResult = ProductService.findProductsByName(keyword, page, amount);
//        System.out.println(productResult);
//        if (productResult.isEmpty()) {
//            request.setAttribute("errorMessage", "<p class=\"d-flex justify-content-center align-items-center\">Không tìm thấy kết quả nào</p>");
//        }
//        else {
            List<Category> listCategory = CategoryService.getNameAndPatternCategory();
            request.setAttribute("listCategoryName", listCategory);
            //Cần tối ưu
            request.setAttribute("listCategory", CategoryService.getNameAndPatternCategory());
            request.setAttribute("listTopic", new TopicService().getListTopics());
            request.setAttribute("listProvider", ProviderService.getListProviders());
//            request.setAttribute("listProduct", productResult);
            request.getRequestDispatcher("/layout/search.jsp").forward(request, response);
//        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}